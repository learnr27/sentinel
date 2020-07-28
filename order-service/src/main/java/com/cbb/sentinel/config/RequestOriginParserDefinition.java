package com.cbb.sentinel.config;


import com.alibaba.csp.sentinel.adapter.servlet.callback.RequestOriginParser;
import com.alibaba.csp.sentinel.util.StringUtil;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author chengbb
 * @date 2020.7.28
 */
@Component
public class RequestOriginParserDefinition implements RequestOriginParser {


    @Override
    public String parseOrigin(HttpServletRequest request) {
        String serviceName = request.getParameter("serviceName");
        if (StringUtil.isEmpty(serviceName)) {
            new RuntimeException("serviceName is empty");
        }
        return serviceName;
    }
}
