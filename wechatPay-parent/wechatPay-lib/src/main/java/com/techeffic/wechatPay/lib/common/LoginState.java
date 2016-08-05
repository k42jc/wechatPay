package com.techeffic.wechatPay.lib.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 登录状态对象
 * @author k42jc
 *
 */
public class LoginState {
	private static String userId;
	private static boolean isLogin;
	private HttpServletResponse response;
	
	public LoginState(HttpServletRequest request,HttpServletResponse response){
		this.response = response;
		userId = LoginCookie.getCookie(request, "userId");
		isLogin = (userId != null);
	}
	public String getUserId() {
		return userId;
	}
	public boolean isLogin() {
		return isLogin;
	}
	/**
	 * 用户登录操作
	 * @param userId
	 */
	public void userLogin(String userId) {
		LoginCookie.addCookie(response, "userId", userId);
	}
	
}
