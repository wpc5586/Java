/*****************************************************************************
 * 东方国信手机经分项目[mobile_jf]
 *----------------------------------------------------------------------------
 * com.aaron.aaronworld.common.util.Auth.java
 *
 * @author andy
 * @date 2016年12月5日
 * @version 0.0.1
 * @since 0.0.1
 *----------------------------------------------------------------------------
 * (C) 北京东方国信科技股份有限公司
 *     Business-intelligence Of Oriental Nations Corporation Ltd. 2016
 *****************************************************************************/
package com.aaron.aaronworld.utils;

import io.swagger.client.model.RegisterUsers;
import io.swagger.client.model.User;
import org.junit.Assert;

import java.util.*;

/**
 * 鉴权工具类
 * com.aaron.aaronworld.common.util.Auth.java
 * 
 * @author andy
 * @date 2016年12月5日
 *
 * @since 0.0.1
 */
public class Auth {

	private static ResourceBundle config;
	private static String authSecretKey;
	private static String authExpireInterval;
	private static String authSeparator;
	
	static {
		config = ResourceBundle.getBundle("config", Locale.getDefault());
		authSecretKey = config.getString("auth_secret_key");
		authExpireInterval = config.getString("auth_expire_interval");
		authSeparator = config.getString("auth_separator");
	}
	
	/**
	 * 生成TOKEN
	 * 
	 * @param imei
	 * @param userId
	 * @return String
	 * @author andy
	 */
	public static String createToken(String imei, String userId){
		StringBuffer token = new StringBuffer();
		token.append(AES.encrypt(imei, authSecretKey)+authSeparator);
		token.append(AES.encrypt(userId, authSecretKey)+authSeparator);
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MINUTE, Integer.valueOf(authExpireInterval));
		token.append(AES.encrypt(String.valueOf(calendar.getTimeInMillis()), authSecretKey));
		return token.toString();
	}
	
	/**
	 * 提取token信息
	 * 
	 * @param token
	 * @return List<String>
	 * @author andy
	 */
	public static List<String> getSubTokens(String token){
		List<String> subTokenList = new ArrayList<String>();
		String[] subTokens = token.split(authSeparator);
		for(String subToken : subTokens){
			subTokenList.add( AES.decrypt(subToken, authSecretKey));
		}
		return subTokenList;
	}
	
	/**
	 * 提取token信息
	 * 
	 * @param subTokenList
	 * @param index
	 * @return String
	 * @author andy
	 */
	private static String extractTokenInfo(List<String> subTokenList, Integer index){
		String tokenInfo = null;
		if(index < subTokenList.size()){
			tokenInfo = subTokenList.get(index);
		}
		return tokenInfo;
	}
	
	/**
	 * 获取Imei
	 * 
	 * @param subTokenList
	 * @return String
	 * @author andy
	 */
	public static String getImei(List<String> subTokenList){
		return extractTokenInfo(subTokenList, 0);
	}
	
	/**
	 * 获取用户id
	 * 
	 * @param subTokenList
	 * @return String
	 * @author andy
	 */
	public static String getUserId(List<String> subTokenList){
		return extractTokenInfo(subTokenList, 1);
	}
	
	/**
	 * 获取时间戳
	 * 
	 * @param subTokenList
	 * @return Long
	 * @author andy
	 */
	public static Long getTimestamp(List<String> subTokenList){
		String timestamp = extractTokenInfo(subTokenList, 2);
		if(timestamp != null && timestamp.matches("\\d{13}")){
			return Long.valueOf(timestamp);
		} else {
			return null;
		}
	}
	
	/**
	 * 验证TOKEN有效性
	 * 
	 * @param subTokenList
	 * @return Boolean
	 * @author andy
	 */
	public static Boolean isValid(List<String> subTokenList){
		if(getTimestamp(subTokenList)!=null && getUserId(subTokenList)!=null && getImei(subTokenList)!=null){
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 验证TOKEN时效性
	 * 
	 * @param subTokenList
	 * @return Boolean
	 * @author andy
	 */
	public static Boolean isLive(List<String> subTokenList){
		Long timestamp = getTimestamp(subTokenList);
		if(timestamp!=null && timestamp>Calendar.getInstance().getTimeInMillis()){
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 提取token信息
	 * 
	 * @param token
	 * @param index
	 * @return String
	 * @author andy
	 */
	private static String extractTokenInfo(String token, Integer index){
		String tokenInfo = null;
		String[] subTokens = token.split(authSeparator);
		if(index < subTokens.length){
			tokenInfo = AES.decrypt(subTokens[index], authSecretKey);
		}
		return tokenInfo;
	}
	
	/**
	 * 获取Imei
	 * 
	 * @param token
	 * @return String
	 * @author andy
	 */
	public static String getImei(String token){
		return extractTokenInfo(token, 0);
	}
	
	/**
	 * 获取用户id
	 * 
	 * @param token
	 * @return String
	 * @author andy
	 */
	public static String getUserId(String token){
		return extractTokenInfo(token, 1);
	}
	
	/**
	 * 获取时间戳
	 * 
	 * @param token
	 * @return Long
	 * @author andy
	 */
	public static Long getTimestamp(String token){
		String timestamp = extractTokenInfo(token, 2);
		if(timestamp != null && timestamp.matches("\\d{13}")){
			return Long.valueOf(timestamp);
		} else {
			return null;
		}
	}
	
	/**
	 * 验证TOKEN有效性
	 * 
	 * @param token
	 * @return Boolean
	 * @author andy
	 */
	public static Boolean isValid(String token){
		if(getTimestamp(token)!=null && getUserId(token)!=null && getImei(token)!=null){
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 验证TOKEN时效性
	 * 
	 * @param token
	 * @return Boolean
	 * @author andy
	 */
	public static Boolean isLive(String token){
		Long timestamp = getTimestamp(token);
		System.out.println(timestamp);
		System.out.println(Calendar.getInstance().getTimeInMillis());
		if(timestamp!=null && timestamp>Calendar.getInstance().getTimeInMillis()){
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		String token = createToken("240", "wpc5586");
		token = "3baeb597a104eb6faf99db10f14dcc49-7a5312117779cd596883750ef33ab46a-f872c1a9339d69a9a1bdab8b211dab9e";
		System.out.println(token);
        String cityId = Auth.getImei(token);
        String userId = Auth.getUserId(token);
		System.out.println(cityId+"_"+userId);
		System.out.println(isLive(token));
    }
	
}
