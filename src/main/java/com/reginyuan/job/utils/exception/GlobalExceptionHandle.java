package com.reginyuan.job.utils.exception;

import com.reginyuan.job.utils.ReponseResult;
import com.reginyuan.job.utils.enums.ResultCodeEnum;
import lombok.extern.slf4j.Slf4j;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局统一异常处理
 */
@RestControllerAdvice
@Slf4j // 生成log日志
public class GlobalExceptionHandle {

//    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandle.class);
    /**
     * 参数校验异常（@Validated / @Valid）
     */
    @ExceptionHandler(BindException.class)
    public ReponseResult bindExceptionHandler(BindException e) {

        BindingResult bindingResult = e.getBindingResult(); // 从异常对象中拿到BindingResult对象
        // 遍历bindResult关联字段的所有error
        StringBuilder strBuilder = new StringBuilder("校验失败："); // 存储msg信息
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            strBuilder
                    .append(fieldError.getField())
                    .append("：")
                    .append(fieldError.getDefaultMessage())
                    .append(",");
        }
        String msg = strBuilder.toString();
        log.error(ResultCodeEnum.PARAM_ERROR.getCode() + msg);
        return new ReponseResult(ResultCodeEnum.PARAM_ERROR.getCode(), msg);
    }

    /**
     * 唯一键异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(DuplicateKeyException.class)
    public ReponseResult duplicateKeyExceptionHandler(DuplicateKeyException e) {
        log.error(e.getMessage());
       return new ReponseResult(ResultCodeEnum.UNIQUE_KEY_ERROR.getCode(), e.getCause().getMessage());
    }

    /**
     * 位置异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ReponseResult unknowExceptionHandle(Exception e) {
        log.error(e.getMessage());
        return new ReponseResult(ResultCodeEnum.UNKNOWN.getCode(), e.getMessage());
    }
}
