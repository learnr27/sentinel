package com.cbb.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.cbb.sentinel.entity.Result;
import com.cbb.sentinel.handler.CustomerBlockHandler;
import com.cbb.sentinel.handler.CustomerFallBackHandler;
import com.cbb.sentinel.service.AccountService;
import com.cbb.sentinel.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author chengbb
 * @date 2020.7.27
 */
@RestController
@Slf4j
public class OrderController {

    @Resource
    private OrderService orderService;

    @Resource
    private AccountService accountService;

    @SentinelResource(value = "message",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "blockHandlerException",
            fallbackClass = CustomerFallBackHandler.class,
            fallback = "fallBackHandlerException1")
    @RequestMapping("/message")
    public String message() {
        return UUID.randomUUID().toString();
    }

    @RequestMapping("/createOrder")
    public Result createOrder() {
        log.info("createOrder:{}", UUID.randomUUID());
        Result result = accountService.reduceAccount(UUID.randomUUID().toString());
        if (result.isSuccess()) {
            return orderService.createOrder();
        }
        return result;
    }

    @RequestMapping("/createOrder1")
    public Result createOrder1() {
        log.info("createOrder:{}", UUID.randomUUID());
        return orderService.createOrder();
    }

    @RequestMapping("/cancelOrder")
    @SentinelResource(value = "cancelOrder",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "blockHandlerException",
            fallbackClass = CustomerFallBackHandler.class,
            fallback = "fallBackHandlerException1")
    public String cancelOrder() {
        int a = 1 / 0;
        return UUID.randomUUID().toString();
    }

    /**
     * 平均响应时间 ：当资源的平均响应时间超过阈值（以 ms 为单位）之后，资源进入准降级状态。
     * 如果接下来 1s 内持续进入 5 个请求，它们的 RT都持续超过这个阈值，
     * 那么在接下的时间窗口（以 s 为单位）之内，就会对这个方法进行服务降级
     *
     * @return
     */
    @RequestMapping("/rt")
    @SentinelResource(value = "rt",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "blockHandlerException",
            fallbackClass = CustomerFallBackHandler.class,
            fallback = "fallBackHandlerException1")
    public String rt() {
        return UUID.randomUUID().toString();
    }

    /**
     * 异常数 ：当资源近 1 分钟的异常数目超过阈值之后会进行服务降级。
     * 注意由于统计时间窗口是分钟级别的，若时间窗口小于 60s，则结束熔断状态后仍可能再进入熔断状态
     *
     * @return
     */
    @RequestMapping("/exceptionNum")
    @SentinelResource(value = "exceptionNum",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "blockHandlerException",
            fallbackClass = CustomerFallBackHandler.class,
            fallback = "fallBackHandlerException1")
    public String exceptionNum() {
        i++;
        if (i % 3 == 0) {
            i = i / 0;
        }
        return UUID.randomUUID().toString();
    }

    int i = 0;

    /**
     * 异常比例：当资源的每秒异常总数占通过量的比值超过阈值之后，
     * 资源进入降级状态，即在接下的时间窗口（以 s 为单位）之内，
     * 对这个方法的调用都会自动地返回。异常比率的阈值范围是 [0.0,1.0]
     *
     * @return
     */
    @RequestMapping("/exceptionRatio")
    @SentinelResource(value = "exceptionRatio")
    public String exceptionRatio() {
        i++;
        if (i % 3 == 0) {
            i = i / 0;
        }
        return UUID.randomUUID().toString();
    }

    /**
     * 热点规则
     *
     * @param name
     * @param age
     * @return
     */
    @RequestMapping("/hotSpotRules")
    @SentinelResource(value = "hotSpotRules",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "blockHandlerException",
            fallbackClass = CustomerFallBackHandler.class,
            fallback = "fallBackHandlerException1")
    public String hotSpotRules(String name, Integer age) {
        return name + age;
    }

    /**
     * 授权规则
     *
     * @return
     */
    @RequestMapping("/authorizationRules")
    @SentinelResource(value = "authorizationRules")
    public String authorizationRules(String serviceName) {
        return serviceName + UUID.randomUUID().toString();
    }


}
