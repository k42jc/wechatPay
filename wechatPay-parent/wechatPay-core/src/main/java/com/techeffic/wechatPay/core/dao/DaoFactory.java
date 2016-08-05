package com.techeffic.wechatPay.core.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
 * dao工厂
 * 直接面向实体dao接口
 * 解除具体数据库的实现 
 * 抽象工厂的spring实现
 * @author k42jc
 *
 */
@Component
public class DaoFactory {
	@Autowired
	private IWechatPayDao wechatPayDao;
}
