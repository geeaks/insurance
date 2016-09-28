package com.umpay.ecommerce.insurance.service;

import java.util.List;
import com.umpay.ecommerce.core.model.CommonResp;
import com.umpay.ecommerce.insurance.service.bo.IssuranceBo;
import com.umpay.ecommerce.insurance.service.bo.PaybackBo;

/**
 * @Description: 记录查询服务
 * @ClassName: RecordQueryService
 * @author gaoxiang
 * @date 2016年9月7日 下午6:06:12
 */ 
public interface RecordQueryService {
	
	/**
	 * @Description: 根据用户名获取投保的所有记录
	 * @param name 用户名
	 * @return List<IssuranceBo> 返回类型
	 * @author gaoxiang
	 * @date 2016年9月7日 下午6:10:29
	 */
	CommonResp<List<IssuranceBo>> queryIssurance(String name);
	
	/**
	 * @Description: 查询理赔记录
	 * @param name
	 * @return CommonResp<List<PaybackBo>> 返回类型
	 * @author gaoxiang
	 * @date 2016年9月7日 下午6:33:13
	 */
	CommonResp<List<PaybackBo>> queryPayback(String name);
	
}
