package com.atguigu.cloud.controller;

import com.atguigu.cloud.apis.PayFeignApi;
import com.atguigu.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:OrderGatewayController
 * Package: com.atguigu.cloud.controller
 * Description:
 *
 * @Author: Cheng
 * @Create: 2024/4/27 - 16:29
 * @Version: v1.0
 */
@RestController
public class OrderGatewayController {
    @Resource
    private PayFeignApi payFeignApi;

    @GetMapping(value = "/feign/pay/gateway/get/{id}")
    public ResultData getById(@PathVariable("id") Integer id)
    {
        return payFeignApi.getById2(id);
    }

    @GetMapping(value = "/feign/pay/gateway/info")
    public ResultData<String> getGatewayInfo()
    {
        return payFeignApi.getGatewayInfo();
    }

    @GetMapping(value = "/feign/pay/gateway/filter")
    public ResultData<String> getFilterEnds(HttpServletRequest req)
    {
        return payFeignApi.getFilterEnds(req);
    }
}
