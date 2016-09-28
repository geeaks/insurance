package com.umpay.ecommerce.insurance.controller;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.umpay.ecommerce.core.model.CommonResp;
import com.umpay.ecommerce.insurance.controller.base.BaseController;
import com.umpay.ecommerce.insurance.service.RecordQueryService;
import com.umpay.ecommerce.insurance.service.bo.IssuranceBo;
import com.umpay.ecommerce.insurance.service.bo.PaybackBo;

/**
 * @Description: 记录查询控制器
 * @ClassName: RecordQueryController
 * @author gaoxiang
 * @date 2016年9月12日 上午9:52:54
 */ 
@Controller
@RequestMapping("/record")
public class RecordQueryController extends BaseController {
	
	@Resource
	RecordQueryService recordQueryService;
	
	@RequestMapping("issurance")
	String gotoIssurance(HttpSession session,Model model){
		CommonResp<List<IssuranceBo>> result = this.queryIssurance(session);
		model.addAttribute("list", result.getData());
		return "record/issuranceRecord";
	}
	
	@RequestMapping("queryIssurance")
	CommonResp<List<IssuranceBo>> queryIssurance(HttpSession session){
		return recordQueryService.queryIssurance(getUser(session).getName());
	}
	
	@RequestMapping("payback")
	String payback(HttpSession session,Model model){
		CommonResp<List<PaybackBo>> result = this.queryPayback(session);
		model.addAttribute("list", result.getData());
		return "record/paybackRecord";
	}
	
	@RequestMapping("queryPayback")
	CommonResp<List<PaybackBo>> queryPayback(HttpSession session){
		return recordQueryService.queryPayback(getUser(session).getName());
	}
	
}
