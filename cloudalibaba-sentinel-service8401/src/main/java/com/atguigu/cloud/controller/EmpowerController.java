package com.atguigu.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:EmpowerController
 * Package: com.atguigu.cloud.controller
 * Description: Empower授权规则，用来处理请求的来源
 *
 * @Author: Cheng
 * @Create: 2024/5/4 - 14:48
 * @Version: v1.0
 */
@RestController
@Slf4j
public class EmpowerController {
    @GetMapping(value = "/empower")
    public String requestSentinel4(){
        log.info("测试Sentinel授权规则empower");
        return "Sentinel授权规则";
    }
}