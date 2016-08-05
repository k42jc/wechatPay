package com.techeffic.wechatPay.lib.util;

import javax.servlet.http.Cookie;

import com.techeffic.wechatPay.lib.common.WebContext;

/**
 * cookie操作
 * 
 * @author RD_haitao_ou
 *
 */
public class CookieUtil {

	/**
	 * 构建一个cookie <br/>
	 * RD_haitao_ou<br/>
	 * 上午11:46:44<br/>
	 * 
	 * @param key
	 * @param value
	 * @param max
	 * @return<br/>
	 */
	public final static Cookie buildCookie(WebContext webCtx, String key, String value, Integer max) {
		Cookie cookie = new Cookie(key, value);
		cookie.setPath("/");
		if (max != null) {
			cookie.setMaxAge(max);
		}
		String domain = webCtx.getDomain();
		if (!(domain.indexOf("localhost") >= 0 || StringUtil.isIP(domain))) {
			String[] subs = domain.split("\\.");
			if (subs.length >= 3) {
				cookie.setDomain(subs[subs.length - 2] + "." + subs[subs.length - 1]);
			}
		}
		return cookie;
	}

	/**
	 * 增加cookie <br/>
	 * RD_haitao_ou<br/>
	 * 下午2:01:28<br/>
	 * 
	 * @param response
	 * @param key
	 * @param value
	 * @param max<br/>
	 */
	public final static void addCookie(WebContext webCtx, String key, String value, Integer max) {
		Cookie cookie = buildCookie(webCtx, key, value, max);
		webCtx.getResponse().addCookie(cookie);
	}

	/**
	 * 增加cookie <br/>
	 * RD_haitao_ou<br/>
	 * 下午2:01:34<br/>
	 * 
	 * @param response
	 * @param key
	 * @param value<br/>
	 */
	public final static void addCookie(WebContext webCtx, String key, String value) {
		addCookie(webCtx, key, value, null);
	}
	/**
	 * 删除cookie
	 * @param webCtx
	 * @param key 保存cookie的key
	 */
	public final static void removeCookie(WebContext webCtx,String key){
		Cookie cookie = new Cookie(key, null);
		cookie.setMaxAge(0);
	}
}
