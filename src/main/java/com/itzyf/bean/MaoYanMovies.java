package com.itzyf.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author 依风听雨
 * @version 创建时间：2017/6/15 16:42
 */
public class MaoYanMovies {

    /**
     * control : {"expires":1800}
     * status : 0
     * data : {"hasNext":true,"movies":[{"late":false,"cnms":0,"sn":0,"showInfo":"今天172家影院放映194场","pn":107,"preSale":1,"vd":"","dir":"雷德利·斯科特","star":"迈克尔·法斯宾德,凯瑟琳·沃特斯顿,比利·克鲁德普","cat":"恐怖,惊悚,科幻","wish":140231,"dur":116,"nm":"异形：契约","scm":"天堂实假象，险象险中还","showDate":"","src":"","3d":false,"img":"http://p1.meituan.net/165.220/movie/732d8d3f60ae22fbeaa0f5b9cbb32a84391769.jpg","sc":7.6,"ver":"2D/IMAX 2D/中国巨幕","rt":"本周五上映","imax":true,"snum":254,"time":"","id":78888},{"late":false,"cnms":0,"sn":0,"showInfo":"2017-06-23 下周五上映","pn":266,"preSale":1,"vd":"","dir":"迈克尔·贝","star":"马克·沃尔伯格,伊莎贝拉·莫奈,劳拉·哈德克","cat":"动作,冒险,科幻","wish":408025,"dur":150,"nm":"变形金刚5：最后的骑士","scm":"柱哥要黑化，坏人要称霸","showDate":"","src":"","3d":true,"img":"http://p1.meituan.net/165.220/movie/ca0ac960ba900395084960270b5b0ad9790739.jpg","sc":0,"ver":"2D/3D/IMAX 3D/中国巨幕/全景声","rt":"下周五上映","imax":true,"snum":5081,"time":"","id":248645},{"late":false,"cnms":0,"sn":0,"showInfo":"今天209家影院放映1290场","pn":260,"preSale":0,"vd":"","dir":"派蒂·杰金斯","star":"盖尔·加朵,克里斯·派恩,罗宾·怀特","cat":"动作,冒险,奇幻","wish":122585,"dur":142,"nm":"神奇女侠","scm":"神力女超人，救世又圈粉","showDate":"","src":"","3d":true,"img":"http://p1.meituan.net/165.220/movie/f013c57e9506cd2e7c609397c8da04d9213647.jpg","sc":8.6,"ver":"3D/IMAX 3D/中国巨幕/全景声","rt":"2017-06-02上映","imax":true,"snum":189397,"time":"","id":247731}]}
     */

    private ControlBean control;
    private int status;
    private DataBean data;

    public ControlBean getControl() {
        return control;
    }

