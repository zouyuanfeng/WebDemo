package com.itzyf.bean;

/**
 * @author 依风听雨
 * @version 创建时间：2017/6/1 11:32
 */
public class Result<T> {
    private String msg;
    private int code;
    private T result;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
