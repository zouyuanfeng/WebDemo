<%--
  Created by IntelliJ IDEA.
  User: zouyuanfeng
  Date: 2017/6/13
  Time: 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="./include/taglibs.jsp" %>
<html>
<head>
    <title>微信</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <link rel="stylesheet" href="//res.wx.qq.com/open/libs/weui/1.1.2/weui.min.css"/>
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="${res}/js/vconsole.min.js"></script>
    <script src="http://res.wx.qq.com/open/js/jweixin-1.2.0.js"></script>
</head>
<body>
<div style="margin: 10px">
    <a href="javascript:void (0)" class="weui-btn weui-btn_primary" onclick="showDialog()">弹窗</a>
    <a href="javascript:void (0)" class="weui-btn weui-btn_primary" onclick="chooseImage()">选择相片</a>

    <a href="javascript:;" class="weui-btn weui-btn_primary">页面主操作 Normal</a>
    <a href="javascript:;" class="weui-btn weui-btn_disabled weui-btn_primary">页面主操作 Disabled</a>
    <a href="javascript:;" class="weui-btn weui-btn_default">页面次要操作 Normal</a>
    <a href="javascript:;" class="weui-btn weui-btn_disabled weui-btn_default">页面次要操作 Disabled</a>
    <a href="javascript:;" class="weui-btn weui-btn_warn">警告类操作 Normal</a>
    <a href="javascript:;" class="weui-btn weui-btn_disabled weui-btn_warn">警告类操作 Disabled</a>

    <div class="button-sp-area">
        <a href="javascript:;" class="weui-btn weui-btn_plain-default">按钮</a>
        <a href="javascript:;" class="weui-btn weui-btn_plain-default weui-btn_plain-disabled">按钮</a>
        <a href="javascript:;" class="weui-btn weui-btn_plain-primary">按钮</a>
        <a href="javascript:;" class="weui-btn weui-btn_plain-primary weui-btn_plain-disabled">按钮</a>
        <a href="javascript:;" class="weui-btn weui-btn_mini weui-btn_primary">按钮</a>
        <a href="javascript:;" class="weui-btn weui-btn_mini weui-btn_default">按钮</a>
        <a href="javascript:;" class="weui-btn weui-btn_mini weui-btn_warn">按钮</a>
    </div>

    <img src="" id="image" width="100px">
</div>
<div style="display: none;" id="dialog">
    <div class="weui-mask"></div>
    <div class="weui-dialog">
        <div class="weui-dialog__hd"><strong class="weui-dialog__title">弹窗标题</strong></div>
        <div class="weui-dialog__bd">弹窗内容，告知当前页面信息等</div>
        <div class="weui-dialog__ft">
            <a href="javascript:;" class="weui-dialog__btn weui-dialog__btn_primary" onclick="hideDialog()">确定</a>
        </div>
    </div>
</div>
</body>
<script>
    function showDialog() {
        $("#dialog").show()
    }
    function hideDialog() {
        $("#dialog").hide();
    }
    wx.config({
        debug: true, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
        appId: 'wx1b89b4b5ec8acae5', // 必填，公众号的唯一标识
        timestamp: '${timestamp}', // 必填，生成签名的时间戳
        nonceStr: '${nonceStr}', // 必填，生成签名的随机串
        signature: '${signature}',// 必填，签名，见附录1
        jsApiList: ['chooseImage'] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
    });

    //    wx.ready(function () {
    //        // config信息验证后会执行ready方法，所有接口调用都必须在config接口获得结果之后，config是一个客户端的异步操作，所以如果需要在页面加载时就调用相关接口，则须把相关接口放在ready函数中调用来确保正确执行。对于用户触发时才调用的接口，则可以直接调用，不需要放在ready函数中。
    //        console.log("微信js加载成功")
    //    });
    //
    //    wx.error(function (res) {
    //        // config信息验证失败会执行error函数，如签名过期导致验证失败，具体错误信息可以打开config的debug模式查看，也可以在返回的res参数中查看，对于SPA可以在这里更新签名。
    //        console.log("微信js加载失败" + res)
    //    });

    function chooseImage() {
        wx.chooseImage({
            count: 1, // 默认9
            sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图，默认二者都有
            sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
            success: function (res) {
                var localIds = res.localIds; // 返回选定照片的本地ID列表，localId可以作为img标签的src属性显示图片
                console.info(localIds);
                $("#image").attr("src", localIds[0]);
            }
        });
    }
</script>
</html>
