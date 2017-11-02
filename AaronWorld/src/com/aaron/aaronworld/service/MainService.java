package com.aaron.aaronworld.service;


import java.util.Map;

/**
 * 主界面Service
 * 
 * @author  Aaron
 */
public interface MainService {
    /**
     * 获取IOS版本加密信息
     *
     * @return Map<String, Object> 返回数据对象
     */
    public Map<String, Object> getMainContent();
}