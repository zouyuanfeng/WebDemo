package com.itzyf.controller;

import com.itzyf.bean.Result;
import com.itzyf.bean.User;
import com.itzyf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 依风听雨
 * @version 创建时间：2017/6/1 11:31
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    public Result addUser(@RequestBody User user) {
        Result result = new Result();
        result.setMsg("成功");
        result.setCode(0);
        userService.add(user);
        return result;
    }
}
