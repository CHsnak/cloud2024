package com.atguigu.cloud.resp;

import lombok.Data;

/**
 * ClassName:ResultData
 * Package: com.atguigu.cloud.resp
 * Description:
 *
 * @Author: Cheng
 * @Create: 2024/4/10 - 14:07
 * @Version: v1.0
 */
@Data
public class ResultData<T> {

    private String code;
    private String message;
    private T data;
    private long timestamp;

    public ResultData(){
        timestamp = System.currentTimeMillis();
    }

    public static <T> ResultData<T> success(T data){
        ResultData<T> result = new ResultData<>();
        result.setCode(ReturnCodeEnum.RC200.getCode());
        result.setMessage(ReturnCodeEnum.RC200.getMessage());
        result.setData(data);
        return result;
    }

    public static <T> ResultData<T> fail(String code,String message){
        ResultData<T> result = new ResultData<>();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }
}
