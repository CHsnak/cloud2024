package com.atguigu.cloud.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.atguigu.cloud.entities.Pay;
import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.service.PayService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Enumeration;
import java.util.Iterator;

/**
 * ClassName:PayGatewayController
 * Package: com.atguigu.cloud.controller
 * Description:
 *
 * @Author: Cheng
 * @Create: 2024/4/27 - 16:14
 * @Version: v1.0
 */
@RestController
public class PayGatewayController {
    @Resource
    PayService payService;

    @GetMapping(value = "/pay/gateway/get/{id}")
    public ResultData<Pay> getById(@PathVariable("id") Integer id) {
        Pay pay = payService.getById(id);
        return ResultData.success(pay);
    }

    @GetMapping(value = "/pay/gateway/info")
    public ResultData<String> getGatewayInfo() {
        return ResultData.success("gateway info test：" + IdUtil.simpleUUID());
    }

    @GetMapping(value = "/pay/gateway/filter")
    public ResultData<String> getFilterEnds(HttpServletRequest req) {
        Enumeration<String> headerNames = req.getHeaderNames();
        Iterator<String> iterator = headerNames.asIterator();

        String result = "";
        while (iterator.hasNext()) {
            String headerName = iterator.next();
            String headerValue = req.getHeader(headerName);
            System.out.println(headerName + ": \t" + headerValue);
            if (headerName.equalsIgnoreCase("X-Request-xx1") ||
                    headerName.equalsIgnoreCase("X-Request-yy2")) {
                result += headerName + ":\t" + headerValue;
            }
        }

        String userId = req.getParameter("userId");
        System.out.println("userId = " + userId);
        String userName = req.getParameter("userName");
        System.out.println("userName = " + userName);

        result += "userId: " + userId;
        result += "userName: " + userName;

        return ResultData.success("gateway filter test: " + result + DateUtil.date());
    }
}
