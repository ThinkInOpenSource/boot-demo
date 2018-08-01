package com.luo.demo.boot.configuration.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 请求客户端port拦截器
 *
 * @author xiangnan
 * date 2018/8/1 17:36
 */
public class PortInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(PortInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("PortInterceptor: requestPort={}", request.getRemotePort());
        return true;
    }

}
