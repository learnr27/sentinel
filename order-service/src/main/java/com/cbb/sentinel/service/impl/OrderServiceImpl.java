package com.cbb.sentinel.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.cbb.sentinel.entity.Result;
import com.cbb.sentinel.handler.CustomerBlockHandler;
import com.cbb.sentinel.service.OrderService;
import org.springframework.stereotype.Service;

/**
 * 统一
 * @author chengbb
 * @date 2020.7.27
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Override
    @SentinelResource(value = "createOrder",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "blockHandlerException")
    public Result createOrder() {
        return Result.getSuccessResult();
    }
}
