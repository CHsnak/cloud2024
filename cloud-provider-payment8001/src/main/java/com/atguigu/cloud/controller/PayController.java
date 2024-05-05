package com.atguigu.cloud.controller;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson2.util.DateUtils;
import com.atguigu.cloud.entities.Pay;
import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ClassName:PayController
 * Package: com.atguigu.cloud.controller
 * Description:
 *
 * @Author: Cheng
 * @Create: 2024/4/10 - 10:23
 * @Version: v1.0
 */
@RestController
@Slf4j
@RequestMapping("pay")
@Tag(name = "支付微服务模块", description = "支付CRUD")
public class PayController {
    @Resource
    private PayService payService;

    @PostMapping("add")
    @Operation(summary = "新增",description = "新增支付流水方法,json串做参数")
    public ResultData<String> addPay(@RequestBody Pay pay) {
        return ResultData.success("插入成功，返回值为" + payService.add(pay));
    }

    @PostMapping("delete/{id}")
    @Operation(summary = "删除",description = "删除支付流水方法")
    public ResultData<String> removeById(@PathVariable("id") Integer id) {
        return ResultData.success("删除成功，返回值为" + payService.delete(id));
    }

    @PostMapping("update")
    @Operation(summary = "修改",description = "修改支付流水方法")
    public ResultData<String> updatePay(@RequestBody PayDTO payDTO) {
        Pay pay = new Pay();
        BeanUtils.copyProperties(payDTO, pay);
        return ResultData.success("更新成功，返回值为" + payService.update(pay));
    }

    @GetMapping("get/{id}")
    @Operation(summary = "按照ID查流水",description = "查询支付流水方法")
    public ResultData<Pay> getById(@PathVariable("id") Integer id) {
        if(id <= 0 ){
            throw new RuntimeException("测试全局异常处理器");
        }

        try {
            Thread.sleep(62 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return ResultData.success(payService.getById(id));
    }

    @GetMapping("get")
    @Operation(summary = "查询所有",description = "查询所有订单记录方法")
    public ResultData<List<Pay>> getAll() {
        return ResultData.success(payService.getAll());
    }


    @Value("${server.port}")
    private String port;

    @GetMapping("get/consul/info")
    public String getByConsul(@Value("${atguigu.info}") String atguiguInfo){
        return atguiguInfo +":::"+ port;
    }
}
