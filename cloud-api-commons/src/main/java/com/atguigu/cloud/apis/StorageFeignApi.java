package com.atguigu.cloud.apis;

import com.atguigu.cloud.resp.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * ClassName:StorageFeignApi
 * Package: com.atguigu.cloud.apis
 * Description:
 *
 * @Author: Cheng
 * @Create: 2024/5/5 - 14:12
 * @Version: v1.0
 */
@FeignClient("seata-storage-service")
public interface StorageFeignApi {
    @PostMapping(value = "/storage/decrease")
    ResultData decrease(@RequestParam("productId") Long productId,
                        @RequestParam("count") Integer count);
}


