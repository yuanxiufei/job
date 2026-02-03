package com.reginyuan.job.utils;

import com.reginyuan.job.utils.enums.ResultCodeEnum;
import lombok.Data;

@Data
public class ReponseResult {
    private Integer code;   // 状态码
    private String msg; // 状态码描述
    private Object data;    // 返回对象

    /**
     * 请求成功：返回状态码、描述信息、数据对象
     * @param data
     */
    public ReponseResult(Object data) {
        this.code = ResultCodeEnum.SUCCESS.getCode();
        this.msg = ResultCodeEnum.SUCCESS.getMsg();
        this.data = data;
    }

    /**
     * 请求成功：返回状态码、描述信息
     * @param
     */
    public ReponseResult() {
        this.code = ResultCodeEnum.SUCCESS.getCode();
        this.msg = ResultCodeEnum.SUCCESS.getMsg();
        this.data = null;
    }

    /**
     * 返回指定状态码、描述信息、数据对象
     * @param resultCodeEnum
     * @param data
     */
    public ReponseResult(ResultCodeEnum resultCodeEnum, Object data) {
        this.code = resultCodeEnum.getCode();
        this.msg = resultCodeEnum.getMsg();
        this.data = data;
    }

    /**
     * 返回指定状态码、描述信息
     * @param resultCodeEnum
     * @param
     */
    public ReponseResult(ResultCodeEnum resultCodeEnum) {
        this.code = resultCodeEnum.getCode();
        this.msg = resultCodeEnum.getMsg();
        this.data = null;
    }

    /**
     * 手动设置状态码、描述信息、数据对象
     * @param code
     * @param msg
     * @param data
     */
    public ReponseResult(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 手动设置状态码、描述信息
     * @param code
     * @param msg
     * @param
     */
    public ReponseResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = null;
    }
}
