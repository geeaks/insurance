package com.umpay.ecommerce.insurance.controller.base;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.umpay.ecommerce.insurance.service.bo.User;

/**
 * @Description: 基础控制器类
 * @ClassName: BaseController
 * @author gaoxiang
 * @date 2015年11月29日 下午2:46:10
 */ 
@Component
public class BaseController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(getClass());
	
	public final String session_user_key="session_user";
	
	/**
	 * @Description: 正则匹配
	 * @param regex
	 * @param str
	 * @return boolean 返回类型
	 * @author gaoxiang
	 * @date 2015年11月12日 下午3:28:32
	 */
	public boolean match(String regex, String str) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}
	
	public User getUser(HttpSession session) {
		return (User) session.getAttribute(session_user_key);
	}
	
	/**
	 * @Description: 获取map里的某个对象
	 * @param map 
	 * @param key
	 * @return T 返回类型
	 * @author gaoxiang
	 * @date 2015年11月13日 下午6:21:53
	 */
	@SuppressWarnings("unchecked")
	public <T> T getMapObject(Map<String,Object> map,String key){
		T t = null;
		try {
			t = (T) map.get(key);
		} catch (Exception e) {
			LOGGER.error("类型转换异常",e);
		}
		return t;
	}
	
}
