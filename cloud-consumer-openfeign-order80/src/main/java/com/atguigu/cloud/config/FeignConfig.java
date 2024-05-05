package com.atguigu.cloud.config;

import feign.Logger;
import feign.RetryableException;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName:FeignConfig
 * Package: com.atguigu.cloud.config
 * Description:
 *
 * @Author: Cheng
 * @Create: 2024/4/26 - 13:29
 * @Version: v1.0
 */
@Configuration
public class FeignConfig {
    @Bean
    public Retryer retryer(){
        return Retryer.NEVER_RETRY;
        // 重试3次
//        return new Retryer.Default(100L,1,3);
    }

    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
