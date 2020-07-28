package com.cbb.sentinel.service;

import com.cbb.sentinel.entity.Result;
import com.cbb.sentinel.fallback.AccountServiceFallBackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author chengbb
 * @date 2020.7.27
 */
@FeignClient(value = "sentinel-account-service",
        //  fallback = AccountServiceFallBack.class
        fallbackFactory = AccountServiceFallBackFactory.class //容错类中拿到具体的错误
)
public interface AccountService {

    @RequestMapping(value = "/reduceAccount")
    Result reduceAccount(@RequestParam("userId") String userId);
}
