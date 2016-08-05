package com.techeffic.wechatPay.core.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.techeffic.wechatPay.core.service.ServiceFactory;
import com.techeffic.wechatPay.lib.common.WebContext;

/**
 * 基础控制器
 * 
 * @author k42jc
 *
 */
@ControllerAdvice
public class BaseController {
	protected WebContext webCtx;
	@Autowired
	protected ServiceFactory serviceFactory;
	
	/**
	 * 用于controller下所有@requestMapping注解下的异常回调处理
	 * 
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	public String handlerControllerException() {
		return "redirect:/50x.html";
	}
	
	@ModelAttribute
	public void init(HttpServletRequest request,HttpServletResponse response) throws IOException{
		/*if(webCtx == null){
			webCtx = WebContext(request, response);
		}else{
		}*/
		webCtx = WebContext.init(request,response);
	}
	
	

}
