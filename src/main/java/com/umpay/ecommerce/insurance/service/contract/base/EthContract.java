package com.umpay.ecommerce.insurance.service.contract.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.io.FileUtils;
import org.springframework.util.ResourceUtils;
import com.alibaba.fastjson.JSON;
import com.google.common.base.Charsets;
import com.google.common.collect.Maps;
import com.umpay.ethrpc4j.EthereumClient;

public class EthContract {
	
	public static EthereumClient client = null;
	
	public static final String URL = "http://10.10.67.222:8545";
	
//	public static final String ADDRESS = "0x54a19cb62e0d54d3a45431cb2f1e77febaad35fc";
	public static final String ADDRESS = "0x0090bd63dad6a3f6139f3913503cb349773229f3";
	
	public static final String ACCOUNT = "0x72617e82ae5d5fe8bdbaa8e6c883c7042fedcccb";
	
	static{
		try {
			client = EthereumClient.getInstanceByURL(new URL(URL));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	public static Map<String, String> getRequest(String data) {
		Map<String, String> req = Maps.newHashMapWithExpectedSize(8);
		req.put("to", ADDRESS);
		req.put("data", data);
		req.put("from", ACCOUNT);
		return req;
	}
	
	/**
	 * @Description: 编译部署合约
	 * @return String 返回类型
	 * @author gaoxiang
	 * @date 2016年9月9日 上午11:16:46
	 */
	@SuppressWarnings("unchecked")
	public static String deploySolidity(String path){
		try {
			String contract = FileUtils.readFileToString(ResourceUtils.getFile(path),Charsets.UTF_8);
			Map<?, ?> result = client.eth().compileSolidity(contract);
			Map<String, String> obj = (LinkedHashMap<String, String>) result.get("IssuranceContract");
			Map<String,String> map = EthContract.getRequest(obj.get("code"));
			map.put("gas","0x" + Long.toHexString(900000));
			map.remove("to");
			System.out.println("部署合约入参:"+JSON.toJSONString(map));
			String deployResult = client.eth().sendTransaction(map);
			System.out.println("部署合约出参:"+deployResult);
			return deployResult;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	/**
	 * @Description: 获取部署合约结果
	 * @return String 返回类型
	 * @author gaoxiang
	 * @date 2016年9月9日 上午11:16:46
	 */
	public static boolean getDeployResult(String contractId){
		try {
			Map<?, ?> result = client.eth().getTransactionReceipt(contractId);
			System.out.println("合约部署状态查询出参:"+JSON.toJSONString(result));
			if(result != null)
			System.out.println("合约部署地址:"+result.get("contractAddress"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static void printAccounts(){
		try {
			List<String> accounts = client.eth().accounts();
			for(String account : accounts){
				System.out.println(account);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
//		EthContract.deploySolidity("classpath:IssuranceContract.sol");
		EthContract.getDeployResult("0xd1ebed70fab63a06c7d9a43bfae88af954bbb231e8e7f7c35d8ea726131ea9d7");
//		EthContract.printAccounts();
	}
}
