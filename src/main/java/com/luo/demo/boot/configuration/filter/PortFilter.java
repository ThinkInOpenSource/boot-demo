package com.luo.demo.boot.configuration.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * 请求客户端port过滤器
 *
 * @author xiangnan
 * date 2018/8/1 17:43
 */
public class PortFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(PortFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        logger.info("PortFilter.doFilter: requestPort={}", request.getRemotePort());
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
