package com.aaron.aaronworld.dao;


import com.aaron.aaronworld.dao.entity.ConfigEntity;

import java.util.List;

public interface ConfigEntityMapper {
    int deleteByPrimaryKey(Integer configId);

    int insert(ConfigEntity record);

    int insertSelective(ConfigEntity record);

    ConfigEntity selectByPrimaryKey(Integer configId);

    List<ConfigEntity> selectByEntity(ConfigEntity record);

    int updateByPrimaryKeySelective(ConfigEntity record);

    int updateByPrimaryKey(ConfigEntity record);
}