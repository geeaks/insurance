package com.umpay.ecommerce.insurance.service.contract;

import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.alibaba.fastjson.JSON;
import com.google.common.base.Charsets;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.umpay.ecommerce.core.model.CommonResp;
import com.umpay.ecommerce.insurance.service.bo.IssuranceBo;
import com.umpay.ecommerce.insurance.service.bo.PaybackBo;
import com.umpay.ecommerce.insurance.service.contract.base.EthContract;
import com.umpay.ecommerce.insurance.util.KryoUtil;
import com.umpay.ethrpc4j.util.Util;
import com.umpay.util.ToolBox;

/**
 * @Description: 自助保险合约
 * @ClassName: InssuranceContract
 * @author gaoxiang
 * @date 2016年9月8日 上午11:15:56
 */
public class IssuranceContract extends EthContract {
	
	private final static Logger logger = LoggerFactory.getLogger(IssuranceContract.class);
	
	public static CommonResp<String> originateIssurance(IssuranceBo issuranceBo) {
		CommonResp<String> commonResp = new CommonResp<String>();
		try {
			String value = KryoUtil.serializationObject(issuranceBo);
			String methodId = StringUtils.substring(client.web3().sha3(Util.ascii2Hex("setIssurance(uint256,string)")), 0, 10);
			int i = value.length() % 32 == 0 ? value.length() / 32 + 1 : value.length() / 32 + 2;
			for (int len = 1; len < i; len++) {
				byte[] bytes = StringUtils.substring(value, (len-1)*32,len*32).getBytes(Charsets.UTF_8);
				byte[] message = new byte[(bytes.length / 32 + 1) * 32];
				System.arraycopy(bytes, 0, message, 0, bytes.length);
				logger.debug("methodId:"+methodId);
				String data = methodId 
						+ String.format("%064X", Long.valueOf(HashCodeBuilder.reflectionHashCode("Issurance"+issuranceBo.getUserName()+len))) 
						+ String.format("%064X", Long.valueOf(64))
						+ String.format("%064X", bytes.length) 
						+ ToolBox.b2HEX(message);
				Map<String, String> request = getRequest(data);
				logger.debug("新增自助保险入参:"+ JSON.toJSONString(request));
				String result = client.eth().sendTransaction(request);
				logger.debug("新增自助保险,出参:" + result);
				if(Strings.isNullOrEmpty(result)){
					commonResp.setCode(-1);
					commonResp.setMsg("调用区块链存储信息失败");
					return commonResp;
				}
				commonResp.success();
				commonResp.setData(data);
			}
		} catch (Exception e) {
			logger.error("新增自助保险异常",e);
			commonResp.fail();
		}
		return commonResp;
	}
	
	public static CommonResp<List<IssuranceBo>> queryIssurance(String userName) {
		logger.info("获取【" + userName + "】参保的互助保险项目");
		CommonResp<List<IssuranceBo>> commonResp = new CommonResp<List<IssuranceBo>>();
		try {
			String methodID = StringUtils.substring(client.web3().sha3(Util.ascii2Hex("getIssuranceLength(uint256)")), 0, 10)
					+ String.format("%064X", Long.valueOf(HashCodeBuilder.reflectionHashCode("Issurance"+userName + 1)));
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
				commonResp.exception();
				return commonResp;
			}
			List<IssuranceBo> list = Lists.newArrayList();
			// 遍历获取数组中每个元素
			for (long m = 0; m < length; m++) {
				StringBuilder sb = new StringBuilder();
				for (int len = 1; len < 20; len++) {
					String data = StringUtils.substring(client.web3().sha3(Util.ascii2Hex("getIssurance(uint256,uint256)")), 0, 10)
							+ String.format("%064X", Long.valueOf(HashCodeBuilder.reflectionHashCode("Issurance"+userName + len)))
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
				if(StringUtils.isNotBlank(sb.toString())) list.add(KryoUtil.deserializationObject(sb.toString(),IssuranceBo.class));
			}
			commonResp.success();
			commonResp.setData(list);
			logger.debug("查询数据出参:"+ JSON.toJSONString(list));
		} catch (Exception e) {
			logger.error("获取【" + userName + "】参保的互助保险项目异常",e);
			commonResp.exception();
		}
		return commonResp;
	}
	
