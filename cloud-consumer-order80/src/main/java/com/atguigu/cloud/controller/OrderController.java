package com.atguigu.cloud.controller;

import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * ClassName:OrderController
 * Package: com.atguigu.cloud.controller
 * Description:
 *
 * @Author: Cheng
 * @Create: 2024/4/10 - 15:09
 * @Version: v1.0
 */
@RestController
@RequestMapping("consumer")
public class OrderController {
    // private static final String PAYMENT_SRV_URL = "http://localhost:8001/";
    private static final String PAYMENT_SRV_URL = "http://cloud-payment-service";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("pay/add")
    public ResultData addOrder(PayDTO payDTO){
        return restTemplate.postForObject(PAYMENT_SRV_URL + "/pay/add", payDTO, ResultData.class);
    }

    @GetMapping("pay/update")
    public ResultData updateOrder(PayDTO payDTO){
        return restTemplate.postForObject(PAYMENT_SRV_URL+"/pay/update",payDTO,ResultData.class);
    }

    @GetMapping("pay/delete/{id}")
    public ResultData deleteOrder(@PathVariable("id") Integer id){
        return restTemplate.postForObject(PAYMENT_SRV_URL+"/pay/delete/"+id,id,ResultData.class);
    }

    @GetMapping("pay/get/{id}")
    public ResultData getById(@PathVariable("id") Integer id){
        return restTemplate.getForObject(PAYMENT_SRV_URL+"/pay/get/"+id,ResultData.class);
    }

    @GetMapping(value = "pay/get/info")
    private String getInfoByConsul()
    {
        return restTemplate.getForObject(PAYMENT_SRV_URL + "/pay/get/consul/info", String.class);
    }


    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("discovery")
    public String discovery(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            System.out.println(service);
        }

        System.out.println("=======================");

        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        for (ServiceInstance instance : instances) {
            System.out.println(instance.getServiceId() + "\t" + instance.getHost() + "\t"+ instance.getPort()+"\t"+instance.getUri());
        }

        return "成功\t"+instances.get(0).getServiceId()+":"+instances.get(0).getPort();
    }

}
