package com.atguigu.cloud.apis;

import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * ClassName:PayFeignApi
 * Package: com.atguigu.cloud.apis
 * Description:
 *
 * @Author: Cheng
 * @Create: 2024/4/26 - 9:54
 * @Version: v1.0
 */
//@FeignClient(value="cloud-payment-service")
@FeignClient(value="cloud-gateway")
public interface PayFeignApi {
    /**
     * 新增支付订单流水
     * @param payDTO
     * @return
     */
    @PostMapping("pay/add")
    ResultData addOrder(@RequestBody PayDTO payDTO);

    /**
     * 根据id删除流水
     * @param id
     * @return
     */
    @PostMapping("pay/delete/{id}")
    ResultData deleteOrder(@PathVariable("id") Integer id);

    /**
     * 获取consul存储的info
     * @return
     */
    @GetMapping("pay/get/consul/info")
    String getInfoByConsul();

    @GetMapping("pay/get/{id}")
    ResultData getById(@PathVariable("id") Integer id);

    /**
     * circuit接口
     * @param id
     * @return
     */
    @GetMapping("pay/circuit/{id}")
    String myCircuit(@PathVariable("id") Integer id);

    @GetMapping(value = "/pay/bulkhead/{id}")
    String myBulkhead(@PathVariable("id") Integer id);

    @GetMapping(value = "/pay/ratelimit/{id}")
    String myRatelimit(@PathVariable("id") Integer id);

    @GetMapping(value = "/pay/micrometer/{id}")
    String myMicrometer(@PathVariable("id") Integer id);

    // 网关

    @GetMapping(value = "/pay/gateway/info")
    ResultData<String> getGatewayInfo();

    @GetMapping(value = "/pay/gateway/get/{id}")
    ResultData getById2(@PathVariable("id") Integer id);

    @GetMapping(value = "/pay/gateway/filter")
    ResultData<String> getFilterEnds(HttpServletRequest req);
}
