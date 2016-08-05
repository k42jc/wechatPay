package com.techeffic.wechatPay.core.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 * jdbc基础dao
 * @author k42jc
 *
 * @param <E>
 */
public abstract class BaseJdbcDao{
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	protected void delete(String tableName,long id){
		Map<String,Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		jdbcTemplate.update("delete from "+tableName+" where id=:id", paramMap);
	}

}
