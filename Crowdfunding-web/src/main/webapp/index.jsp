<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <script type="text/javascript" src="${ctxStatic}/login/js/jquery-1.9.0.min.js"></script>
   <script type="text/javascript" src="${ctxStatic}/login/js/login.js"></script>
    <link href="${ctxStatic}/login/css/login2.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h1>彩虹投众筹平台管理<sup>V2017</sup></h1>

<div class="login" style="margin-top:50px;">

    <div class="header">
        <div class="switch" id="switch"><a class="switch_btn_focus" id="switch_qlogin" href="javascript:void(0);" tabindex="7">快速登录</a>
            <a class="switch_btn" id="switch_login" href="javascript:void(0);" tabindex="8">快速注册</a><div class="switch_bottom" id="switch_bottom" style="position: absolute; width: 64px; left: 0px;"></div>
        </div>
    </div>
    <div class="web_qr_login" id="web_qr_login" style="display: block; height: 235px;">
        <!--登录-->
        <div class="web_login" id="web_login">
            <div class="login-box">
                <div class="login_form">
                    <%--<form id="login_form" class="loginForm">--%><input type="hidden" name="did" value="0"/>
                        <input type="hidden" name="to" value="log"/>
                        <div class="uinArea" id="uinArea">
                            <label class="input-tips" for="loginName">帐号：</label>
                            <div class="inputOuter" id="uArea">
                                <input type="text" id="loginName" name="loginName" class="inputstyle"/>
                            </div>
                        </div>
                        <div class="pwdArea" id="pwdArea">
                            <label class="input-tips" for="password">密码：</label>
                            <div class="inputOuter" id="pArea">
                                <input type="password" id="password" name="password" class="inputstyle"/>
                            </div>
                        </div>
                        <div style="padding-left:50px;margin-top:20px;"><input type="button" value="登 录" style="width:150px;"  id="login"class="button_blue"/></div>
<%--
                    </form>
--%>
                </div>
            </div>
        </div>
        <!--登录end-->
    </div>
    <!--注册-->
    <div class="qlogin" id="qlogin" style="display: none; ">
        <div class="web_login"><form name="form2" id="regUser" accept-charset="utf-8"  action="" method="post">
            <input type="hidden" name="to" value="reg"/>
            <input type="hidden" name="did" value="0"/>
            <ul class="reg_form" id="reg-ul">
                <div id="userCue" class="cue">快速注册请注意格式</div>
                <li>
                    <label for="user"  class="input-tips2">用户名：</label>
                    <div class="inputOuter2">
                        <input type="text" id="user" name="user" maxlength="16" class="inputstyle2"/>
                    </div>

                </li>
                <li>
                    <label for="passwd" class="input-tips2">密码：</label>
                    <div class="inputOuter2">
                        <input type="password" id="passwd"  name="passwd" maxlength="16" class="inputstyle2"/>
                    </div>
                </li>
                <li>
                    <label for="passwd2" class="input-tips2">确认密码：</label>
                    <div class="inputOuter2">
                        <input type="password" id="passwd2" name="" maxlength="16" class="inputstyle2" />
                    </div>
                </li>
                <li>
                    <label for="qq" class="input-tips2">QQ：</label>
                    <div class="inputOuter2">

                        <input type="text" id="qq" name="qq" maxlength="10" class="inputstyle2"/>
                    </div>
                </li>
                <li>
                    <div class="inputArea">
                        <input type="button" id="reg"  style="margin-top:10px;margin-left:85px;" class="button_blue" value="同意协议并注册"/> <a href="#" class="zcxy" target="_blank">注册协议</a>
                    </div>
                </li><div class="cl"></div>
            </ul></form>
        </div>
    </div>
    <!--注册end-->
</div>
</body>
<script>
    $().ready(function() {
        var loginName = $("#loginName").val();
        var password = $("#password").val();
        $('#login').click(function() {
            $.ajax({
                url: '${ctx}/login/loginInto',
                type: 'post',
                dataType: 'json',
                data:{"loginName":loginName,"password":password},
                success: function(data) {
                    window.location.href="${ctx}/system/userList";
                    /*if (data.success) {
                        window.location.href="${ctx}/system/userList";
                    }else{
                        alert("用户名或者密码错误！");
                    }*/
                }
            });
        });
    });


   /* $(document).ready(function() {
        $('#reg').click(function() {
            if ($('#user').val() == "") {
                $('#user').focus().css({
                    border: "1px solid red",
                    boxShadow: "0 0 2px red"
                });
                $('#userCue').html("<font color='red'><b>×用户名不能为空</b></font>");
                return false;
            }
            if ($('#user').val().length < 4 || $('#user').val().length > 16) {
                $('#user').focus().css({
                    border: "1px solid red",
                    boxShadow: "0 0 2px red"
                });
                $('#userCue').html("<font color='red'><b>×用户名位4-16字符</b></font>");
                return false;
            }
            $.ajax({
                type: reMethod,
                url: "${ctx}/login/",
                data: "uid=" + $("#user").val() + '&temp=' + new Date(),
                dataType: 'html',
                success: function(result) {

                    if (result.length > 2) {
                        $('#user').focus().css({
                            border: "1px solid red",
                            boxShadow: "0 0 2px red"
                        });$("#userCue").html(result);
                        return false;
                    } else {
                        $('#user').css({
                            border: "1px solid #D7D7D7",
                            boxShadow: "none"
                        });
                    }

                }
            });


            if ($('#passwd').val().length < pwdmin) {
                $('#passwd').focus();
                $('#userCue').html("<font color='red'><b>×密码不能小于" + pwdmin + "位</b></font>");
                return false;
            }
            if ($('#passwd2').val() != $('#passwd').val()) {
                $('#passwd2').focus();
                $('#userCue').html("<font color='red'><b>×两次密码不一致！</b></font>");
                return false;
            }

            var sqq = /^[1-9]{1}[0-9]{4,9}$/;
            if (!sqq.test($('#qq').val()) || $('#qq').val().length < 5 || $('#qq').val().length > 12) {
                $('#qq').focus().css({
                    border: "1px solid red",
                    boxShadow: "0 0 2px red"
                });
                $('#userCue').html("<font color='red'><b>×QQ号码格式不正确</b></font>");return false;
            } else {
                $('#qq').css({
                    border: "1px solid #D7D7D7",
                    boxShadow: "none"
                });

            }
            $('#regUser').submit();
        });
    });*/
</script>
</html>
