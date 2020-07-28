package com.cbb.sentinel.fallback;

import com.cbb.sentinel.entity.Result;
import com.cbb.sentinel.service.AccountService;
import org.springframework.stereotype.Component;

/**
 * @author chengbb
 * @date 2020.7.27
 */
@Component
public class AccountServiceFallBack implements AccountService {

    @Override
    public Result reduceAccount(String userId) {
        return Result.getFailResult("AccountServiceFallBack userId:" + userId);
    }
}

