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
@RequestMapping("/user")
@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    public Result addUser(@RequestBody User user) {
        return createResult(userService.add(user));
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Result<List<User>> getAll() {
        return createResult(userService.getAll());
    }

    @RequestMapping("/{id}")
    public Result<User> getUser(@PathVariable int id) {
        return createResult(userService.getUser(id));
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
