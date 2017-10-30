package com.aaron.aaronworld.base.exception;

import com.aaron.aaronworld.utils.SpringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 系统异常处理基类
 * 
 */
public class AccessException extends RuntimeException {

    private static final long serialVersionUID = -1975950600294184332L;
    // log对象
    protected final Logger logger = LoggerFactory.getLogger(getClass());
    // 异常消息
    private String msgDes;

    public AccessException() {
        super(SpringUtils.getMessage(""));// AgencyMessageConstant.MSG_ERROR_ADMIN_0005
        // 根据消息编码取得消息
        this.msgDes = SpringUtils.getMessage("");// AgencyMessageConstant.MSG_ERROR_ADMIN_0005
        // 输出消息log信息
        logger.error(this.msgDes);
    }

    public String getMsgDes() {
        return msgDes;
    }
}
