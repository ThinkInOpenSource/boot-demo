package com.luo.demo.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xiangnan
 * date 2018/7/27 17:52
 */
@SpringBootApplication
@MapperScan("com.luo.demo.boot.dao")
public class BootApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class, args);
    }

}
