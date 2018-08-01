package com.luo.demo.boot.configuration;

import com.luo.demo.boot.configuration.filter.IpFilter;
import com.luo.demo.boot.configuration.filter.PortFilter;
import com.luo.demo.boot.configuration.interceptors.IpInterceptor;
import com.luo.demo.boot.configuration.interceptors.PortInterceptor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author xiangnan
 * date 2018/8/1 17:32
 */
@Configuration
public class WebConfigurer implements WebMvcConfigurer {

    /**
     * 过滤器配置 filter
     */
    @Bean("ipFilterRegistrationBean")
    public FilterRegistrationBean ipFilterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();

        registrationBean.setFilter(new IpFilter());
        registrationBean.setUrlPatterns(Collections.singletonList("*"));
        return registrationBean;
    }

    @Bean("portFilterRegistrationBean")
    public FilterRegistrationBean portFilterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();

        registrationBean.setFilter(new PortFilter());
        registrationBean.setUrlPatterns(Collections.singleton("*"));
        return registrationBean;
    }

    /**
     * 拦截器配置 interceptor
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new IpInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(Arrays.asList("/**/*.css", "/**/*.js"));

        registry.addInterceptor(new PortInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(Arrays.asList("/**/*.css", "/**/*.js"));
    }

}
