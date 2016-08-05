package com.techeffic.wechatPay.core.dao;

import org.springframework.stereotype.Repository;

@Repository
public class WechatPayDao extends BaseJdbcDao implements IWechatPayDao{
	public void delete(){
		this.delete("xxx", 1);
	}
}
