package com.atguigu.cloud.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

/**
 * ClassName:FlowLimitService
 * Package: com.atguigu.cloud.service
 * Description:
 *
 * @Author: Cheng
 * @Create: 2024/5/4 - 8:34
 * @Version: v1.0
 */
@Service
public class FlowLimitService {
    @SentinelResource("common")
    public void ptnService(){
        System.out.println("This is a service!");
    }
}
