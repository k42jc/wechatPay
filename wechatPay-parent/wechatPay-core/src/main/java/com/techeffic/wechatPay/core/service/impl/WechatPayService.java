package com.techeffic.wechatPay.core.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.techeffic.wechatPay.core.service.BaseService;
import com.techeffic.wechatPay.core.service.IWechatPayService;
import com.techeffic.wechatPay.lib.common.WechatConfig;
import com.techeffic.wechatPay.lib.util.HttpClientUtil;
import com.techeffic.wechatPay.lib.util.Log4jUtil;
import com.techeffic.wechatPay.lib.util.RandomUtil;
import com.techeffic.wechatPay.lib.util.SignUtil;
import com.techeffic.wechatPay.lib.util.XMLUtil;

/**
 * 微信支付service
 * @author k42jc
 *
 */
@Service
public class WechatPayService extends BaseService implements IWechatPayService{
	private final static String payUrl = "https://api.mch.weixin.qq.com/pay/unifiedorder";
	public String pay(HttpServletRequest request,String payWay){
		if(StringUtils.isEmpty(payWay)){
			throw new RuntimeException("需要指定支付方式！");
		}
		Map<String, Object> paramMap = new HashMap<String, Object>();
//		IServiceRequest httpsRequest = new HttpsRequest();
		paramMap.put("appid", WechatConfig.appid); // appid
		paramMap.put("mch_id", WechatConfig.mch_id); // 商户号
		paramMap.put("device_info", WechatConfig.device_info); // 交易类型
		paramMap.put("nonce_str", RandomUtil.getRandomStringByLength(32)); // 随机数
		paramMap.put("body", "支付测试"); // 描述
		paramMap.put("out_trade_no", RandomUtil.getRandomStringByLength(32)); // 商户后台的贸易单号
		paramMap.put("total_fee", 1); // 金额必须为整数 单位为分
		String ip = request.getRequestURI();//.getIP();
		//Log4jUtil.info("ip--"+ip);
		paramMap.put("spbill_create_ip", ip); // 本机的Ip
		paramMap.put("notify_url", "http://www.techeffic.com/wechatPay/callback.action"); // 支付成功后，回调地址
		paramMap.put("trade_type", WechatConfig.trade_type_native); // 交易类型
		//String mapXml = XMLUtil.mapToXml(paramMap);
		//Log4jUtil.info("mapXml--"+mapXml);
		paramMap.put("product_id", RandomUtil.getRandomStringByLength(32)); // 商品id NATIVE时必填
		paramMap.put("openid", "需要获取用户的openid"); // openid JSAPI时必填
		String sign = SignUtil.getSign(paramMap, WechatConfig.key);//生成前面需要所有参数与商户key
		//Log4jUtil.info("sign--"+sign);
		//Log4jUtil.info("key--"+WechatConfig.key);
		paramMap.put("sign", sign);// 根据微信签名规则，生成签名
		String paramXml = XMLUtil.mapToXml(paramMap);//转换成xml
		//Log4jUtil.info("paramXml--"+paramXml);
		String resXml = HttpClientUtil.postData(payUrl, paramXml);
//			String resXml = httpsRequest.sendPost(payUrl, XMLUtil.mapToXml(paramMap));
		//Log4jUtil.info(resXml);
		Document dd = null;
		String code_url=null;
		String prepay_id = null;//微信生成的预支付回话标识，用于后续接口调用中使用
		try {
			dd = DocumentHelper.parseText(resXml);
		} catch (DocumentException e) {
			return ""; 
		}
		if (dd != null) {
			Element root = dd.getRootElement();
			if("SUCCESS".equals(root.element("return_code").getText())){//成功调用
				code_url = root.element("code_url").getText();  //解析 xml 获得 code_url
				prepay_id = root.element("prepay_id").getText();
			}
		}
		if("NATIVE".equals(payWay)){
			return code_url;//扫码支付返回二维码链接 用于生成二维码
		}else if("JSAPI".equals(payWay)){
			return prepay_id;//公众号支付返回预支付id 用于后续调用
		}else{
			Log4jUtil.error("无效支付方式！");
			throw new RuntimeException("无效支付方式！");
		}
	}

}
