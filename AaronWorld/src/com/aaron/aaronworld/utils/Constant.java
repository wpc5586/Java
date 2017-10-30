package com.aaron.aaronworld.utils;

public class Constant {

    /** 返回码 正常返回（有返回数据）:100 */
    public static final int RESULT_CODE_NORMAL_DATA_HAVE = 200;

    /** 返回码 正常返回（无返回数据）:10 */
    public static final int RESULT_CODE_NORMAL_DATA_NOT_HAVE = 10;

    /** 返回码 用户请求出错 -1 */
    public static final int RESULT_CODE_ABNORMAL = -1;

    /** 获取列表数据时，1：有下一页数据； */
    public static final int LIST_HAVE_MORE_DATA_FLG = 1;

    /** 获取列表数据时， 0：无 下一页数据 */
    public static final int LIST_NOT_HAVE_MORE_DATA_FLG = 0;

    /** 当前页数: 0 */
    public static final int DEFAULT_CURRENT_PAGE = 0;
    
    /** app现实记录条数: 10 */
    public static final int APP_ROW_PAGE = 10;

    /** 逻辑异常堆栈打印条数 */
    public static final int LOGIC_EXCEPTION_STACK_TRACE_COUNT = 5;

    /** 空字符串 */
    public static final String STRING_EMPTY = "";
    
    /** admin */
    public static final String ADMIN = "admin";

    /** 返回状态 为成功时的value值 */
    public static final String RETURN_STATUS_VALUE_SUCCESS = "success";
    /** 返回状态 为失败时的value值 */
    public static final String RETURN_STATUS_VALUE_FAILURE = "failure";

    /** 返回状态 key值 */
    public static final String RETURN_STATUS_KEY = "status";
    /** 返回消息 key值 */
    public static final String RETURN_MESSAGE_KEY = "message";

    /** 记录有效 :0 */
    public static final int DEL_FLG_0 = 0;
    /** 记录无效:1 */
    public static final int DEL_FLG_1 = 1;
    
    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";

}
