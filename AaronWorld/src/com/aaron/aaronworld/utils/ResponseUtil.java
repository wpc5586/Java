/*****************************************************************************
 * 东方国信手机经分项目[mobile_jf]
 *----------------------------------------------------------------------------
 * cn.com.bonc.jf.common.util.ResponseUtil.java
 *
 * @author andy
 * @date 2016年12月6日
 * @version 0.0.1
 * @since 0.0.1
 *----------------------------------------------------------------------------
 * (C) 北京东方国信科技股份有限公司
 *     Business-intelligence Of Oriental Nations Corporation Ltd. 2016
 *****************************************************************************/
package com.aaron.aaronworld.utils;

import com.google.gson.Gson;
import com.mysql.jdbc.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 响应工具类
 * cn.com.bonc.jf.common.util.ResponseUtil.java
 * 
 * @author Aaron
 * @date 2017-10-30 09:50:35
 *
 * @since 0.0.1
 */
public class ResponseUtil {
	
	/**
	 * 返回Map
	 * 
	 * @param code 返回码
	 * @param msg 返回消息
	 * @return Map<String,Object>
	 * @author andy
	 */
	public static Map<String,Object> returnMap(Integer code, String msg){
		return returnMap(code, AES.encrypt(msg), null);
	}
	
	/**
	 * 返回Map
	 * 
	 * @param code 返回码
	 * @param msg 返回消息
	 * @return Map<String,Object>
	 * @author andy
	 */
	public static Map<String,Object> returnMapNoAES(Integer code, String msg){
		return returnMap(code, msg, null);
	}
	
	/**
	 * 返回Map
	 * 
	 * @param code 返回码
	 * @param msg 返回消息
	 * @param obj 响应Map
	 * @return Map<String,Object>
	 * @author andy
	 */
	public static Map<String,Object> returnMap(Integer code, String msg, Object obj){
		Map<String,Object> returnMap = new HashMap<String,Object>();
		returnMap.put("statusCode", code);
		returnMap.put("message", AES.encrypt(msg));
		String objString = AES.encrypt(new Gson().toJson(obj).toString());
		returnMap.put("obj", StringUtils.isNullOrEmpty(objString) ? new HashMap<String, Object>() : obj);
		return returnMap;
	}
	
	/**
	 * 返回Map（不加密）
	 * 
	 * @param code 返回码
	 * @param msg 返回消息
	 * @param obj 响应Map
	 * @return Map<String,Object>
	 * @author andy
	 */
	public static Map<String,Object> returnMapNoAES(Integer code, String msg, Object obj){
		Map<String,Object> returnMap = new HashMap<String,Object>();
		returnMap.put("statusCode", code);
		returnMap.put("message", msg);
		returnMap.put("obj", obj);
		return returnMap;
	}
	
}
