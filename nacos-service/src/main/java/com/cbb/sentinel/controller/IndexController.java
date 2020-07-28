package com.cbb.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * 验证规则配置nacos实例化
 *
 * @author chengbb
 * @date 2020.7.28
 */
@RestController
@Slf4j
public class IndexController {

    @SentinelResource(value = "message")
    @RequestMapping("/message")
    public String message() {
        return UUID.randomUUID().toString();
    }

    @SentinelResource(value = "message1")
    @RequestMapping("/message1")
    public String message1() {
        return UUID.randomUUID().toString();
    }


    @SentinelResource(value = "rt")
    @RequestMapping("/rt")
    public String rt() {
        return UUID.randomUUID().toString();
    }

    @SentinelResource(value = "rt1")
    @RequestMapping("/rt1")
    public String rt1() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return UUID.randomUUID().toString();
    }
}
