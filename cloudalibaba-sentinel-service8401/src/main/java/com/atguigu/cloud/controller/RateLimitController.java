package com.atguigu.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:RateLimitController
 * Package: com.atguigu.cloud.controller
 * Description:
 *
 * @Author: Cheng
 * @Create: 2024/5/4 - 13:46
 * @Version: v1.0
 */
@RestController
public class RateLimitController {
    @GetMapping("rlc/byResource")
    @SentinelResource(value = "sentinel-res-01", blockHandler = "handleBlock1")
    public String byResource() {
        return "流控，使用@SentinelResource";
    }

    public String handleBlock1(BlockException blockException) {
        return "限流了！微服务不可用";
    }

    @GetMapping("rlc/byRes2/{num}")
    @SentinelResource(value = "sentinel-res-02", blockHandler = "handleBlock2", fallback = "fallback2")
    public String byResource2(@PathVariable("num") Integer num) {
        if (num == 0) {
            int i = 1 / 0;
        }
        return "流控2，使用@SentinelResource\t" + num;
    }
    public String handleBlock2(@PathVariable("num") Integer num,BlockException blockException) {
        return "限流了！微服务不可用";
    }
    public String fallback2(@PathVariable("num") Integer num,Throwable e) {
        return "程序异常！服务降级。";
    }


    @GetMapping("rlc/testHotKey")
    @SentinelResource(value = "sentinel-res-03", blockHandler = "handleBlock3")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2) {
        return "热点监控：p1 = "+p1+"\tp2="+p2;
    }

    public String handleBlock3(String p1,String p2, BlockException blockException) {
        return "限流了！微服务不可用";
    }

}
