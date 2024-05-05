package com.atguigu.cloud.apis;

import com.atguigu.cloud.resp.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * ClassName:AccountFeignApi
 * Package: com.atguigu.cloud.apis
 * Description:
 *
 * @Author: Cheng
 * @Create: 2024/5/5 - 14:14
 * @Version: v1.0
 */
@FeignClient("seata-account-service")
public interface AccountFeignApi {

    /**
     * 扣减账户余额
     */
    @PostMapping("/account/decrease")
    ResultData decrease(@RequestParam("userId") Long userId, @RequestParam("money") Long money);
}