    public void setControl(ControlBean control) {
        this.control = control;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class ControlBean {
        /**
         * expires : 1800
         */

        private int expires;

        public int getExpires() {
            return expires;
        }

        public void setExpires(int expires) {
            this.expires = expires;
        }
    }

    public static class DataBean {
        /**
         * hasNext : true
         * movies : [{"late":false,"cnms":0,"sn":0,"showInfo":"今天172家影院放映194场","pn":107,"preSale":1,"vd":"","dir":"雷德利·斯科特","star":"迈克尔·法斯宾德,凯瑟琳·沃特斯顿,比利·克鲁德普","cat":"恐怖,惊悚,科幻","wish":140231,"dur":116,"nm":"异形：契约","scm":"天堂实假象，险象险中还","showDate":"","src":"","3d":false,"img":"http://p1.meituan.net/165.220/movie/732d8d3f60ae22fbeaa0f5b9cbb32a84391769.jpg","sc":7.6,"ver":"2D/IMAX 2D/中国巨幕","rt":"本周五上映","imax":true,"snum":254,"time":"","id":78888},{"late":false,"cnms":0,"sn":0,"showInfo":"2017-06-23 下周五上映","pn":266,"preSale":1,"vd":"","dir":"迈克尔·贝","star":"马克·沃尔伯格,伊莎贝拉·莫奈,劳拉·哈德克","cat":"动作,冒险,科幻","wish":408025,"dur":150,"nm":"变形金刚5：最后的骑士","scm":"柱哥要黑化，坏人要称霸","showDate":"","src":"","3d":true,"img":"http://p1.meituan.net/165.220/movie/ca0ac960ba900395084960270b5b0ad9790739.jpg","sc":0,"ver":"2D/3D/IMAX 3D/中国巨幕/全景声","rt":"下周五上映","imax":true,"snum":5081,"time":"","id":248645},{"late":false,"cnms":0,"sn":0,"showInfo":"今天209家影院放映1290场","pn":260,"preSale":0,"vd":"","dir":"派蒂·杰金斯","star":"盖尔·加朵,克里斯·派恩,罗宾·怀特","cat":"动作,冒险,奇幻","wish":122585,"dur":142,"nm":"神奇女侠","scm":"神力女超人，救世又圈粉","showDate":"","src":"","3d":true,"img":"http://p1.meituan.net/165.220/movie/f013c57e9506cd2e7c609397c8da04d9213647.jpg","sc":8.6,"ver":"3D/IMAX 3D/中国巨幕/全景声","rt":"2017-06-02上映","imax":true,"snum":189397,"time":"","id":247731}]
         */

        private boolean hasNext;
        private List<MoviesBean> movies;

        public boolean isHasNext() {
            return hasNext;
        }

        public void setHasNext(boolean hasNext) {
            this.hasNext = hasNext;
        }

        public List<MoviesBean> getMovies() {
            return movies;
        }

        public void setMovies(List<MoviesBean> movies) {
            this.movies = movies;
        }

        public static class MoviesBean {
            /**
             * late : false
             * cnms : 0
             * sn : 0
             * showInfo : 今天172家影院放映194场
             * pn : 107
             * preSale : 1
             * vd :
             * dir : 雷德利·斯科特
             * star : 迈克尔·法斯宾德,凯瑟琳·沃特斯顿,比利·克鲁德普
             * cat : 恐怖,惊悚,科幻
             * wish : 140231
             * dur : 116
             * nm : 异形：契约
             * scm : 天堂实假象，险象险中还
             * showDate :
             * src :
             * 3d : false
             * img : http://p1.meituan.net/165.220/movie/732d8d3f60ae22fbeaa0f5b9cbb32a84391769.jpg
             * sc : 7.6
             * ver : 2D/IMAX 2D/中国巨幕
             * rt : 本周五上映
             * imax : true
             * snum : 254
             * time :
             * id : 78888
             */

            private boolean late;
            private int cnms;
            private int sn;
            private String showInfo;
            private int pn;
            private int preSale;
            private String vd;
            private String dir;
            private String star;
            private String cat;
            private int wish;
            private int dur;
            private String nm;
            private String scm;
            private String showDate;
            private String src;
            @SerializedName("3d")
            private boolean _$3d;
            private String img;
            private double sc;
            private String ver;
            private String rt;
            private boolean imax;
            private int snum;
            private String time;
            private int id;

            public boolean isLate() {
                return late;
            }

            public void setLate(boolean late) {
                this.late = late;
            }

            public int getCnms() {
                return cnms;
            }

            public void setCnms(int cnms) {
                this.cnms = cnms;
            }

            public int getSn() {
                return sn;
            }

            public void setSn(int sn) {
                this.sn = sn;
            }

            public String getShowInfo() {
                return showInfo;
            }

            public void setShowInfo(String showInfo) {
                this.showInfo = showInfo;
            }

            public int getPn() {
                return pn;
            }

            public void setPn(int pn) {
                this.pn = pn;
            }

            public int getPreSale() {
                return preSale;
            }

            public void setPreSale(int preSale) {
                this.preSale = preSale;
            }

            public String getVd() {
                return vd;
            }

            public void setVd(String vd) {
                this.vd = vd;
            }

            public String getDir() {
                return dir;
            }

            public void setDir(String dir) {
                this.dir = dir;
            }

            public String getStar() {
                return star;
            }

            public void setStar(String star) {
                this.star = star;
            }

            public String getCat() {
                return cat;
            }

            public void setCat(String cat) {
                this.cat = cat;
            }

            public int getWish() {
                return wish;
            }

            public void setWish(int wish) {
                this.wish = wish;
            }

            public int getDur() {
                return dur;
            }

            public void setDur(int dur) {
                this.dur = dur;
            }

            public String getNm() {
                return nm;
            }

            public void setNm(String nm) {
                this.nm = nm;
            }

            public String getScm() {
                return scm;
            }

            public void setScm(String scm) {
                this.scm = scm;
            }

            public String getShowDate() {
                return showDate;
            }

            public void setShowDate(String showDate) {
                this.showDate = showDate;
            }

            public String getSrc() {
                return src;
            }

            public void setSrc(String src) {
                this.src = src;
            }

            public boolean is_$3d() {
                return _$3d;
            }

            public void set_$3d(boolean _$3d) {
                this._$3d = _$3d;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public double getSc() {
                return sc;
            }

            public void setSc(double sc) {
                this.sc = sc;
            }

            public String getVer() {
                return ver;
            }

            public void setVer(String ver) {
                this.ver = ver;
            }

            public String getRt() {
                return rt;
            }

            public void setRt(String rt) {
                this.rt = rt;
            }

            public boolean isImax() {
                return imax;
            }

            public void setImax(boolean imax) {
                this.imax = imax;
            }

            public int getSnum() {
                return snum;
            }

            public void setSnum(int snum) {
                this.snum = snum;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }
        }
    }
}
