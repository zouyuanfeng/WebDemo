package com.itzyf.bean;

import java.sql.Date;

/**
 * @author 依风听雨
 * @version 创建时间：2017/6/2 9:56
 */
public class Course {
    private String Cno;
    private String Cname;
    private Teacher teacher;

    private String Tno;
    private String Tname;
    private String Tsex;
    private Date Tbirthday;
    private String Prof;//职级

    public void setTname(String tname) {
        Tname = tname;
    }

    public void setTsex(String tsex) {
        Tsex = tsex;
    }

    public void setTbirthday(Date tbirthday) {
        Tbirthday = tbirthday;
    }

    public void setProf(String prof) {
        Prof = prof;
    }

    public void setDepart(String depart) {
        Depart = depart;
    }

    private String Depart;

    public String getCno() {
        return Cno;
    }

    public void setCno(String cno) {
        Cno = cno;
    }

    public String getCname() {
        return Cname;
    }

    public void setCname(String cname) {
        Cname = cname;
    }

//    public String getTno() {
//        return Tno;
//    }

    public void setTno(String tno) {
        Tno = tno;
    }

    public Teacher getTeacher() {
        if (teacher == null) {
            teacher = new Teacher();
            teacher.setDepart(Depart);
            teacher.setProf(Prof);
            teacher.setTbirthday(Tbirthday);
            teacher.setTname(Tname);
            teacher.setTno(Tno);
            teacher.setTsex(Tsex);
        }
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

//    public String getTname() {
//        return Tname;
//    }
//
//    public void setTname(String tname) {
//        Tname = tname;
//    }
//
//    public String getTsex() {
//        return Tsex;
//    }
//
//    public void setTsex(String tsex) {
//        Tsex = tsex;
//    }
//
//    public Date getTbirthday() {
//        return Tbirthday;
//    }
//
//    public void setTbirthday(Date tbirthday) {
//        Tbirthday = tbirthday;
//    }
//
//    public String getProf() {
//        return Prof;
//    }
//
//    public void setProf(String prof) {
//        Prof = prof;
//    }
//
//    public String getDepart() {
//        return Depart;
//    }
//
//    public void setDepart(String depart) {
//        Depart = depart;
//    }
}
