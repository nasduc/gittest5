package com.example.demo.resp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum ResultStatus {

    // -1为通用失败（根据ApiResult.java中的构造方法注释而来）
    FAIL(-1, "common fail"),
    // 0为成功
    SUCCESS(0, "success"),

    error_pic_file(3,"非法图片文件"),
    error_pic_upload(4,"图片上传失败"),
    error_record_not_found(5, "没有找到对应的数据"),
    error_max_page_size(6, "请求记录数超出每次请求最大允许值"),
    error_create_failed(7,"新增失败"),
    error_update_failed(8,"修改失败"),
    error_delete_failed(9,"删除失败"),
    error_search_failed(10,"查询失败"),
    error_count_failed(11,"查询数据总数失败"),
    error_string_to_obj(12,"字符串转java对象失败"),
    error_invalid_argument(13,"参数不合法"),
    error_update_not_allowed(14,"更新失败：%s"),
    error_duplicated_data(15,"数据已存在"),
    error_unknown_database_operation(16,"未知数据库操作失败，请联系管理员解决"),
    error_column_unique(17,"字段s%违反唯一约束性条件"),
    error_file_download(18,"文件下载失败"),
    error_file_upload(19,"文件上传失败"),
    error_device_type(20,"不是采集器类型或者无线单表类型"),
    error_setup_status(21,"此设备已经安装过"),

    error_record_type(22, "不属于同一类型，不能替换"),
    error_collector_id(23, "采集器编号不正确"),
    error_delete_virtualCollectorNumtype(24, "虚拟采集器编号下面挂接水表不能删除"),
    error_replaceDevice_status(25,"此设备没有安装"),
    error_join_status(26,"此设备下面挂接了采集器，请先解除挂接"),
    error_network_delay(27,"网络超时"),

    //100-511为http 状态码
    // --- 4xx Client Error ---
    http_status_bad_request(400, "Bad Request"),
    http_status_unauthorized(401, "Unauthorized"),
    http_status_payment_required(402, "Payment Required"),
    http_status_forbidden(403, "Forbidden"),
    http_status_not_found(404, "Not Found"),
    http_status_method_not_allowed(405, "Method Not Allowed"),
    http_status_not_acceptable(406, "Not Acceptable"),
    http_status_proxy_authentication_required(407, "Proxy Authentication Required"),
    http_status_request_timeout(408, "Request Timeout"),
    http_status_conflict(409, "Conflict"),
    http_status_gone(410, "Gone"),
    http_status_length_required(411, "Length Required"),
    http_status_precondition_failed(412, "Precondition Failed"),
    http_status_payload_too_large(413, "Payload Too Large"),
    http_status_uri_too_long(414, "URI Too Long"),
    http_status_unsupported_media_type(415, "Unsupported Media Type"),
    http_status_requested_range_not_satisfiable(416, "Requested range not satisfiable"),
    http_status_expectation_failed(417, "Expectation Failed"),
    http_status_im_a_teapot(418, "I'm a teapot"),
    http_status_unprocessable_entity(422, "Unprocessable Entity"),
    http_status_locked(423, "Locked"),
    http_status_failed_dependency(424, "Failed Dependency"),
    http_status_upgrade_required(426, "Upgrade Required"),
    http_status_precondition_required(428, "Precondition Required"),
    http_status_too_many_requests(429, "Too Many Requests"),
    http_status_request_header_fields_too_large(431, "Request Header Fields Too Large"),

    // --- 5xx Server Error ---
    http_status_internal_server_error(500, "系统错误"),
    http_status_not_implemented(501, "Not Implemented"),
    http_status_bad_gateway(502, "Bad Gateway"),
    http_status_service_unavailable(503, "Service Unavailable"),
    http_status_gateway_timeout(504, "Gateway Timeout"),
    http_status_http_version_not_supported(505, "HTTP Version not supported"),
    http_status_variant_also_negotiates(506, "Variant Also Negotiates"),
    http_status_insufficient_storage(507, "Insufficient Storage"),
    http_status_loop_detected(508, "Loop Detected"),
    http_status_bandwidth_limit_exceeded(509, "Bandwidth Limit Exceeded"),
    http_status_not_extended(510, "Not Extended"),
    http_status_network_authentication_required(511, "Network Authentication Required"),

    // --- 8xx common error ---
    EXCEPTION(800, "exception"),
    INVALID_PARAM(801, "invalid.param"),
    INVALID_PRIVI(802, "invalid.privi"),

    //1000以内是系统错误，
    no_login(1000,"没有登录"),
    config_error(1001,"参数配置表错误"),
    user_exist(1002,"用户名已存在"),
    userpwd_not_exist(1003,"用户名不存在或者密码错误"),
    user_is_activation(1004,"账户已经被激活过"),

    //设备命令

    queue_repeat(1099,"队列中存在相同的命令，已将相同命令置于队末"),
    repeat_orders(1100,"有相同的命令正在下发"),
    channel_unavailable(1101,"采集器通道不可用"),
    queue_unavailable(1102,"无线单表有相同的命令待下发"),
    network_delay(1103,"网络延迟"),
    pub_error(1104,"服务器出小差了,命令已经进入队列，五分钟后尝试重新下发"),

    select_error(1105,"查询失败"),
    queue_empty(1203,"队列为空"),
    data_lack(1205,"查找不到对应设备参数"),
    no_meter(1206,"采集器还没有挂接任何水表"),
    join_allow(1207,"重复挂接"),
    delete_allow(1208,"还未挂接"),
    device_offline(1209,"下发时离线"),
    not_find(1210,"找不到该设备"),
    num_error(1211,"设备号不合法"),
    cache_pub(1212,"命令已经进入队列"),
    method_error(1213,"找不到command对应的方法"),
    method_call_error(1214,"方法调用错误")

    ;
    private static final Logger LOGGER = LoggerFactory.getLogger(ResultStatus.class);


    private int code;
    private String msg;

    ResultStatus(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public static int getCode(String define){
        try {
            return ResultStatus.valueOf(define).code;
        } catch (IllegalArgumentException e) {
            LOGGER.error("undefined error code: {}", define);
            return FAIL.getErrorCode();
        }
    }

    public static String getMsg(String define){
        try {
            return ResultStatus.valueOf(define).msg;
        } catch (IllegalArgumentException e) {
            LOGGER.error("undefined error code: {}", define);
            return FAIL.getErrorMsg();
        }

    }

    public static String getMsg(int code){
        for(ResultStatus err : ResultStatus.values()){
            if(err.code==code){
                return err.msg;
            }
        }
        return "errorCode not defined ";
    }

    public static ResultStatus getError(int code){
        for(ResultStatus err : ResultStatus.values()){
            if(err.code==code){
                return err;
            }
        }
        return null;
    }


    public int getErrorCode(){
        return code;
    }

    public String getErrorMsg(){
        return msg;
    }

}