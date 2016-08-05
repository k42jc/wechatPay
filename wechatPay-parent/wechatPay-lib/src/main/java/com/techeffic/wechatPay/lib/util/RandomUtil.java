package com.techeffic.wechatPay.lib.util;

import java.util.Random;

/**
 * 
 * @author k42jc
 *
 */
public class RandomUtil {
	/**
     * 获取一定长度的随机字符串 微信支付默认随机数生成规则
     * @param length 指定字符串长度
     * @return 一定长度的字符串
     */
    public static String getRandomStringByLength(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}
