package com.cbb.sentinel.fallback;

import com.cbb.sentinel.entity.Result;
import com.cbb.sentinel.service.AccountService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author chengbb
 * @date 2020.7.27
 */
@Component
public class AccountServiceFallBackFactory implements FallbackFactory<AccountService> {

    @Override
    public AccountService create(Throwable throwable) {

        return new AccountService() {
            @Override
            public Result reduceAccount(String userId) {
                throwable.printStackTrace();
                return Result.getFailResult("AccountServiceFallBackFactory");
            }
        };
    }
}

