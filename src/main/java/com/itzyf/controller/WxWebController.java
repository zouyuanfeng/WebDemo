package com.itzyf.controller;

import com.itzyf.service.WxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 依风听雨
 * @version 创建时间：2017/6/12 14:40
 */
@Controller
@RequestMapping("wx")
public class WxWebController {
    private WxService wxService;

    @Autowired
    public WxWebController(WxService wxService) {
        this.wxService = wxService;
    }

    @RequestMapping("authorize")
    public String authorize() {
        return "redirect:" + wxService.authorize("http://itzyf.tunnel.whsz100.com/"); //授权完成之后回调该网址，并添加参数code和state
    }


}
