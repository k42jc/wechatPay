package com.techeffic.wechatPay.core.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techeffic.wechatPay.lib.util.Log4jUtil;
import com.techeffic.wechatPay.lib.util.QrCodeUtil;
/**
 * 微信调用接口
 * @author k42jc
 *
 */
@Controller
@RequestMapping("wechat")
public class WechatPayController extends BaseController{
	/**
	 * 支付接口
	 * @param request
	 * @param response
	 * @param payWay 支付方式 扫码支付为NATIVE 公众号支付未JSAPI
	 */
	@RequestMapping("/pay/{payWay}")
	public void pay(HttpServletRequest request,HttpServletResponse response,@PathVariable String payWay){
		String code_url = "";
		try {
			code_url = this.serviceFactory.wechatPayService.pay(request,payWay);
		} catch (Exception e) {
			e.printStackTrace();
			Log4jUtil.error("请求支付接口失败！", e);
		}
		if(!StringUtils.isEmpty(payWay) && "NATIVE".equals(payWay)){//扫码支付直接将
			Log4jUtil.info("".equals(code_url)?"二维码为空！！！！！！！":"调用支付接口成功，二维码链接为："+code_url);
			//生成二维码图片并直接以流的形式输出到页面
			QrCodeUtil.encodeQrcode(code_url, response);
		}
	}
	
	@RequestMapping("callback")
	public void callback(){
		Log4jUtil.info("微信支付成功回调");
	}
}
