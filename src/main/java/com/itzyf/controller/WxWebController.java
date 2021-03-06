package com.itzyf.controller;

import com.google.gson.Gson;
import com.itzyf.bean.MaoYanMovies;
import com.itzyf.service.WxService;
import com.itzyf.util.GlobalConfig;
import com.itzyf.util.SignUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 依风听雨
 * @version 创建时间：2017/6/12 14:40
 */
@Controller
@RequestMapping("wx")
public class WxWebController {
    private static Logger logger = Logger.getLogger(WxWebController.class);
    private WxService wxService;

    @Autowired
    public WxWebController(WxService wxService) {
        this.wxService = wxService;
    }

    @RequestMapping("authorize")
    public String authorize() {
        return "redirect:" + wxService.authorize("http://itzyf.tunnel.whsz100.com/"); //授权完成之后回调该网址，并添加参数code和state
    }

    @RequestMapping("")
    public ModelAndView wxIndex(HttpServletRequest request) {

        StringBuilder sb = new StringBuilder();
        sb.append(request.getScheme()).append("://").append(request.getServerName());
        if (80 != request.getServerPort()) {
            sb.append(":").append(request.getServerPort());
        }
        sb.append(request.getServletPath());
        if (request.getQueryString() != null) {
            sb.append("?").append(request.getQueryString());
        }

        System.out.println(sb.toString());

        Map<String, Object> map = new HashMap<>();
        String nonceStr = wxService.getRandomString().toLowerCase();
        String timestamp = new Date().getTime() + "";
//        String url = request.getScheme() + "://" + request.getServerName() + "/wx"; //当前页面的链接
        String jsapi_ticket = wxService.getJsapiTicket();
        logger.info("ticket:" + jsapi_ticket);
        map.put("appId", GlobalConfig.getConfig().getConfigValue("wx_app_id"));
        map.put("nonceStr", nonceStr);
        map.put("timestamp", timestamp);
        map.put("signature", SignUtil.getSignature(timestamp, nonceStr, sb.toString(), jsapi_ticket));
        return new ModelAndView("wx", map);
    }

    @RequestMapping("movies")
    public String pageMovies() {
        return "movie";
    }


    @ResponseBody
    @RequestMapping("getMovies")
    public MaoYanMovies getMovies(@RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                                  @RequestParam(value = "pageNo", defaultValue = "0") int pageNo) {
        String result = wxService.request("http://m.maoyan.com/movie/list.json?type=hot&offset=" + pageNo * pageSize + "&limit=" + pageSize);
        logger.info(result);
        return new Gson().fromJson(result, MaoYanMovies.class);
    }


}
