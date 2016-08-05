package com.techeffic.wechatPay.lib.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * json工具类
 * 
 * @author k42jc
 *
 */
public class JsonUtil {
	private static JSONObject jsonObject;
	private static ObjectMapper objectMapper;

	/**
	 * json格式数据转为Map
	 * 
	 * @param jsonStr
	 * @return
	 */
	public static Map<String, Object> toMap(String jsonStr) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if (jsonObject == null)
			jsonObject = new JSONObject(jsonStr);
		try {
			Iterator ite = jsonObject.keys();
			while (ite.hasNext()) {
				Object key = ite.next();
				resultMap.put(key.toString(), jsonObject.get(key.toString()));
			}
			return resultMap;
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 将json字符串转为相应的java对象
	 * 
	 * @param jsonStr
	 *            json字符串
	 * @param clazz
	 *            java对象对应的class 可以为List<T>.class、Map<String,T>.class以及javaBean等
	 * @return 转换后的java对象
	 */
	public static <T> T readValue(String jsonStr, Class<T> clazz) {
		if (objectMapper == null)
			objectMapper = new ObjectMapper();
		try {
			return objectMapper.readValue(jsonStr, clazz);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * json字符串转java对象的另一种形式
	 * 
	 * @param jsonStr
	 *            json字符串
	 * @param typeReference
	 *            TypeReference对象 举例：new
	 *            TypeReference<List<Map<String,Object>>>()
	 *            {};-->将json字符串转为List<Map<String,Object>>
	 * @return 转换后的java对象
	 */
	public static <T> T readValue(String jsonStr, TypeReference<T> typeReference) {
		if (objectMapper == null)
			objectMapper = new ObjectMapper();
		try {
			return objectMapper.readValue(jsonStr, typeReference);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 将java对象转换为json字符串
	 * @param object 待转换的Java对象
	 * @return 转换后的json字符串
	 */
	public static String parseJson(Object object){
		try {
			return objectMapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
}