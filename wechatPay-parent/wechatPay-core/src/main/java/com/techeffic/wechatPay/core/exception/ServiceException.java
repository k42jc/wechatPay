package com.techeffic.wechatPay.core.exception;

/**
 * 自定义异常
 * @author xudong_liao<br/>
 * @date 2015年12月24日<br/>
 */
public class ServiceException extends RuntimeException{

	public ServiceException(String error) {
		super(error);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -7307148408747507363L;

}
