package com.techeffic.wechatPay.lib.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jetbrick.web.servlet.RequestUtils;

/**
 * 系统参数类
 * 绑定系统常用参数
 * httpServletRequest httpServletResponse jetTemplate的元数据模板
 * @author k42jc
 *
 */
public class WebContext {
	private LoginState loginState;
	private ClientType clientType;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public ClientType getClientType() {
		return clientType;
	}
	

	public HttpServletRequest getRequest() {
		return request;
	}




	public HttpServletResponse getResponse() {
		return response;
	}




	public LoginState getLoginState() {
		return loginState;
	}


	private WebContext(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		loginState = new LoginState(request,response);
		clientType = new ClientType(request);
	}
	
	public static WebContext init(HttpServletRequest request, HttpServletResponse response){
		return new WebContext(request, response);
	}

	
	/**
	 * 取得域名
	 */
	public String getDomain() {
		String domain = getDomainWithPort();
		if (domain.indexOf(":") > 0) {
			domain = domain.substring(0, domain.indexOf(":"));
		}
		return domain;
	}
	
	public String getDomainWithPort() {
		StringBuffer url = request.getRequestURL();
		String domain = url.delete(url.length() - request.getRequestURI().length(), url.length()).delete(0, 7)
				.toString();
		return domain;
	}
	
	/**
	 * 获取用户真实ip地址
	 * @return
	 */
	public String getIP(){
		return RequestUtils.getClientIPAddress(request);
	}
	
	/**
	 * 用户登录
	 * @param userId
	 */
	/*public void userLogin(String userId){
		LoginCookie.addCookie(this, "userId", userId);
	}*/
	
}
