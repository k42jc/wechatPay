package com.techeffic.wechatPay.lib.util;

public class Log4jUtil {
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Log4jUtil.class);

	public static void debug(Object message) {
		logger.debug(message);
	}

	public static void debug(Object message, Throwable t) {
		logger.debug(message, t);
	}

	public static void info(Object message) {
		logger.info(message);
	}

	public static void info(Object message, Throwable t) {
		logger.info(message, t);
	}

	public static void error(Object message) {
		logger.error(message);
	}

	public static void error(Object message, Throwable t) {
		logger.error(message, t);
	}
}
