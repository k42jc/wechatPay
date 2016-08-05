package com.techeffic.wechatPay.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techeffic.wechatPay.core.dao.DaoFactory;
@Service
public class BaseService {
	@Autowired
	private DaoFactory daoFactory;
}
