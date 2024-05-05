package com.atguigu.cloud.exp;

import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.resp.ReturnCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * ClassName:GlobalExceptionHandler
 * Package: com.atguigu.cloud.exp
 * Description:
 *
 * @Author: Cheng
 * @Create: 2024/4/10 - 14:34
 * @Version: v1.0
 */
//@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultData<String> handle(Exception e){
        log.error("\n全局异常信息exception:{}", e.getMessage(), e);
        log.info("\n*** GlobalExceptionHandler()...  ***");
        return ResultData.fail(ReturnCodeEnum.RC500.getCode(), e.getMessage());
    }
}
