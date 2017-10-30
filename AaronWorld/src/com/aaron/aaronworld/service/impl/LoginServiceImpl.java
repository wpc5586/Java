package com.aaron.aaronworld.service.impl;

import com.aaron.aaronworld.dao.UserEntityMapper;
import com.aaron.aaronworld.dao.entity.UserEntity;
import com.aaron.aaronworld.service.LoginService;
import com.aaron.aaronworld.utils.Constant;
import com.aaron.aaronworld.utils.MessageConstant;
import com.aaron.aaronworld.utils.ResponseUtil;
import com.aaron.aaronworld.vo.UserVo;
import com.mysql.jdbc.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * 单元列表Service实现
 * 
 * @author Aaron
 */
@Service("LoginServiceImpl")
public class LoginServiceImpl implements LoginService {
    protected final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Resource
    private UserEntityMapper userEntityMapper;

    /**
     * 配置资源
     */
    private static ResourceBundle bundle = ResourceBundle.getBundle("config");

    /**
     * 获取IOS版本加密信息
     * 
     * @return Map<String, Object> 返回数据对象
     */
    @Override
    public Map<String, Object> getIosToken(){
        return null;
    }
    
    /**
     * 设置IOS版本加密信息
     * 
     * @param iosToken
     * @return Map<String, Object> 返回数据对象
     */
    @Override
    public Map<String, Object> setIosToken(String iosToken){
        return null;
    }

    /**
     * 4A登录接口
     *
     * @return Map<String, Object> 返回数据对象
     */
    public Map<String, Object> login(String userId, String password, String SMScode, String phone, String imsi,
                                     String imei, String hannelId, String deviceType, String srcip) {
        Map<String,Object> resultMap = new HashMap<>();
        Map<String,Object> obj = new HashMap<>();
        try {
            UserEntity entity = new UserEntity();
            entity.setIsUsable("1");
            entity.setUserId(userId);
            List<UserEntity> userEntities = userEntityMapper.selectByEntity(entity);
            if (userEntities == null || userEntities.size() == 0)
                resultMap = ResponseUtil.returnMap(Constant.RESULT_CODE_ABNORMAL, MessageConstant.MSG_JF_ERROR_0004, obj);
            else {
                UserEntity user = userEntities.get(0);
                if (StringUtils.isNullOrEmpty(password))
                    resultMap = ResponseUtil.returnMap(Constant.RESULT_CODE_ABNORMAL, MessageConstant.MSG_JF_ERROR_0005, obj);
                else if (password.equals(user.getUserPassword())) {
                    UserVo vo = new UserVo();
                    vo.setUserName(user.getUserName());
                    vo.setCityCode(user.getCityCode());
                    vo.setCityName(user.getCityName());
                    vo.setRole(user.getRole());
                    vo.setUserEmail(user.getUserEmail());
                    vo.setUserPhone(user.getUserPhone());
                    vo.setUserSex(user.getUserSex());
                    obj.put("user", vo);
                    resultMap = ResponseUtil.returnMap(Constant.RESULT_CODE_NORMAL_DATA_NOT_HAVE, MessageConstant.MSG_INFO_COMMON_0001, obj);
                } else
                    resultMap = ResponseUtil.returnMap(Constant.RESULT_CODE_ABNORMAL, MessageConstant.MSG_JF_ERROR_0006, obj);
            }
        } catch (Exception ex) {
            // 失败原因log
            logger.error(ex.getMessage());
            // 用户请求异常
            resultMap = ResponseUtil.returnMap(Constant.RESULT_CODE_ABNORMAL, MessageConstant.MSG_ERROR_COMMON_0001, obj);
        }
        return resultMap;
    }

    /**
     * 发送短信认证码接口
     *
     * @return Map<String, Object> 返回数据对象
     */
    public Map<String,Object> getSMScode(String userName, String platform, String password) {
        return null;
    }
    

}