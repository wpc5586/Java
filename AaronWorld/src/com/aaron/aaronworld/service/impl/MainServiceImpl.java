package com.aaron.aaronworld.service.impl;

import com.aaron.aaronworld.service.MainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 单元列表Service实现
 * 
 * @author Aaron
 */
@Service("MainServiceImpl")
public class MainServiceImpl implements MainService {
    protected final Logger logger = LoggerFactory.getLogger(MainServiceImpl.class);

    @Override
    public Map<String, Object> getMainContent() {
        return null;
    }
}