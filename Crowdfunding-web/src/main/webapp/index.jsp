<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <script type="text/javascript" src="${ctxStatic}/login/js/jquery-1.9.0.min.js"></script>
    <script type="text/javascript" src="${ctxStatic}/login/js/login.js"></script>
    <script type="text/javascript" src="${ctxStatic}/dist/js/jquery-validation/dist/jquery.validate.js"></script>
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
                    <form id="login_form" class="loginForm"><input type="hidden" name="did" value="0"/>
                        <input type="hidden" name="to" value="log"/>
                        <div class="uinArea" id="uinArea">
                            <label class="input-tips" for="loginName">帐号：</label>
                            <div class="inputOuter" id="uArea">
                                <input type="text" id="loginName" name="loginName" class="inputstyle" placeholder="请输入登录名"/>
                            </div>
                        </div>
                        <div class="pwdArea" id="pwdArea">
                            <label class="input-tips" for="password">密码：</label>
                            <div class="inputOuter" id="pArea">
                                <input type="password" id="password" name="password" class="inputstyle" placeholder="请输入密码"/>
                            </div>
                        </div>
                        <div style="padding-left:50px;margin-top:20px;"><input type="button" value="登 录" style="width:150px;"  id="login"class="button_blue"/></div>
                    </form>
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
                    <label for="realName"  class="input-tips2">用户名：</label>
                    <div class="inputOuter2">
                        <input type="text" id="realName" name="user" maxlength="16" class="inputstyle2"  placeholder="请输入用户名"/>
                    </div>

                </li>
                <li>
                    <label for="loginNames"  class="input-tips2">登录名：</label>
                    <div class="inputOuter2">
                        <input type="text" id="loginNames" name="loginName" maxlength="16" class="inputstyle2" placeholder="请输入登录名"/>
                    </div>

                </li>
                <li>
                    <label for="pwd" class="input-tips2">密码：</label>
                    <div class="inputOuter2">
                        <input type="password" id="pwd"  name="pwd" maxlength="16" class="inputstyle2" placeholder="请输入密码"/>
                    </div>
                </li>
                <li>
                    <label for="phone" class="input-tips2">联系电话：</label>
                    <div class="inputOuter2">
                        <input type="text" id="phone" name="phone" maxlength="16" class="inputstyle2" placeholder="请输入联系电话"/>
                    </div>
                </li>
                <li>
                    <label for="email" class="input-tips2">邮箱：</label>
                    <div class="inputOuter2">
                        <input type="text" id="email" name="eamil" maxlength="16" class="inputstyle2" placeholder="请输入联系电话"/>
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
        jQuery.validator.addMethod("loginName", function(value, element) {
            var ln=/^[a-zA-Z0-9_]{2,18}$/;
            return this.optional(element) || (ln.test(value));
        }, "请输入正确的用户名");
        $("#login_form").validate({
            //规则
            rules: {
                loginName: {
                    required:true,
                    minlength: 1
                },
                password:{
                    required:true,
                    minlength:1
                }
            },
            //提示语
            messages: {
                loginName :{
                    required:"登录名不能为空"
                },
                password: {
                   required:"密码不能为空"
                }
            }
        });
    });
    $().ready(function() {
        $('#login').click(function() {
            var loginName = $("#loginName").val();
            var password = $("#password").val();
            if(!$("#login_form").valid()) {
                return;
            }
            $.ajax({
                url: '${ctx}/login/loginInto',
                type: 'post',
                dataType: 'json',
                data:{"loginName":loginName,"password":password},
                success: function(data) {
                    debugger;
                    if (data.success == 0) {
                        window.location.href="${ctx}/system/userList";
                    }else {
                        alert("用户名或者密码错误,请重新输入");
                    }
                }
            });
        });
        $('#reg').click(function(){
            var realName=$('#realName').val();
            var loginName=$('#loginNames').val();
            var password=$('#password').val();
            var phoneOne=$('#phone').val();
            var email=$('#email').val();
            $.ajax({
                url:'${ctx}/login/registUser',
                type:'post',
                dataType:'json',
                data:{"realName":realName,"loginName":loginName,"password":password,"phoneOne":phoneOne,"email":email},
                success: function (data) {
                    if(data.success){
                        //刷新页面进入登录
                     window.location.reload();
                    }else{
                        alert("添加失败");
                    }
                }
            })
        })
    });
</script>
</html>
