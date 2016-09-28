package com.umpay.ecommerce.insurance.service.impl;

import org.springframework.stereotype.Service;
import com.umpay.ecommerce.core.model.CommonResp;
import com.umpay.ecommerce.insurance.service.AppCenterService;
import com.umpay.ecommerce.insurance.service.bo.IssuranceBo;
import com.umpay.ecommerce.insurance.service.bo.PaybackBo;
import com.umpay.ecommerce.insurance.service.contract.IssuranceContract;

@Service
public class AppCenterServiceImpl implements AppCenterService {
	
	@Override
	public CommonResp<String> addPayback(PaybackBo paybackBo) {
		return IssuranceContract.addPayback(paybackBo);
	}
	
	@Override
	public CommonResp<String> originateIssurance(IssuranceBo issuranceBo) {
		return IssuranceContract.originateIssurance(issuranceBo);
	}
	
}
