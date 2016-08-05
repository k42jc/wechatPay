package com.techeffic.wechatPay.lib.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 用于在运行期获取bean
 * @author k42jc
 *
 */
public class SpringContextHolder implements ApplicationContextAware{
	private static ApplicationContext applicationContext;
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		SpringContextHolder.applicationContext = applicationContext;
	}
	
	public static <T> T getBean(Class<T> clazz){
		return applicationContext.getBean(clazz);
	}
	
	public static Object getBean(String className){
		return applicationContext.getBean(className);
	}

}
