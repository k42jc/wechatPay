package com.techeffic.wechatPay.lib.util;

import org.apache.commons.codec.binary.Base32;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * 使用多重信息摘要算法加密工具类 翻译自md5.js
 * 
 * @author xudong_liao<br/>
 * @date 2016年2月2日<br/>
 */
public class EncryptUtil {
	/**
	 * 
	 * 2016年2月2日
	 * 
	 * @param key
	 *            加密密钥
	 * @param str
	 *            待加密字符串
	 * @return 加密后字符串
	 *
	 */
	public static String encrypt(String key, String data) {
		return bytes2HexString(getHmacMd5Bytes(key.getBytes(), data.getBytes()));
	}

	/**
	 * 密码校验 2016年2月2日
	 * 
	 * @param oldStr
	 * @param newStr
	 * @return 是否相同
	 *
	 */
	public static boolean compare(String oldStr, String newStr) {
		return StringUtils.equals(oldStr, newStr);
	}

	/**
	 * byte数组转换成hex字符串 2016年2月2日
	 * 
	 * @param b
	 * @return 转换后的32位字符串
	 *
	 */
	private static String bytes2HexString(byte[] b) {
		StringBuffer result = new StringBuffer();
		String hex;
		for (int i = 0; i < b.length; i++) {
			hex = Integer.toHexString(b[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			// 取小写 跟前端md5.js保持一致
			result.append(hex.toLowerCase());
		}
		return result.toString();
	}

	/**
	 * HmacMD5加密 2016年2月2日
	 * 
	 * @param key
	 *            加密密钥
	 * @param data
	 *            待加密数据
	 * @return 加密后的byte数字表示
	 *
	 */
	private static byte[] getHmacMd5Bytes(byte[] key, byte[] data) {

		int length = 64;
		byte[] ipad = new byte[length];
		byte[] opad = new byte[length];
		for (int i = 0; i < 64; i++) {
			ipad[i] = 0x36;
			opad[i] = 0x5C;
		}
		byte[] actualKey = key; // Actual key.
		byte[] keyArr = new byte[length]; // Key bytes of 64 bytes length

		if (key.length > length) {
			actualKey = DigestUtils.md5(key);
		}
		for (int i = 0; i < actualKey.length; i++) {
			keyArr[i] = actualKey[i];
		}

		if (actualKey.length < length) {
			for (int i = actualKey.length; i < keyArr.length; i++)
				keyArr[i] = 0x00;
		}

		byte[] kIpadXorResult = new byte[length];
		for (int i = 0; i < length; i++) {
			kIpadXorResult[i] = (byte) (keyArr[i] ^ ipad[i]);
		}

		byte[] firstAppendResult = new byte[kIpadXorResult.length + data.length];
		for (int i = 0; i < kIpadXorResult.length; i++) {
			firstAppendResult[i] = kIpadXorResult[i];
		}
		for (int i = 0; i < data.length; i++) {
			firstAppendResult[i + keyArr.length] = data[i];
		}

		byte[] firstHashResult = DigestUtils.md5(firstAppendResult);

		byte[] kOpadXorResult = new byte[length];
		for (int i = 0; i < length; i++) {
			kOpadXorResult[i] = (byte) (keyArr[i] ^ opad[i]);
		}

		byte[] secondAppendResult = new byte[kOpadXorResult.length + firstHashResult.length];
		for (int i = 0; i < kOpadXorResult.length; i++) {
			secondAppendResult[i] = kOpadXorResult[i];
		}
		for (int i = 0; i < firstHashResult.length; i++) {
			secondAppendResult[i + keyArr.length] = firstHashResult[i];
		}

		byte[] hmacMd5Bytes = DigestUtils.md5(secondAppendResult);
		return hmacMd5Bytes;
	}

	/**
	 * Base64加密
	 * 
	 * @author RD_haitao_ou
	 * @Time 2016年4月27日下午3:38:09
	 * @param str
	 * @return
	 */
	public static String encodeBase64(String str) {
		byte[] b = Base64.encodeBase64(str.getBytes(), false);
		return new String(b);
	}

	/**
	 * Base64解密
	 * 
	 * @author RD_haitao_ou
	 * @Time 2016年4月27日下午3:39:03
	 * @param str
	 * @return
	 */
	public static String decodeBase64(String str) {
		byte[] b = Base64.decodeBase64(str.getBytes());
		return new String(b);
	}

	/**
	 * base32加密
	 * 
	 * @author RD_haitao_ou
	 * @Time 2016年5月11日上午10:48:13
	 * @param str
	 * @return
	 */
	public static String encodeBase32(String str) {
		Base32 base32 = new Base32();
		byte[] b = base32.encode(str.getBytes());
		return new String(b);
	}

	/**
	 * Base32解密
	 * 
	 * @author RD_haitao_ou
	 * @Time 2016年4月27日下午3:39:03
	 * @param str
	 * @return
	 */
	public static String decodeBase32(String str) {
		Base32 base32 = new Base32();
		byte[] b = base32.decode(str.getBytes());
		return new String(b);
	}

}