	public static CommonResp<String> addPayback(PaybackBo paybackBo) {
		CommonResp<String> commonResp = new CommonResp<String>();
		try {
			String value = KryoUtil.serializationObject(paybackBo);
			String methodId = StringUtils.substring(client.web3().sha3(Util.ascii2Hex("setPayback(uint256,string)")), 0, 10);
			int i = value.length() % 32 == 0 ? value.length() / 32 + 1 : value.length() / 32 + 2;
			for (int len = 1; len < i; len++) {
				byte[] bytes = StringUtils.substring(value, (len-1)*32,len*32).getBytes(Charsets.UTF_8);
				byte[] message = new byte[(bytes.length / 32 + 1) * 32];
				System.arraycopy(bytes, 0, message, 0, bytes.length);
				logger.debug("methodId:"+methodId);
				String data = methodId 
						+ String.format("%064X", Long.valueOf(HashCodeBuilder.reflectionHashCode("Payback"+paybackBo.getUserName()+len))) 
						+ String.format("%064X", Long.valueOf(64))
						+ String.format("%064X", bytes.length) 
						+ ToolBox.b2HEX(message);
				Map<String, String> request = getRequest(data);
				logger.debug("新增理赔记录入参:"+ JSON.toJSONString(request));
				String result = client.eth().sendTransaction(request);
				logger.debug("新增理赔记录出参:" + result);
				if(Strings.isNullOrEmpty(result)){
					commonResp.setCode(-1);
					commonResp.setMsg("调用区块链存储理赔记录信息失败");
					return commonResp;
				}
				commonResp.success();
				commonResp.setData(data);
			}
		} catch (Exception e) {
			logger.error("新增理赔记录异常",e);
			commonResp.fail();
		}
		return commonResp;
	}
	
	public static CommonResp<List<PaybackBo>> queryPayback(String userName) {
		logger.info("获取【" + userName + "】理赔记录入参:"+userName);
		CommonResp<List<PaybackBo>> commonResp = new CommonResp<List<PaybackBo>>();
		try {
			String methodID = StringUtils.substring(client.web3().sha3(Util.ascii2Hex("getPaybackLength(uint256)")),0, 10) 
					+ String.format("%064X", Long.valueOf(HashCodeBuilder.reflectionHashCode("Payback"+userName+1)));
			logger.debug("methodID:"+methodID);
			Map<String, String> req = getRequest(methodID);
			// 数组长度
			logger.debug("查询数组长度入参:" + JSON.toJSONString(req));
			String call = client.eth().call(req);
			logger.debug("查询数组长度出参:" + JSON.toJSONString(call));
			String arrLength = StringUtils.substring(call.substring(2), 48, 64);
			Long length = Long.valueOf(arrLength, 16);
			if (length==0) {
				logger.info("查询数组长度失败");
				commonResp.exception();
				return commonResp;
			}
			List<PaybackBo> list = Lists.newArrayList();
			//遍历获取数组中每个元素
			// 遍历获取数组中每个元素
			for (long m = 0; m < length; m++) {
				StringBuilder sb = new StringBuilder();
				for (int len = 1; len < 20; len++) {
					String data = StringUtils.substring(client.web3().sha3(Util.ascii2Hex("getPayback(uint256,uint256)")), 0, 10)
							+ String.format("%064X", Long.valueOf(HashCodeBuilder.reflectionHashCode("Payback"+userName + len)))
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
				if(StringUtils.isNotBlank(sb.toString())) list.add(KryoUtil.deserializationObject(sb.toString(),PaybackBo.class));
			}
			commonResp.success();
			commonResp.setData(list);
			logger.debug("查询数据出参:"+ JSON.toJSONString(list));
			logger.info("获取【" + userName + "】理赔记录出参:"+ JSON.toJSONString(commonResp));
		} catch (Exception e) {
			logger.error("获取【" + userName + "】理赔记录",e);
		}
		return commonResp;
	}
	
	public static void main(String[] args) {
		try {
			String userName = "王仨妞";
			IssuranceBo issuranceBo = new IssuranceBo();
			issuranceBo.setUserName(userName);
			issuranceBo.setAmount("880");
			System.out.println("新增出参:"+IssuranceContract.originateIssurance(issuranceBo));
			System.out.println("查询出参:"+IssuranceContract.queryIssurance(userName));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
