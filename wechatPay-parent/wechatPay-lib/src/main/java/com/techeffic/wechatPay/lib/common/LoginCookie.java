package com.techeffic.wechatPay.lib.common;

import java.util.Arrays;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 封装cookie用于登录操作
 * @author k42jc
 *
 */
public class LoginCookie {
	
	private static int defaultTime = 7*24*60*60;
	
	/**
	 * 添加Cookie
	 * @param webCtx
	 */
	public static void addCookie(HttpServletResponse response,String key,String value){
		Cookie loginCookie = new Cookie(key, value);
		loginCookie.setMaxAge(defaultTime);//保存7天
		loginCookie.setPath("/");//将cookie保存在根路径 便于其它请求访问
		response.addCookie(loginCookie);
	}
	
	/**
	 * 获取cookie键为key的值
	 * @param webCtx
	 * @param key
	 * @return
	 */
	public static String getCookie(HttpServletRequest request,String key){
		String value = null;
		Cookie[] cookies = request.getCookies();
		if(cookies == null){
//			System.out.println(webCtx.getRequest().getRequestURI()+"---cookie为空");
			return value;
		}/*else{
			System.out.println(webCtx.getRequest().getRequestURI()+"---cookie不为空");
		}*/
		for(int i=0;i<cookies.length;i++){
			if(key.equals(cookies[i].getName())){
				value = cookies[i].getValue();
				break;
			}
		}
		return value;
	}
	
	/**
	 * 清空cookie
	 * @param webCtx
	 */
	public static void clearCookie(HttpServletRequest request,HttpServletResponse response){
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie:cookies){
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
	}
}
