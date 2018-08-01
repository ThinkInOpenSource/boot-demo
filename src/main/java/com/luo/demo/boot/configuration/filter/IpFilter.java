package com.luo.demo.boot.configuration.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

/**
 * 请求客户端IP过滤器
 *
 * @author xiangnan
 * date 2018/8/1 17:42
 */
public class IpFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(IpFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        logger.info("IpFilter.doFilter: requestIp={}", request.getRemoteAddr());
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
