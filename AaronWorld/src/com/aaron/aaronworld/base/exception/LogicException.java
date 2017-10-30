package com.aaron.aaronworld.base.exception;

import com.aaron.aaronworld.utils.Constant;
import com.aaron.aaronworld.utils.SpringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 系统异常处理基类
 * 
 */
public class LogicException extends RuntimeException {

    private static final long serialVersionUID = -1975950600294184332L;
    // log对象
    protected final Logger logger = LoggerFactory.getLogger(getClass());
    // 异常消息编码
    private String msgCd;
    // 异常消息
    private String msgDes;

    public LogicException() {
        super();
    }

    public LogicException(String msgCd, Object... msgParam) {
        super(SpringUtils.getMessage(msgCd, msgParam));
        // 取得消息编码
        this.msgCd = msgCd;
        // 根据消息编码取得消息
        this.msgDes = SpringUtils.getMessage(msgCd, msgParam);
        // 输出消息log信息
        logger.error(this.msgDes);
    }

    public LogicException(LogicException ex) {
        super(ex.getMessage());
        // 取得消息编码
        this.msgCd = ex.getMsgCd();
        // 根据消息编码取得消息
        this.msgDes = ex.getMsgDes();
        // 创建临时字符串
        StringBuilder tempStringBuilder = null;
        // 显示堆栈信息
        StackTraceElement[] stackTraceElements = ex.getStackTrace();
        if (stackTraceElements != null) {
            for (int i = 0; i < Constant.LOGIC_EXCEPTION_STACK_TRACE_COUNT; i++) {
                tempStringBuilder = new StringBuilder();
                tempStringBuilder.append("类:");
                tempStringBuilder.append(stackTraceElements[i].getClassName());
                tempStringBuilder.append("||方法名:");
                tempStringBuilder.append(stackTraceElements[i].getMethodName());
                tempStringBuilder.append("||所在行:");
                tempStringBuilder.append(stackTraceElements[i].getLineNumber());
                logger.error(tempStringBuilder.toString());
            }
        }
    }

    public String getMsgCd() {
        return msgCd;
    }

    public String getMsgDes() {
        return msgDes;
    }
}
