package com.techeffic.wechatPay.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * service工厂
 * @author k42jc
 *
 */
@Component
public class ServiceFactory {
	@Autowired
	public IWechatPayService wechatPayService;
}
