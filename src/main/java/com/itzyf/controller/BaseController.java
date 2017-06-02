package com.itzyf.controller;

import com.itzyf.bean.Result;

/**
 * @author 依风听雨
 * @version 创建时间：2017/6/2 10:07
 */
public class BaseController {

    protected  <T> Result<T> createResult(T t) {
        Result<T> result = new Result<>();
        result.setMsg("成功");
        result.setCode(0);
        if (t != null)
            result.setResult(t);
        return result;
    }
}
