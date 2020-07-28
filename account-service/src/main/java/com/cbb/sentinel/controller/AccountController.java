package com.cbb.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.cbb.sentinel.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chengbb
 * @date 2020.7.24
 */
@RestController
@Slf4j
public class AccountController {


    @RequestMapping("/message")
    @SentinelResource(value = "message")
    public Result message(@RequestParam("msg") String msg) {
        log.info("userId:{}", msg);
        return Result.getSuccessResult(msg);
    }

    @RequestMapping("/reduceAccount")
    @SentinelResource(value = "reduceAccount",fallback = "reduceAccountFallback")
    public Result reduceAccount(@RequestParam("userId") String userId) {
        log.info("userId:{}", userId);
        return Result.getSuccessResult(userId);
    }

    public Result reduceAccountFallback(@RequestParam("userId") String userId) {
        log.info("userId:{}", userId);
        return Result.getFailResult(userId);
    }

}
