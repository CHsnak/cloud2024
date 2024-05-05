package com.atguigu.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:NacosController
 * Package: com.atguigu.cloud.controller
 * Description:
 *
 * @Author: Cheng
 * @Create: 2024/5/3 - 16:15
 * @Version: v1.0
 */
@RestController
public class NacosController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("pay/nacos/{id}")
    public String firNacos(@PathVariable("id") Integer id){
        return "Nacos Test --- Port: " + serverPort + ", id: " +id;
    }
}
