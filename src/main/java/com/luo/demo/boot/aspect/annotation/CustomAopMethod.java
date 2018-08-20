package com.luo.demo.boot.aspect.annotation;

import java.lang.annotation.*;

/**
 * 自定义注解 可在aop中动态代理所有该主机修饰的方法
 *
 * @author xiangnan
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CustomAopMethod {
}
