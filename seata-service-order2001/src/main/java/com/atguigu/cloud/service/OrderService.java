package com.atguigu.cloud.service;

import com.atguigu.cloud.entities.Order;

/**
 * ClassName:OrderService
 * Package: com.atguigu.cloud.service
 * Description:
 *
 * @Author: Cheng
 * @Create: 2024/5/5 - 15:32
 * @Version: v1.0
 */
public interface OrderService {

    /**
     * 创建订单
     */
    void create(Order order);
}
