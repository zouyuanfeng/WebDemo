package com.itzyf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 依风听雨
 * @version 创建时间：2017/6/1 9:37
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public ModelAndView index() {
        Map<String, Object> map = new HashMap<>();
        map.put("END", "我是测试的");
        return new ModelAndView("index", map);
    }
}
