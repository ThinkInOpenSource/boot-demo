package com.luo.demo.boot.web;

import com.luo.demo.boot.model.ParamModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author xiangnan
 * date 2018/7/27 17:54
 */
@RestController
public class IndexController {

    @Value("${application.index.info}")
    private String info;

    @GetMapping("/")
    public Object index() {
        return info;
    }

    @GetMapping("/param")
    public Object testParam(@Valid ParamModel paramModel, BindingResult bindingResult) {
        System.out.println(paramModel);
        return paramModel;
    }

}
