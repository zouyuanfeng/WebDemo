package com.itzyf.service;

import com.alibaba.druid.util.StringUtils;
import com.google.gson.Gson;
import com.itzyf.bean.JsapiTicket;
import com.itzyf.bean.WxAccessToken;
import com.itzyf.bean.WxUserInfo;
import com.itzyf.bean.WxWebAccessToken;
import com.itzyf.util.GlobalConfig;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Random;

/**
 * @author 依风听雨
 * @version 创建时间：2017/6/12 10:31
 */
@Service("wxService")
public class WxService {
    private static Logger logger = Logger.getLogger(WxService.class);
    private static final String WX_API = "https://api.weixin.qq.com/";
    private OkHttpClient client = new OkHttpClient();
    private static final String appID = GlobalConfig.getConfig().getConfigValue("wx_app_id");
    private static final String appSecret = GlobalConfig.getConfig().getConfigValue("wx_app_secret");
    private static final String ACCESS_TOKEN_KEY = "access_token";
    private static final String REFRESH_TOKEN_KEY = "refresh_token";

    private static final String JSAPI_TICKET_KEY = "JsapiTicket";

    private final RedisClientTemplate redisClientTemplate;

    @Autowired
    public WxService(RedisClientTemplate redisClientTemplate) {
        this.redisClientTemplate = redisClientTemplate;
    }

    /**
     * 获取access_token并缓存
     *
     * @return
     */
    public WxAccessToken getAccessToken() {
        String access_token = redisClientTemplate.get(ACCESS_TOKEN_KEY);
        if (StringUtils.isEmpty(access_token)) {
            String result = request(WX_API + "cgi-bin/token?grant_type=client_credential&appid=" + appID + "&secret=" + appSecret);
            redisClientTemplate.set(ACCESS_TOKEN_KEY, result);
            redisClientTemplate.expire(ACCESS_TOKEN_KEY, 7000);
            return new Gson().fromJson(result, WxAccessToken.class);
        } else
            return new Gson().fromJson(access_token, WxAccessToken.class);
    }


    public String getJsapiTicket() {
        String jsapiTicket = redisClientTemplate.get(JSAPI_TICKET_KEY);
        if (StringUtils.isEmpty(jsapiTicket)) {
            String url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=" + getAccessToken().getAccess_token() + "&type=jsapi";
            String result = request(url);
            redisClientTemplate.set(JSAPI_TICKET_KEY, result);
            redisClientTemplate.expire(JSAPI_TICKET_KEY, 7000);
            return new Gson().fromJson(result, JsapiTicket.class).getTicket();
        } else {
            return new Gson().fromJson(jsapiTicket, JsapiTicket.class).getTicket();
        }
    }

    public WxWebAccessToken getWebAccessToken(String code) {
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + appID + "&secret=" + appSecret + "&code=" + code + "&grant_type=authorization_code";
        String result = request(url);
        WxWebAccessToken wxWebAccessToken = new Gson().fromJson(result, WxWebAccessToken.class);
        redisClientTemplate.set(wxWebAccessToken.getOpenid() + ACCESS_TOKEN_KEY, result);
        redisClientTemplate.expire(ACCESS_TOKEN_KEY, 7000);
        redisClientTemplate.set(wxWebAccessToken.getOpenid() + REFRESH_TOKEN_KEY, wxWebAccessToken.getRefresh_token());
        redisClientTemplate.expire(wxWebAccessToken.getOpenid() + REFRESH_TOKEN_KEY, 10 * 24 * 60 * 60); //缓存十天
        return wxWebAccessToken;
    }

    /**
     * 获取缓存的access_token
     *
     * @param openId
     * @return
     */
    public WxWebAccessToken getCacheWebAccessToken(String openId) {
        String s = redisClientTemplate.get(openId + ACCESS_TOKEN_KEY);
        if (StringUtils.isEmpty(s)) {
            return refreshToken(openId); //刷新access_token
        }
        return new Gson().fromJson(s, WxWebAccessToken.class);
    }

    private WxWebAccessToken refreshToken(String openId) {
        String refresh_token = redisClientTemplate.get(openId + REFRESH_TOKEN_KEY);
        String url = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=APPID&grant_type=refresh_token&refresh_token=" + refresh_token;
        String result = request(url);
        WxWebAccessToken wxWebAccessToken = new Gson().fromJson(result, WxWebAccessToken.class);
        redisClientTemplate.set(wxWebAccessToken.getOpenid() + ACCESS_TOKEN_KEY, result);
        redisClientTemplate.expire(ACCESS_TOKEN_KEY, 7000);
        redisClientTemplate.set(wxWebAccessToken.getOpenid() + REFRESH_TOKEN_KEY, wxWebAccessToken.getRefresh_token());
        redisClientTemplate.expire(wxWebAccessToken.getOpenid() + REFRESH_TOKEN_KEY, 10 * 24 * 60 * 60); //缓存十天
        return wxWebAccessToken;
    }

    /**
     * 获取用户信息
     *
     * @param openId
     * @return
     */
    public WxUserInfo getUserInfo(String openId) {
        String url = "https://api.weixin.qq.com/sns/userinfo?access_token=" + getCacheWebAccessToken(openId).getAccess_token() + "&openid=" + openId + "&lang=zh_CN";
        logger.info("getUserInfo:" + url);
        String request = request(url);
        logger.debug("getUserInfo:response" + request);
        return new Gson().fromJson(request, WxUserInfo.class);
    }


    /***
     * 授权
     * @return
     */
    public String authorize(String redirect_uri) {
        String code = getRandomString();
        String enUrl = "";
        try {
            enUrl = URLEncoder.encode(redirect_uri, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + appID + "&redirect_uri=" + enUrl + "&response_type=code&scope=snsapi_userinfo&state=" + code + "#wechat_redirect";
    }


    public String getRandomString() { //length表示生成字符串的长度
        String base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    private String request(String url) {
        try {
            Request request = new Request.Builder().url(url).build();
            Response response = client.newCall(request).execute();
            if (response.isSuccessful() && response.body() != null) {
                return response.body().string();
            } else {
                throw new IOException("Unexpected code " + response);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
