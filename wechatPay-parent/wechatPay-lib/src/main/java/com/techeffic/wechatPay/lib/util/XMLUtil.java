package com.techeffic.wechatPay.lib.util;

import java.util.Map;

/**
 * xml转换工具类
 * 
 * @author xudong_liao<br/>
 * @date 2016年1月5日<br/>
 */
public class XMLUtil {

	/**
	 * 微信支付所需要的map转换为xml工具方法
	 * @param map
	 * @return
	 */
	public static String mapToXml(Map<String, Object> map) {
		StringBuffer sb = new StringBuffer();
		sb.append("<xml>");
		for (String key : map.keySet()) {
			// System.out.println(key + "========" + map.get(key));

			String value = "<![CDATA[" + map.get(key) + "]]>";
			sb.append("<" + key + ">" + value + "</" + key + ">");
			// System.out.println();
		}
		sb.append("</xml>");
		return sb.toString();

	}

}
