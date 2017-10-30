package com.aaron.aaronworld.service;


import java.util.Map;

/**
 * 版本判断Service
 * 
 * @author  L
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
    public Map<String, Object> login(String userName, String password, String SMScode, String phone, String imsi,
                                       String imei, String hannelId, String deviceType, String srcip);
    
    /**
     * 发送短信认证码接口
     * 
     * @return Map<String, Object> 返回数据对象
     */
    public Map<String,Object> getSMScode(String userName, String platform, String password);
}