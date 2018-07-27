package com.luo.demo.boot.model;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @author xiangnan
 * date 2018/7/27 23:09
 */
@Data
public class ParamModel {

    @NotBlank
    private String name;

    @Min(value = 0, message = "不能小于0")
    @Max(value = 120, message = "不能大于120")
    private int age;

    @Pattern(regexp = "^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$", message = "邮箱格式不合法")
    private String email;
}
