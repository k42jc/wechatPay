package com.techeffic.wechatPay.lib.common;

/**
 * 微信配置
 * 
 * @author k42jc
 *
 */
public class WechatConfig {
	// appid
	public final static String appid = "wx92d2771c6cbe3c2a";
	// 商户id
	public final static String mch_id = "1228636302";
	// 设备号
	public final static String device_info = "WEB";
	// 支付类型 -- 扫码
	public final static String trade_type_native = "NATIVE";
	// 支付类型 -- 公众号
	public final static String trade_type_jsapi = "JSAPI";
	// 这个就是自己要保管好的私有Key了（切记只能放在自己的后台代码里，不能放在任何可能被看到源代码的客户端程序中）
	// 每次自己Post数据给API的时候都要用这个key来对所有字段进行签名，生成的签名会放在Sign这个字段，API收到Post数据的时候也会用同样的签名算法对Post过来的数据进行签名和验证
	// 收到API的返回的时候也要用这个key来对返回的数据算下签名，跟API的Sign数据进行比较，如果值不一致，有可能数据被第三方给篡改

	public final static String key = "cfca18d11f9b059941ed9b424pinshan";
	
	/*//HTTPS证书的本地路径
	private static String certLocalPath = Class.class.getClass().getResource("/").getPath();

	//HTTPS证书密码，默认密码等于商户号MCHID
	private static String certPassword = "1228636302";

	public static String getCertLocalPath(){
		return certLocalPath;
	}
	
	public static String getCertPassword(){
		return certPassword;
	}*/

}
