package com.wen;

public class GlobalConstant {

    /**
     * 门店信息选择
     */
    public static final String STOREINFO_SELECT = "StoreInfoMapping";

    /**
     * 树形结构顶级ID
     */
    public static final String TREE_ROOT_ID = "0";

    public static final int INTEGER_MAX = 999999999;

    public static final long MONEY_MAX = 9999999999L;

    /**
     * 邮箱正则表达式
     */
    public static final String REGEX_EMAIL = "^([\\w-_]+(?:\\.[\\w-_]+)*)@((?:[a-z0-9]+(?:-[a-zA-Z0-9]+)*)+\\.[a-z]{2,6})$||''";

    /**
     * 电话号码 包括固话
     */
    public static final String REGEX_PHONE = "^((1[3-9]\\d{9})|(0\\d{2,3}-\\d{7,8})|(.{0}))$";

    /**
     * URL正则表达式, 匹配http和https
     */
    public static final String REGEX_URL = "(https?)://[-A-Za-z0-9+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|]";

    public static final String REG_PHONE="^[1]([3,4,5,7,8]\\d|[6,9]{2})\\d{8}$||''";
    /**
     * 时间字符串 正则表达式，如2015-11-13 14:12:25.0
     */
    public static final String REG_DTAETIME="[0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2}.{0,2}";

    public static final String REG_MONTH="[0-9]{4}-[0-9]{2}-01 00:00:00.{0,2}";

    public static final String REG_DEFAULT_DTAETIME=".{10} [0-9]{2}:[0-9]{2}:[0-9]{2} [A-Z]{3} [0-9]{4}";

    /**
     * 银行卡号码 正则表达式
     */
    public static final String REGEX_BANK_NUMBER = "^\\d+$";

    public static final String DATA_YMD = "yyyy-MM-dd";

    public static final String DATA_YM = "yyyy-MM";

    public static final String DATA_YM_01= "yyyy-MM-01";

    public static final String DATETIME="yyyy-MM-dd HH:mm:ss";

    public static final String DEATULT_DATETIME="EEE MMM dd HH:mm:ss Z yyyy";

    public static final String MSECTIME="yyyy-MM-dd HH:mm:ss.S";

    public static final String DATA_YMD_CN = "yyyy年MM月dd日";

    public static final String DATA_YM_CN = "yyyy年MM月";

    public static final String TIME_YMDH_CN = "yyyy年MM月dd日HH点";

    public static final String TIME_YMDHM_CN = "yyyy年MM月dd日 HH:mm";

    public static final String DATE_TIME_CN = "yyyy年MM月dd日 HH:mm:ss";

    public static final String TIME_HOUR = "yyyy/MM/dd HH:mm";

    public static final String TIME_SECOND = "yyyy/MM/dd HH:mm:ss";

    public static final String WAR="war";

    public static final String JAR="jar";

    public static final Integer DOWNLOAD_TIMEOUT=6000;

    /**
     * 设置保留两位小数
     */
    public static Integer SCALE = 2;
    /**
     * 精确到小数点后2位，不做四舍五入，超过2位舍去
     */
    public static String SCALE_TWO = "#0.00";

    public static Integer SCALE_FIVE = 5;

    public static final String PER="/";

    public static final String STAR="*";

    public static final String SUCCESS_REMARK="定时任务执行完成";

    public static final Integer OTHER_INDEX=7;

    public static final String RATIO_PATTERN="0.000%";

    public static final String ZERO_PERCENT="0%";

    public static final String MAX_PERCENT="100%";

    public static final String TEMPLATE_SUFFIX=".pdf";

    public static final String DEFAULT_TEMPALTE="11E7005056C00008A77FA9A6DF0EB005";

    public static final String FULL_SCREEN_POSITION="全部（全屏和3/4屏）";

    public static final Integer CODELENGTH=6;

    public static final Integer INTERVALSECOND=60;

    public static final Integer CODEVALIDITY=60;

    //短信每日最大发送次数
    public static final Integer SMSMAXTIMESPERDAY =10;

    public static final String[] DELIVERY_HEADER={"序号","广告形式","展示时长（秒）","频次（次/天）","投放起始日期","投放结束日期","天数","预计展示总频次","实际展示总频次","投放城市","投放门店数量","素材","备注","状态"};

    public static final String[] STORE_HEADER={"城市","城区","设备ID","店铺名","地址"};

    public static final String[] STORE_MONITOR_HEADER={"编号","门店名称","省份","城市","城区","具体地址","设备ID","是否激活","已展示次数","更新时间"};

    //分隔符
    public static final String SEPARATOR=",";

    //分隔符（顿号）
    public static final String SEPARATOR_COMMA="、";

    //投放平台的分隔符
    public static final String DELIVERYPLATFORMSEPARATOR="/";

    //反斜线分隔符
    public static final String BACKSLASH="\\";

    public static final Integer SHEET_RECORD_SIZE=60000;

    public static final Integer QUERY_RECORD_SIZE=2000;

    //mongodb分页数量
    public static final  Long MONGODB_PAGESIZE = 1000L;

    public static final Integer NO_PERMISSION = 403;

    public static final String CONTENT_TYPE_IMG="image/jpeg,image/png,image/bmp";

    public static final String CONTENT_TYPE_VIDEO="video/x-flv,video/avi,audio/mp4,video/x-matroska,video/x-ms-wmv,video/mp4";

    public static final String ALL_PLATFORM="全平台";

    public static final String ALL_TERMINATE_TYPE="1\\2\\3";

    public static final String AREA_ABNORMAL_NODE_ID = "-999";

    public static final String AREA_ABNORMAL_NODE_NAME = "无省市区";

    public static final String AREA_TEST_NODE_NAME = "测试门店";

    public static final String AREA_TEST_NODE_ID = "-888";

    public static final String AREA_CONTAIN_ALL_NODE_NAME = "全部";

    public static final Integer SIZE_CONFIG_CHANGED=522;

    /**
     * 订单处于待上刊状态，超过XX小时，广告系统自动取消订单，订单状态从待上刊变更为已取消
     */
    public static final Integer TIME_INTERVAL=24;

    public static final String TRUE_BOOLEAN="是,有";

    public static final String ALL_AREA_CODE="-1";

    public static final String NEW_LINE="\n";

    public static final String FALSE_BOOLEAN="否,无";

    public static final String PDF_HEADER_COMPANY_NAME="上海透云物联网科技有限公司";

    public static final String EMPTY_SUPPLEMENTARY="无";
}
