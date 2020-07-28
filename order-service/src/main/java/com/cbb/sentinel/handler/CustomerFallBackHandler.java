package com.cbb.sentinel.handler;

import com.cbb.sentinel.entity.Result;
import lombok.extern.slf4j.Slf4j;

/**
 * 自定义FallBack异常返回
 *
 * @author chengbb
 * @date 2020.7.27
 */
@Slf4j
public class CustomerFallBackHandler {

    public static Result fallBackHandlerException(Throwable throwable) {
        log.error("{}", throwable);
        return Result.getFailResult(500, "自定义 global fallBackHandlerException");
    }

    public static Result fallBackHandlerException1(Throwable throwable) {
        log.error("{}", throwable);
        return Result.getFailResult(501, "自定义 global fallBackHandlerException1");
    }
}
