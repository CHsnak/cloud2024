package com.atguigu.cloud.mygateway;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.cloud.gateway.handler.predicate.GatewayPredicate;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ServerWebExchange;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

/**
 * ClassName:XxxRoutePredicateFactory
 * Package: com.atguigu.cloud.mygateway
 * Description:
 *
 * @Author: Cheng
 * @Create: 2024/4/27 - 18:24
 * @Version: v1.0
 */
@Component
public class XxxRoutePredicateFactory extends AbstractRoutePredicateFactory<XxxRoutePredicateFactory.Config> {
    public XxxRoutePredicateFactory() {
        super(XxxRoutePredicateFactory.Config.class);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Collections.singletonList("userType");
    }


    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return (GatewayPredicate) serverWebExchange -> {
            {
                //检查request的参数里面，userType是否为指定的值，符合配置就通过
                String userType = serverWebExchange.getRequest().getQueryParams().getFirst("userType");

                if (userType == null) {
                    return false;
                }

                //如果说参数存在，就和config的数据进行比较
                return userType.equals(config.getUserType());
            }
        };
    }


    @Validated
    public static class Config{
        private @NotEmpty String userType;

        public String getUserType() {
            return userType;
        }

        public void setUserType(String userType) {
            this.userType = userType;
        }
    }
}
