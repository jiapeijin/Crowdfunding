<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 2017/11/17
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="shortcut icon" type="image/x-icon"
          href="${ctxStatic}/dist/images/favicon.ico" media="screen">
    <!-- Bootstrap -->
    <link href="${ctxStatic}/dist/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${ctxStatic}/dist/font/iconfont.css">
    <link rel="stylesheet" href="${ctxStatic}/dist/css/reset.css">
    <link rel="stylesheet" href="${ctxStatic}/dist/css/style.css?v=0.0114">
    <link rel="stylesheet" href="${ctxStatic}/dist/bootstrap/css/fileinput.css">
    <!--[if lt IE 9]>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script src="${ctxStatic}/dist/js/jquery-1.11.0.js"></script>
    <script src="${ctxStatic}/dist/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript"
            src="${ctxStatic}/dist/js/placeholder/jquery.placeholder.js"></script>
<%--
    <script type="text/javascript" src="${ctxStatic}/static/dist/jsrender/jsrender.js"></script>
--%>
    <script type="text/javascript"
            src="${ctxStatic}/dist/js/jquery-validation/dist/jquery.validate.js"></script>
    <script type="text/javascript"
            src="${ctxStatic}/dist/js/jquery-validation/dist/additional-methods.js"></script>
    <script src="${ctxStatic}/dist/js/js.js?v=0.0112"></script>
    <script src="${ctxStatic}/dist/bootstrap/js/fileinput.js"></script>
    <script src="${ctxStatic}/dist/bootstrap/js/fileinput_locales_zh.js"></script>
    <script src="${ctxStatic}/dist/bootstrap/js/bootstrap.js"></script>
</head>
<body>
<header>
    <div class="comWidth logo">
        <div class="fl logoTitle">
            <span>彩虹投众筹平台</span>
        </div>
        <ul class="comNav fl">
            <li><a href="">首页</a></li>
            <li><a href="">奖励众筹</a></li>
            <li><a href="">公益众筹</a></li>
            <li class="active"><a href="">系统管理</a></li>
            <li><a href="">角色权限</a></li>
        </ul>
        <div class="navbar-right userWrap">
            <div class="userBox">
                <i class="iconfont icon-user"></i>
                <i class="iconfont icon-down"></i>
            </div>
            <ul class="myList">
                <li>
                    <a href="${ctx}/editPassword">
                        <i class="iconfont icon-password1"></i>
                        修改密码
                    </a>
                </li>
                <li>
                    <i class="iconfont icon-exit"></i>
                    退出
                </li>
            </ul>
        </div>
    </div>
</header>
<footer style="bottom: auto; height: 150px">
    &nbsp;关于我们 &nbsp; &nbsp;|&nbsp; &nbsp; 联系我们&nbsp; &nbsp; |&nbsp; &nbsp;服务协议&nbsp; &nbsp; |&nbsp; &nbsp; 发起项目规范&nbsp; &nbsp; |&nbsp; &nbsp; 公司资质&nbsp; &nbsp; |&nbsp; &nbsp; 帮助中心
    <br>
    ©彩虹投众筹平台  &nbsp; &nbsp; &nbsp; &nbsp; All Rights Reserved
    &nbsp; &nbsp; &nbsp; &nbsp; 地址：上海市江湾镇666号  &nbsp; &nbsp; &nbsp; &nbsp; 电话：021-69690874
</footer>
</body>
</html>

