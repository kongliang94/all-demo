package com.github.springbootshirodemo.common;

/**
 * 常量
 * @author dolyw.com
 * @date 2018/9/3 16:03
 */
public class Constant {

    private Constant() {}

    /**
     * redis-OK
     */
    public static final String OK = "OK";

    /**
     * redis过期时间，以秒为单位，一分钟
     */
    public static final int EXRP_MINUTE = 60;

    /**
     * redis过期时间，以秒为单位，一小时
     */
    public static final int EXRP_HOUR = 60 * 60;

    /**
     * redis过期时间，以秒为单位，一天
     */
    public static final int EXRP_DAY = 60 * 60 * 24;

    /**
     * redis-key-前缀-shiro:cache:
     */
    public static final String PREFIX_SHIRO_CACHE = "shiro:cache:";

    /**
     * redis-key-前缀-shiro:access_token:
     */
    public static final String PREFIX_SHIRO_ACCESS_TOKEN = "shiro:access_token:";

    /**
     * redis-key-前缀-shiro:refresh_token:
     */
    public static final String PREFIX_SHIRO_REFRESH_TOKEN = "shiro:refresh_token:";

    /**
     * JWT-account:
     */
    public static final String ACCOUNT = "account";

    /**
     * JWT-currentTimeMillis:
     */
    public static final String CURRENT_TIME_MILLIS = "currentTimeMillis";

    /**
     * PASSWORD_MAX_LEN
     */
    public static final Integer PASSWORD_MAX_LEN = 8;

    // 注册用户角色ID
    public static final Long REGISTER_ROLE_ID = 2L;

    // 排序规则：降序
    public static final String ORDER_DESC = "desc";
    // 排序规则：升序
    public static final String ORDER_ASC = "asc";

    // 前端页面路径前缀
    public static final String VIEW_PREFIX = "febs/views/";

    // 验证码 Session Key
    public static final String CODE_PREFIX = "febs_captcha_";

    // 允许下载的文件类型，根据需求自己添加（小写）
    public static final String[] VALID_FILE_TYPE = {"xlsx", "zip"};

    /**
     * getDataTable 中 HashMap 默认的初始化容量
     */
    public static final int DATA_MAP_INITIAL_CAPACITY = 4;
    /**
     * 异步线程池名称
     */
    public static final String ASYNC_POOL = "febsAsyncThreadPool";

}
