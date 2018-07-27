package com.luo.demo.boot.exception;

/**
 * 参数错误异常
 *
 * @author xiangnan
 * date 2018/7/27 23:38
 */
public class ParamValidException extends RuntimeException {

    public ParamValidException(String msg) {
        super(msg);
    }

    public ParamValidException(String msg, Throwable e) {
        super(msg, e);
    }

}
