package com.aaron.aaronworld.service;


import java.util.Map;

/**
 * 主界面Service
 * 
 * @author  Aaron
 */
public interface MainService {

    /**
     * 获取版本信息
     *
     * @return Map<String, Object> 返回数据对象
     */
    public Map<String, Object> getVersion();

    /**
     * 获取主页信息
     *
     * @return Map<String, Object> 返回数据对象
     */
    public Map<String, Object> getMainContent();
}