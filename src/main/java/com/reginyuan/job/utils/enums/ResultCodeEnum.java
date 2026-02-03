package com.reginyuan.job.utils.enums;

import lombok.Getter;

/**
 * 统一响应状态码信息
 */
@Getter
public enum ResultCodeEnum {
    SUCCESS(200, "请求成功"),
    PARAM_ERROR(400, "参数错误"),
    NOT_FOUND(404, "接口不存在"),
    SERVER_ERROR(500, "服务器错误"),
    DB_ERROR(505, "数据库错误"),
    UNIQUE_KEY_ERROR(506, "唯一键异常"),
    UNKNOWN(600, "未知错误");
    private Integer code;
    private String msg;

    ResultCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
