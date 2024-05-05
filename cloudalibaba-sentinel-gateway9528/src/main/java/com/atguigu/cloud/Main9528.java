package com.atguigu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * ClassName:Main9528
 * Package: com.atguigu.cloud
 * Description:
 *
 * @Author: Cheng
 * @Create: 2024/5/4 - 17:23
 * @Version: v1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Main9528 {
    public static void main(String[] args)
    {
        SpringApplication.run(Main9528.class,args);
    }
}
