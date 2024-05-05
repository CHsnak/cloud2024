package com.atguigu.cloud.service;

/**
 * ClassName:StorageService
 * Package: com.atguigu.cloud.service
 * Description:
 *
 * @Author: Cheng
 * @Create: 2024/5/5 - 16:32
 * @Version: v1.0
 */
public interface StorageService {
    /**
     * 扣减库存
     */
    void decrease(Long productId, Integer count);
}
