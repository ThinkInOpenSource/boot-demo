package com.luo.demo.boot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author xiangnan
 * date 2018/8/14
 */
@Slf4j
@Service
public class HelloService {

    public void hello() {
        log.info("HelloService.hello()");
    }

}
