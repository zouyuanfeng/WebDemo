<%--
  Created by IntelliJ IDEA.
  User: zouyuanfeng
  Date: 2017/6/15
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="./include/taglibs.jsp" %>

<html>
<head>
    <title>电影</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <link rel="stylesheet" href="${res}/css/weui.min.css"/>
    <script src="${res}/js/jquery-2.1.4.min.js"></script>
    <script src="${res}/js/vconsole.min.js"></script>
</head>
<style>
    .box {
        display: flex;
        flex-direction: row;
        margin: 20px;
    }

    .box > img {
        max-width: 137px;
        max-height: 191px;
    }
</style>
<body>
<div id="movies">


</div>

<div class="weui-loadmore" id="loading" style="display: none">
    <i class="weui-loading"></i>
    <span class="weui-loadmore__tips">正在加载</span>
</div>

<div class="weui-loadmore weui-loadmore_line" id="no-data" style="display: none">
    <span class="weui-loadmore__tips">暂无数据</span>
</div>

<div class="weui-loadmore weui-loadmore_line weui-loadmore_dot" id="no-load-more" style="display: none">
    <span class="weui-loadmore__tips"></span>
</div>

<div id="loadingToast" style="display:none;">
    <div class="weui-mask_transparent"></div>
    <div class="weui-toast">
        <i class="weui-loading weui-icon_toast"></i>
        <p class="weui-toast__content">数据加载中</p>
    </div>
</div>

<script type="text/template">
    <div class="box">
        <img src="{img}">
        <p>{nm}</p>
    </div>
</script>
<script>
    var pageNo = 0;
    var isLoad = false;
    loadData();
    function loadData() {
        if (isLoad)return;
        isLoad = true;
        $.get("getMovies", {pageSize: 20, pageNo: pageNo++}, function (data) {
            console.info(data);
            isLoad = false;
            if (data.status == 0) {
                var html = $('script[type="text/template"]').html();
                var arr = [];

                $(data.data.movies).each(function (index, movie) {
                    arr.push(formatTemplate(movie, html));
//                    $("#movies").append("<p style='height: 80px'>" + movie.nm + "</p>");
                });
                $('#movies').append(arr.join(''));

                if ($("#movies").children.length == 0)
                    $("#no-load").show();
                else if (data.data.hasNext)
                    $("#loading").show();
                else {
                    $("#loading").hide();
                    $("#no-load-more").show();
                    isLoad = true;
                }

            } else {
                $("#no-data").show();
            }
        });
    }


    $(document).ready(function () {
        $(window).scroll(function () {

//            if ($(document).scrollTop()<=0){
//                alert("滚动条已经到达顶部为0");
//            }

            if ($(document).scrollTop() + 10 >= $(document).height() - $(window).height()) {
                loadData()
            }
        });
    });

    function formatTemplate(dta, tmpl) {
        var format = {
            name: function (x) {
                return x
            }
        };
        return tmpl.replace(/{(\w+)}/g, function (m1, m2) {
            if (!m2)
                return "";
            return (format && format[m2]) ? format[m2](dta[m2]) : dta[m2];
        });
    }
</script>


</body>
</html>
