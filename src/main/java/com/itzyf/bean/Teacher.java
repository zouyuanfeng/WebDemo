package com.itzyf.bean;

import java.sql.Date;

/**
 * @author 依风听雨
 * @version 创建时间：2017/6/2 9:56
 */
public class Teacher {
    private String Tno;
    private String Tname;
    private String Tsex;
    private Date Tbirthday;
    private String Prof;//职级
    private String Depart;

    public String getTno() {
        return Tno;
    }

    public void setTno(String tno) {
        Tno = tno;
    }

    public String getTname() {
        return Tname;
    }

    public void setTname(String tname) {
        Tname = tname;
    }

    public String getTsex() {
        return Tsex;
    }

    public void setTsex(String tsex) {
        Tsex = tsex;
    }

    public Date getTbirthday() {
        return Tbirthday;
    }

    public void setTbirthday(Date tbirthday) {
        Tbirthday = tbirthday;
    }

    public String getProf() {
        return Prof;
    }

    public void setProf(String prof) {
        Prof = prof;
    }

    public String getDepart() {
        return Depart;
    }

    public void setDepart(String depart) {
        Depart = depart;
    }
}
