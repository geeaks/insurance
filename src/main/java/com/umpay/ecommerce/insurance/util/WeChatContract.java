package com.umpay.ecommerce.insurance.util;

import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.alibaba.fastjson.JSON;
import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.umpay.ecommerce.insurance.service.bo.IssuranceBo;
import com.umpay.ecommerce.insurance.service.contract.base.EthContract;
import com.umpay.ethrpc4j.util.Util;
import com.umpay.util.ToolBox;

public class WeChatContract extends EthContract {
	
	private final static Logger logger = LoggerFactory.getLogger(WeChatContract.class);
	
	public static List<String> queryMsg(String key) {
		List<String> list = Lists.newArrayList();
		try {
			String methodID = StringUtils.substring(client.web3().sha3(Util.ascii2Hex("getIssuranceLength(uint256)")), 0, 10)
					+ String.format("%064X", Long.valueOf(HashCodeBuilder.reflectionHashCode(key + 1)));
			logger.debug("methodID:" + methodID);
			Map<String, String> req = getRequest(methodID);
			// 数组长度
			logger.debug("查询数组长度入参:" + JSON.toJSONString(req));
			String call = client.eth().call(req);
			logger.debug("查询数组长度出参:" + JSON.toJSONString(call));
			String arrLength = StringUtils.substring(call.substring(2), 48, 64);
			Long length = Long.valueOf(arrLength, 16);
			if (length==0) {
				logger.info("查询数组长度失败");
				return null;
			}
			// 遍历获取数组中每个元素
			for (long m = 0; m < length; m++) {
				StringBuilder sb = new StringBuilder();
				for (int len = 1; len < 20; len++) {
					String data = StringUtils.substring(client.web3().sha3(Util.ascii2Hex("getIssurance(uint256,uint256)")), 0, 10)
							+ String.format("%064X", Long.valueOf(HashCodeBuilder.reflectionHashCode(key + len)))
							+ String.format("%064X", Long.valueOf(m));
					req.put("data", data);
					logger.debug("查询数组数据入参:" + JSON.toJSONString(req));
					String call2 = client.eth().call(req);
					logger.debug("查询数组数据出参:" + call2);
					if("0x".equals(call2)){
						break;
					}
					String trimToEmpty = StringUtils.trimToEmpty(new String(ToolBox.hex2b(call2.substring(130)), "UTF-8"));
					sb.append(trimToEmpty);
				}
				if(StringUtils.isNotBlank(sb.toString())) list.add(sb.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.debug("查询数据出参:" + JSON.toJSONString(list));
		return list;
	}
	
	public static void addMsg(String key, String value) throws Exception {
		String methodId = StringUtils.substring(client.web3().sha3(Util.ascii2Hex("setIssurance(uint256,string)")), 0, 10);
		int i = value.length() % 32 == 0 ? value.length() / 32 + 1 : value.length() / 32 + 2;
		for (int len = 1; len < i; len++) {
			byte[] bytes = StringUtils.substring(value, (len-1)*32,len*32).getBytes(Charsets.UTF_8);
			byte[] message = new byte[(bytes.length / 32 + 1) * 32];
			System.arraycopy(bytes, 0, message, 0, bytes.length);
			logger.debug("methodId:" + methodId);
			String data = methodId 
					+ String.format("%064X", Long.valueOf(HashCodeBuilder.reflectionHashCode(key + len)))
					+ String.format("%064X", Long.valueOf(64)) 
					+ String.format("%064X", bytes.length) 
					+ ToolBox.b2HEX(message);
			Map<String, String> request = getRequest(data);
			logger.debug("新增数据入参:" + JSON.toJSONString(request));
			String result = client.eth().sendTransaction(request);
			logger.debug("新增数据出参:" + result);
		}
	}
	
	public static void main(String[] args) {
		try {
			IssuranceBo issuranceBo = new IssuranceBo();
			issuranceBo.setUserName("王铁蛋3");
			issuranceBo.setAmount("880");
			issuranceBo.setEndDate("2016-09-16");
			issuranceBo.setStartDate("2016-09-15");
			issuranceBo.setIssuranceName("阳光百年");
			issuranceBo.setIssuranceDesc("千秋万载一统江湖");
			String key = issuranceBo.getUserName() + issuranceBo.getIssuranceName();
			String value = KryoUtil.serializationObject(issuranceBo);
			WeChatContract.addMsg(key, value);
			List<String> list = WeChatContract.queryMsg(key);
			if (list == null || list.size() == 0)
				return;
			for (String str : list) {
				IssuranceBo parseObject = KryoUtil.deserializationObject(str,IssuranceBo.class);
				System.out.println(JSON.toJSONString(parseObject));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
