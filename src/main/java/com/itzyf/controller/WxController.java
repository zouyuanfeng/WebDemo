package com.itzyf.controller;

import com.alibaba.druid.util.StringUtils;
import com.itzyf.bean.*;
import com.itzyf.service.WxService;
import com.itzyf.util.MessageUtil;
import com.itzyf.util.SignUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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

    @RequestMapping(value = "/interface", method = RequestMethod.GET)
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

    @RequestMapping(value = "/interface", method = RequestMethod.POST)
    public String ReceiveMessage(HttpServletRequest request, HttpServletResponse response) {
        logger.info("这是 post 方法！");
        try {
            Map<String, String> map = MessageUtil.parseXml(request);
            String openid = map.get("FromUserName"); //用户 openid
            String mpid = map.get("ToUserName");   //公众号原始 ID

//普通文本消息
            TextMessage txtmsg = new TextMessage();
            txtmsg.setToUserName(openid);
            txtmsg.setFromUserName(mpid);
            txtmsg.setCreateTime(new Date().getTime());
            txtmsg.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);

            if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) { // 文本消息
                String content = map.get("Content");
                if ("1".equals(content)) {
                    txtmsg.setContent("你好，你发送的内容是 1！");
                }if ("主页".equals(content)){
                    txtmsg.setContent("http://itzyf.tunnel.whsz100.com/wx");
                } else{
                    txtmsg.setContent("你好，欢迎欢迎热烈欢迎！！！");
                }
                return MessageUtil.textMessageToXml(txtmsg);
            }
//            System.out.println("============================="+map.get("Content"));
        } catch (Exception e) {
            logger.error(e, e);
        }
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

    @ResponseBody
    @RequestMapping("menu")
    public WxError setMenu() {

        WxMenuSubButton vbt = new WxMenuSubButton();
        vbt.setUrl("http://itzyf.tunnel.whsz100.com/wx");
        vbt.setName("主页");
        vbt.setType("view");

//        WxMenuSubButton cbt = new WxMenuSubButton();
//        vbt.setUrl("http://itzyf.top");
//        cbt.setName("博客");
//        cbt.setType("view");

//        WxMenuSubButton vbt2 = new WxMenuSubButton();
//        vbt2.setUrl("http://zouyuanfeng.github.com");
//        vbt2.setName("GitHub");
//        vbt2.setType("view");

        WxMenu menu = new WxMenu();
        List<WxMenuSubButton> buttons = new ArrayList<>();
//        buttons.add(cbt);
        buttons.add(vbt);
//        buttons.add(vbt2);
        menu.setButton(buttons);

        return wxService.setMenu(menu);

    }

}
