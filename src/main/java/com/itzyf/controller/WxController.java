package com.itzyf.controller;

import com.alibaba.druid.util.StringUtils;
import com.itzyf.bean.WxAccessToken;
import com.itzyf.bean.WxUserInfo;
import com.itzyf.bean.WxWebAccessToken;
import com.itzyf.service.WxService;
import com.itzyf.util.SignUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author 依风听雨
 * @version 创建时间：2017/6/12 10:25
 */
@RequestMapping("wx")
@RestController
public class WxController {
    private static Logger logger = Logger.getLogger(WxController.class);

    private WxService wxService;

    @Autowired
    public WxController(WxService wxService) {
        this.wxService = wxService;
    }

    @RequestMapping("/interface")
    public String wxInterface(@RequestParam(value = "signature") String signature,
                              @RequestParam(value = "timestamp") String timestamp,
                              @RequestParam(value = "nonce") String nonce,
                              @RequestParam(value = "echostr") String echostr) {
        if (SignUtil.checkSignature(signature, timestamp, nonce)) {
            logger.info("验证成功！");
            return echostr;
        }
        logger.info("这里存在非法请求！");
        return "";
    }

    @RequestMapping("access-token")
    public WxAccessToken getAccessToken() {
        return wxService.getAccessToken();
    }

    @RequestMapping("web-access-token")
    public WxWebAccessToken getUserInfo(HttpSession httpSession, @RequestParam(defaultValue = "", value = "code") String code, @RequestParam(defaultValue = "", value = "openId") String openId) {
        WxWebAccessToken token = null;
        if (!StringUtils.isEmpty(code))
            token = wxService.getWebAccessToken(code);
        if (!StringUtils.isEmpty(openId))
            token = wxService.getCacheWebAccessToken(openId);
        if (token != null)
            httpSession.setAttribute("openId", token.getOpenid());
        return token;
    }

    @RequestMapping("userInfo")
    public WxUserInfo getUserInfo(HttpSession httpSession) {
        String openId = (String) httpSession.getAttribute("openId");
        return wxService.getUserInfo(openId);
    }

}
