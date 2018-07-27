package com.luo.demo.boot.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiangnan
 * date 2018/7/27 17:54
 */
@RestController
public class IndexController {

    @Value("${application.index.info}")
    private String info;

    @GetMapping("/")
    public String index() {
        return info;
    }

}
