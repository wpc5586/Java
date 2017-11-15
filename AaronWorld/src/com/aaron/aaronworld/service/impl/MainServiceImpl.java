package com.aaron.aaronworld.service.impl;

import com.aaron.aaronworld.dao.ConfigEntityMapper;
import com.aaron.aaronworld.dao.entity.ConfigEntity;
import com.aaron.aaronworld.service.MainService;
import com.aaron.aaronworld.utils.Constant;
import com.aaron.aaronworld.utils.MessageConstant;
import com.aaron.aaronworld.utils.ResponseUtil;
import com.aaron.aaronworld.vo.VersionVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 单元列表Service实现
 *
 * @author Aaron
 */
@Service("MainServiceImpl")
public class MainServiceImpl implements MainService {
    protected final Logger logger = LoggerFactory.getLogger(MainServiceImpl.class);

    @Resource
    private ConfigEntityMapper configMapper;

    @Override
    public Map<String, Object> getVersion() {
        Map<String, Object> resultMap;
        Map<String, Object> obj = new HashMap<>();
        try {
            ConfigEntity configEntity = new ConfigEntity();
            configEntity.setConfigCategory("version");
            configEntity.setIsUsable("1");
            List<ConfigEntity> configOut = configMapper.selectByEntity(configEntity);
            if (configOut != null && configOut.size() != 0) {
                VersionVo vo = new VersionVo();
                for (ConfigEntity entity : configOut) {
                    if ("IOS".equals(entity.getConfigName())) {
                        vo.setiPhoneVersion(entity.getConfigValue());
                        vo.setiPhoneUrl(entity.getConfigValue1());
                        vo.setiPhoneContent(entity.getConfigValue2());
                    } else if ("Android".equals(entity.getConfigName())) {
                        vo.setAndroidVersion(entity.getConfigValue());
                        vo.setAndroidUrl(entity.getConfigValue1());
                        vo.setAndroidContent(entity.getConfigValue2());
                    }
                }
                resultMap = ResponseUtil.returnMapNoAES(Constant.RESULT_CODE_NORMAL_DATA_HAVE, "", vo);
            } else {
                resultMap = ResponseUtil.returnMapNoAES(Constant.RESULT_CODE_NORMAL_DATA_HAVE, MessageConstant.MSG_ERROR_COMMON_0003, obj);
            }
        } catch (Exception ex) {
            // 失败原因log
            logger.error(ex.getMessage());
            // 用户请求异常
            resultMap = ResponseUtil.returnMap(Constant.RESULT_CODE_ABNORMAL, MessageConstant.MSG_ERROR_COMMON_0001, obj);
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> getMainContent() {
        return null;
    }
}