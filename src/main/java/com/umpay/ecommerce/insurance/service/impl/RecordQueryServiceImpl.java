package com.umpay.ecommerce.insurance.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.umpay.ecommerce.core.model.CommonResp;
import com.umpay.ecommerce.insurance.service.RecordQueryService;
import com.umpay.ecommerce.insurance.service.bo.IssuranceBo;
import com.umpay.ecommerce.insurance.service.bo.PaybackBo;
import com.umpay.ecommerce.insurance.service.contract.IssuranceContract;

@Service
public class RecordQueryServiceImpl implements RecordQueryService {
	
	
	@Override
	public CommonResp<List<IssuranceBo>> queryIssurance(String name) {
		return IssuranceContract.queryIssurance(name);
	}

	@Override
	public CommonResp<List<PaybackBo>> queryPayback(String name) {
		return IssuranceContract.queryPayback(name);
	}
	
}
