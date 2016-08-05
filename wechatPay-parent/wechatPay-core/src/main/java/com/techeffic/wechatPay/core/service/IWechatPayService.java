package com.techeffic.wechatPay.core.service;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * 微信支付接口
 * @author k42jc
 *
 */
public interface IWechatPayService {
	
	/**
	 * 支付方法
	 * @param payWay 支付方式 支持NATIVE和JSPAI
	 * @param orderInfo 订单信息
	 * @return 返回二维码code_url
	 * @throws IOException 
	 * @throws KeyStoreException 
	 * @throws NoSuchAlgorithmException 
	 * @throws KeyManagementException 
	 * @throws UnrecoverableKeyException 
	 */
	public String pay(HttpServletRequest request, String payWay);
}
