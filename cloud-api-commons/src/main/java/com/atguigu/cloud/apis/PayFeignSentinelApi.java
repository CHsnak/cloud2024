package com.atguigu.cloud.apis;

import com.atguigu.cloud.resp.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * ClassName:PayFeignSentinelApi
 * Package: com.atguigu.cloud.apis
 * Description:
 *
 * @Author: Cheng
 * @Create: 2024/5/4 - 16:14
 * @Version: v1.0
 */
@FeignClient(value = "nacos-provider-payment",fallback = PayFeignSentinelApiFallBack.class)
public interface PayFeignSentinelApi
{
    @GetMapping("/pay/nacos/get/{orderNo}")
    public ResultData getPayByOrderNo(@PathVariable("orderNo") String orderNo);
}
