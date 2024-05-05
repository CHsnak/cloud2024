package com.atguigu.cloud.handler;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

/**
 * ClassName:MyRequestOriginParser
 * Package: com.atguigu.cloud.handler
 * Description:
 *
 * @Author: Cheng
 * @Create: 2024/5/4 - 14:49
 * @Version: v1.0
 */
@Component
public class MyRequestOriginParser implements RequestOriginParser {
    @Override
    public String parseOrigin(HttpServletRequest req) {
        return req.getParameter("serverName");
    }
}
