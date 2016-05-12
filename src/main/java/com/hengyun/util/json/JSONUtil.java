package com.hengyun.util.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hengyun.controller.exception.JsonParseException;
import com.hengyun.util.exception.ExceptionCode;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月25日 下午3:01:32
* json工具类
*/
public class JSONUtil {
	
	/*
	 *  解析字符串为json对象
	 * */
	public static JSONObject parseObject(String data){
		JSONObject json;
		try {
			 json =JSON.parseObject(data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw  new JsonParseException(ExceptionCode.JSON_PARSET_ERROR,"json解析异常");
		}
		return json;
	}
	
	/*
	 *  转换json对象为java对象
	 * */
	public static <T> T toJavaObject(JSONObject json,Class<T> clazz){
		T temp=null;
		try {
			 temp = JSON.toJavaObject(json, clazz);
			 
			 //验证类型是否合法
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw  new JsonParseException(ExceptionCode.JSON_TO_OBJECT_ERROR,"json转换为java对象异常");
		}
		return  temp;
	}
	
	/*
	 *  解析jsonArray
	 * */
	public static JSONArray parseArray(String data){
			JSONArray array ; 
			try {
				array = JSONArray.parseArray(data);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				throw  new JsonParseException(ExceptionCode.JSON_PARSET_ERROR,"json解析异常");
			}
			return array;
	}
	

}
