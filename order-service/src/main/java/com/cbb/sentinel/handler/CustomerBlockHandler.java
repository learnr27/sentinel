package com.cbb.sentinel.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.cbb.sentinel.entity.Result;

/**
 * 自定义异常返回 方式1
 *
 * @author chengbb
 * @date 2020.7.27
 */
public class CustomerBlockHandler {

    public static Result blockHandlerException(BlockException exception) {
        return Result.getFailResult(400, "自定义 global blockHandlerException");
    }

    public static Result blockHandlerException1(BlockException exception) {
        return Result.getFailResult(401, "自定义 global blockHandlerException1");
    }
}
