package com.techeffic.wechatPay.lib.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/**
 * 微信支付签名生成工具
 * @author k42jc
 *
 */
public class SignUtil {
	
	public static String getSign(Map<String,Object> map,String key){
        ArrayList<String> list = new ArrayList<String>();
        for(Map.Entry<String,Object> entry:map.entrySet()){
            if(entry.getValue()!=""){
                list.add(entry.getKey() + "=" + entry.getValue() + "&");
            }
        }
        int size = list.size();
        String [] arrayToSort = list.toArray(new String[size]);
        Arrays.sort(arrayToSort, String.CASE_INSENSITIVE_ORDER);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < size; i ++) {
            sb.append(arrayToSort[i]);
        }
        String result = sb.toString();
        result += "key=" + key;
        //Util.log("Sign Before MD5:" + result);
        result = MD5Util.MD5Encode(result).toUpperCase();
        //Util.log("Sign Result:" + result);
        return result;
    }
}
