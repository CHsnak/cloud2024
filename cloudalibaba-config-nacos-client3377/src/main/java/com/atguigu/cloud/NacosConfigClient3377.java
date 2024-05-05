package com.atguigu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * ClassName:Main3377
 * Package: com.atguigu.cloud
 * Description:
 *
 * @Author: Cheng
 * @Create: 2024/5/3 - 17:35
 * @Version: v1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosConfigClient3377 {
    public static void main(String[] args) {
        SpringApplication.run(NacosConfigClient3377.class,args);
    }
}
