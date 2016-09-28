package com.umpay.ecommerce.insurance.service;

import com.umpay.ecommerce.core.model.CommonResp;
import com.umpay.ecommerce.insurance.service.bo.IssuranceBo;
import com.umpay.ecommerce.insurance.service.bo.PaybackBo;

public interface AppCenterService {
	
	/**
	 * @Description: 发起自助保险 
	 * @param issuranceBo
	 * @return CommonResp<String> 返回类型
	 * @author gaoxiang
	 * @date 2016年9月8日 下午3:18:30
	 */
	CommonResp<String> originateIssurance(IssuranceBo issuranceBo);
	
	/**
	 * @Description: 申请理赔
	 * @param issuranceBo
	 * @return CommonResp<String> 返回类型
	 * @author gaoxiang
	 * @date 2016年9月7日 下午6:15:08
	 */
	CommonResp<String> addPayback(PaybackBo paybackBo);
	
}
