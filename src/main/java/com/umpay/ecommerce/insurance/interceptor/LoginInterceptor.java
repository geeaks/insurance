package com.umpay.ecommerce.insurance.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import com.umpay.ecommerce.insurance.service.bo.User;

/**
 * @Description: 登录拦截器
 * @ClassName: LoginInterceptor
 * @author gaoxiang
 * @date 2016年5月20日 上午10:37:48
 */ 
public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("session_user");
		if(user == null){
			logger.info("登陆超时，请重新登录,URL:"+request.getRequestURL());
			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath+"/");
			return false;
		}
		return true;
	}
	
}
