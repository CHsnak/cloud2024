package com.atguigu.cloud.controller;

import com.atguigu.cloud.service.FlowLimitService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * ClassName:FlowLimitController
 * Package: com.atguigu.cloud.controller
 * Description:
 *
 * @Author: Cheng
 * @Create: 2024/5/3 - 20:16
 * @Version: v1.0
 */
@RestController
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA()
    {
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB()
    {
        return "------testB";
    }

    @Resource
    private FlowLimitService flowLimitService;

    @GetMapping("/testC")
    public String testC() {
        flowLimitService.ptnService();
        return "------testC";
    }

    @GetMapping("/testD")
    public String testD() {
        flowLimitService.ptnService();
        return "------testD";
    }

    @GetMapping("/testE")
    public String testE() {
        System.out.println("------testE-----流控效果，排队等待");
        return "------testE-----流控效果，排队等待";
    }

    @GetMapping("/testF")
    public String testF() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "------testF-----熔断策略，慢调用比例";
    }

    @GetMapping("/testG")
    public String testG() {
        int i = 10 / 0;
        return "------testG-----熔断策略，异常比例";
    }

    @GetMapping("/testK")
    public String testK() {
        int i = 10 / 0;
        return "------testK-----熔断策略，异常数";
    }
}