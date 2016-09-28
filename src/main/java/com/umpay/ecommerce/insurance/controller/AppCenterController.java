package com.umpay.ecommerce.insurance.controller;

import java.util.Date;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.umpay.ecommerce.core.model.CommonResp;
import com.umpay.ecommerce.insurance.controller.base.BaseController;
import com.umpay.ecommerce.insurance.service.AppCenterService;
import com.umpay.ecommerce.insurance.service.bo.IssuranceBo;
import com.umpay.ecommerce.insurance.service.bo.PaybackBo;

/**
 * @Description: 应用中心控制器
 * @ClassName: AppCenterController
 * @author gaoxiang
 * @date 2016年9月12日 上午9:52:35
 */ 
@Controller
@RequestMapping("/appCenter")
public class AppCenterController extends BaseController {
	
	@Resource
	AppCenterService appCenterService;
	
	@RequestMapping("/gotoOriginateIssurance")
	String gotoinsure(HttpSession session,Model model){
		return "appcenter/originateIssurance";
	}
	
	@RequestMapping("/originateIssurance")
	String insure(IssuranceBo issuranceBo,HttpSession session,Model model){
		issuranceBo.setUserName(getUser(session).getName());
		CommonResp<String> commonResp = appCenterService.originateIssurance(issuranceBo);
		if(commonResp.isSuccess()){
			return "common/success";
		}
		model.addAttribute("msg", commonResp.getMsg());
		return "common/fail";
	}
	
	@RequestMapping("/gotoPayback")
	String payback(HttpSession session,Model model){
		return "appcenter/payback";
	}
	
	@RequestMapping("/payback")
	String payback(PaybackBo paybackBo,HttpSession session,Model model){
		paybackBo.setUserName(getUser(session).getName());
		paybackBo.setPaybackDate(DateFormatUtils.format(new Date(), "yyyy-MM-dd"));
		CommonResp<String> commonResp = appCenterService.addPayback(paybackBo);
		if(commonResp.isSuccess()){
			return "common/success";
		}
		model.addAttribute("msg", commonResp.getMsg());
		return "common/fail";
	}
	
}
