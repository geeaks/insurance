package com.umpay.ecommerce.insurance.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.umpay.ecommerce.insurance.controller.base.BaseController;
import com.umpay.ecommerce.insurance.service.bo.User;

@Controller
public class IndexController extends BaseController {
	
	/**
	 * @Description: 登录页
	 * @return String 返回类型
	 * @author gaoxiang
	 * @date 2015年12月1日 下午10:13:54
	 */
	@RequestMapping({"","index"})
	public String index(HttpServletRequest request,HttpSession session,Model model){
		model.addAttribute("user",new User("王大王","女","21"));
		return "index";
	}
	
	/**
	 * @Description: 用户登录
	 * @param loginId 登录名
	 * @param password 登录密码
	 * @param checkCode 图片校验码
	 * @return String 返回类型
	 * @author gaoxiang
	 * @date 2015年12月1日 下午10:13:25
	 */
	@RequestMapping("/login")
	public String login(String loginId,String password,HttpSession session,HttpServletRequest request,Model model){
		session.setAttribute(session_user_key, new User(loginId,"女","21"));
		//正常跳转首页
		return "redirect:home";
	}
	
	@RequestMapping("/home")
	public String home(String loginId,String password,String checkCode,HttpSession session,HttpServletRequest request,Model model){
		return "home/index";
	}
	
	/**
	 * @Description: 登出
	 * @param session
	 * @return String 返回类型
	 * @author gaoxiang
	 * @date 2015年11月27日 下午7:19:05
	 */
	@RequestMapping("/logOut")
	public String logOut(HttpSession session){
		session.invalidate();
		return "index";
	}
	
}
