package com.aaron.aaronworld.service;


import java.util.Map;

/**
 * 登录判断Service
 * 
 * @author  Aaron
 */
public interface LoginService {
    /**
     * 获取IOS版本加密信息
     * 
     * @return Map<String, Object> 返回数据对象
     */
    public Map<String, Object> getIosToken();

    /**
     * 设置IOS版本加密信息
     * 
     * @param iosToken IOS版本加密信息
     * @return Map<String, Object> 返回数据对象
     */
    public Map<String, Object> setIosToken(String iosToken);

    /**
     * 登录接口
     * 
     * @return Map<String, Object> 返回数据对象
     */
    public Map<String, Object> login(String userId, String password, String phone, String imsi, String imei, String channelId, String deviceType);

    /**
     * 注册接口
     *
     * @return Map<String, Object> 返回数据对象
     */
    public Map<String,Object> regist(String userId, String password, String phone);
    
    /**
     * 发送短信认证码接口
     * 
     * @return Map<String, Object> 返回数据对象
     */
    public Map<String,Object> getSMScode(String userId, String platform, String password);
}