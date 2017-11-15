package com.aaron.aaronworld.service.impl;

import com.aaron.aaronworld.dao.UserEntityMapper;
import com.aaron.aaronworld.dao.entity.EmchatUserEntity;
import com.aaron.aaronworld.dao.entity.UserEntity;
import com.aaron.aaronworld.emchat.api.impl.EasemobIMUsers;
import com.aaron.aaronworld.service.LoginService;
import com.aaron.aaronworld.utils.Auth;
import com.aaron.aaronworld.utils.Constant;
import com.aaron.aaronworld.utils.MessageConstant;
import com.aaron.aaronworld.utils.ResponseUtil;
import com.aaron.aaronworld.vo.UserVo;
import com.google.gson.Gson;
import com.mysql.jdbc.StringUtils;
import io.swagger.client.model.RegisterUsers;
import io.swagger.client.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
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
    public Map<String, Object> getIosToken() {
        return null;
    }

    /**
     * 设置IOS版本加密信息
     *
     * @param iosToken
     * @return Map<String, Object> 返回数据对象
     */
    @Override
    public Map<String, Object> setIosToken(String iosToken) {
        return null;
    }

    /**
     * 4A登录接口
     *
     * @return Map<String, Object> 返回数据对象
     */
    public Map<String, Object> login(String userId, String password, String phone, String imsi,
                                     String imei, String channelId, String deviceType) {
        Map<String, Object> resultMap;
        Map<String, Object> obj = new HashMap<>();
        try {
            UserEntity entity = new UserEntity();
            entity.setIsUsable("1");
            entity.setUserId(userId);
            UserEntity user = userEntityMapper.selectByEntity(entity);
            if (user == null)
                resultMap = ResponseUtil.returnMap(Constant.RESULT_CODE_ABNORMAL, MessageConstant.MSG_JF_ERROR_0004, obj);
            else {
                if (StringUtils.isNullOrEmpty(password))
                    resultMap = ResponseUtil.returnMap(Constant.RESULT_CODE_ABNORMAL, MessageConstant.MSG_JF_ERROR_0005, obj);
                else if (password.equals(user.getUserPassword())) {
                    UserVo vo = new UserVo();
                    vo.setUserId(userId);
                    vo.setUserName(user.getUserName());
                    vo.setCityCode(user.getCityCode());
                    vo.setCityName(user.getCityName());
                    vo.setRole(user.getRole());
                    vo.setUserEmail(user.getUserEmail());
                    vo.setUserPhone(user.getUserPhone());
                    vo.setUserSex(user.getUserSex());
                    vo.setToken(Auth.createToken(imei, userId));
                    vo.setUuid(user.getUuid());
                    obj.put("user", vo);
                    resultMap = ResponseUtil.returnMap(Constant.RESULT_CODE_NORMAL_DATA_HAVE, MessageConstant.MSG_INFO_COMMON_0001, obj);
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
     * 注册接口
     *
     * @return Map<String, Object> 返回数据对象
     */
    public Map<String, Object> regist(String userId, String password, String phone) {
        Map<String, Object> resultMap;
        Map<String, Object> obj = new HashMap<>();
        try {
            UserEntity entity = new UserEntity();
            entity.setIsUsable("1");
            entity.setUserId(userId);
            UserEntity user = userEntityMapper.selectByEntity(entity);
            if (user != null)
                resultMap = ResponseUtil.returnMap(Constant.RESULT_CODE_ABNORMAL, MessageConstant.MSG_JF_ERROR_0007, obj);
            else if (StringUtils.isNullOrEmpty(userId))
                resultMap = ResponseUtil.returnMap(Constant.RESULT_CODE_ABNORMAL, MessageConstant.MSG_JF_ERROR_0008, obj);
            else if (StringUtils.isNullOrEmpty(password))
                resultMap = ResponseUtil.returnMap(Constant.RESULT_CODE_ABNORMAL, MessageConstant.MSG_JF_ERROR_0009, obj);
            else {
                RegisterUsers users = new RegisterUsers();
                users.add(new User().username(userId).password(password));
                String resultString = new EasemobIMUsers().createNewIMUserSingle(users).toString();
                if (StringUtils.isNullOrEmpty(resultString))
                    entity.setUuid("");
                else {
                    EmchatUserEntity result = new Gson().fromJson(resultString, EmchatUserEntity.class);
                    entity.setUuid(result.getEntities().get(0).getUuid());
                }
                entity.setUserPassword(password);
                entity.setUserPhone(phone);
                userEntityMapper.insertSelective(entity);
                resultMap = ResponseUtil.returnMap(Constant.RESULT_CODE_NORMAL_DATA_HAVE, MessageConstant.MSG_INFO_COMMON_0001, obj);
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
    public Map<String, Object> getSMScode(String userName, String platform, String password) {
        return null;
    }
}