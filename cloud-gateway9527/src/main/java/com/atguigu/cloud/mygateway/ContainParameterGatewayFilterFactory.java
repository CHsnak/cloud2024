package com.atguigu.cloud.mygateway;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

/**
 * ClassName:ContainParameterGatewayFilterFactory
 * Package: com.atguigu.cloud.mygateway
 * Description:
 *
 * @Author: Cheng
 * @Create: 2024/5/3 - 14:20
 * @Version: v1.0
 */
@Component
@Slf4j
public class ContainParameterGatewayFilterFactory
        extends AbstractGatewayFilterFactory<ContainParameterGatewayFilterFactory.Config> {

    ContainParameterGatewayFilterFactory(){
        super(ContainParameterGatewayFilterFactory.Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            log.info("自定义过滤器：含有指定参数才放行！");
            MultiValueMap<String, String> queryParams = exchange.getRequest().getQueryParams();
            List<String> params = queryParams.get(config.getParamName());
            if(params == null){
                // 不放行
                exchange.getResponse().setStatusCode(HttpStatus.BAD_REQUEST);
                return exchange.getResponse().setComplete();
            }else {
                //放行
                return chain.filter(exchange);
            }
        };
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return List.of("paramName");
    }

    @Getter
    @Setter
    public static class Config{
        // 接收配置参数
        private String paramName;
    }
}
