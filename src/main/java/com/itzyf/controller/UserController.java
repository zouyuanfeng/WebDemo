package com.itzyf.controller;

import com.itzyf.bean.Result;
import com.itzyf.bean.User;
import com.itzyf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return createResult(userService.add(user));
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Result<List<User>> getAll() {
        Result<List<User>> result = new Result<>();
        return createResult(userService.getAll());
    }

    @RequestMapping("/user/{id}")
    public Result<User> getUser(@PathVariable int id) {
        User user = userService.getUser(id);
        return createResult(user);
    }

    @RequestMapping("/total")
    public Result<Long> getTotal() {
        return createResult(userService.getTotal());
    }

    private <T> Result<T> createResult(T t) {
        Result<T> result = new Result<>();
        result.setMsg("成功");
        result.setCode(0);
        if (t != null)
            result.setResult(t);
        return result;
    }
}
