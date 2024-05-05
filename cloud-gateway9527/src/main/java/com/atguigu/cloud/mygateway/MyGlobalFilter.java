package com.atguigu.cloud.mygateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.security.PrivateKey;

/**
 * ClassName:MyGlobalFilter
 * Package: com.atguigu.cloud.mygateway
 * Description:
 *
 * @Author: Cheng
 * @Create: 2024/5/3 - 13:33
 * @Version: v1.0
 */
@Component
@Slf4j
public class MyGlobalFilter implements GlobalFilter, Ordered {
    private final String START_VISIT_TIME = "start-visit-time";
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        exchange.getAttributes().put(START_VISIT_TIME,System.currentTimeMillis());
        return chain.filter(exchange).then(Mono.fromRunnable(()->{
            Long startVisitTime = exchange.getAttribute(START_VISIT_TIME);
            log.info("访问的主机："+exchange.getRequest().getURI().getHost());
            log.info("访问的端口："+exchange.getRequest().getURI().getPort());
            log.info("访问的URL："+exchange.getRequest().getURI().getRawPath());
            log.info("访问的URL参数："+exchange.getRequest().getQueryParams());
            log.info("访问接口的时耗："+(System.currentTimeMillis() - startVisitTime)+"毫秒");
            log.info("---------------");
        }));
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
