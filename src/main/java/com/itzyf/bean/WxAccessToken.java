package com.itzyf.bean;

/**
 * @author 依风听雨
 * @version 创建时间：2017/6/12 10:41
 */
public class WxAccessToken {

    /**
     * access_token : D_Al7E6QXmqSv61PSJ9cxiha0CsIHxwtZGFIo3bJSDfsesz9LVqhf_xzBNUHxxzd7am_03Vpfk_BqV1h53Q3IAYSfOUSRPhifIL6MyddPo6pOFmw2Y1Yo-ockynnbH0zHUHfADAOBO
     * expires_in : 7200
     */

    private String access_token;
    private int expires_in;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }
}
