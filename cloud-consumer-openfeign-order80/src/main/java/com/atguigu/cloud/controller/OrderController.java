package com.atguigu.cloud.controller;

import cn.hutool.core.date.DateUtil;
import com.atguigu.cloud.apis.PayFeignApi;
import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.resp.ReturnCodeEnum;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName:Controller
 * Package: com.atguigu.cloud.controller
 * Description:
 *
 * @Author: Cheng
 * @Create: 2024/4/26 - 8:45
 * @Version: v1.0
 */
@RestController
@RequestMapping("feign/consumer")
@Slf4j
public class OrderController {
    @Resource
    private PayFeignApi payFeignApi;

    @PostMapping("pay/add")
    ResultData addOrder(@RequestBody PayDTO payDTO){
        log.info("我的日志：增加订单");
        return payFeignApi.addOrder(payDTO);
    }

    @PostMapping("pay/delete/{id}")
    ResultData deleteOrder(@PathVariable("id") Integer id){
        log.info("我的日志：根据id删除订单");
        return payFeignApi.deleteOrder(id);
    }

    @GetMapping("pay/get/info")
    String getInfoByConsul(){
        log.info("我的日志：天然支持负载均衡");
        return payFeignApi.getInfoByConsul();
    }

    @GetMapping("pay/get/{id}")
    ResultData getById(@PathVariable("id") Integer id){
        log.info("\n\t我的日志：根据id查询订单");
        ResultData resultData = null;
        try
        {
            System.out.println("调用开始-----:"+ DateUtil.now());
            resultData = payFeignApi.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("调用结束-----:"+DateUtil.now());
            resultData = ResultData.fail(ReturnCodeEnum.RC500.getCode(),e.getMessage());
        }
        return resultData;
    }
}
