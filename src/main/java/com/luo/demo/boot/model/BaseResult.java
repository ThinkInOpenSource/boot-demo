package com.luo.demo.boot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * model基础类
 *
 * @author xiangnan
 * date 2018/7/27 23:43
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseResult {
    private boolean success = true;
    private String  msg;
    private Object  data;

    public static BaseResult success(Object data) {
        return new BaseResult(true, null, data);
    }

    public static BaseResult fail(Throwable e) {
        return new BaseResult(false, e.getMessage(), null);
    }

    public static BaseResult fail(String msg) {
        return new BaseResult(false, msg, null);
    }

    public static BaseResult fail(String msg, Object data) {
        return new BaseResult(false, msg, data);
    }

}
