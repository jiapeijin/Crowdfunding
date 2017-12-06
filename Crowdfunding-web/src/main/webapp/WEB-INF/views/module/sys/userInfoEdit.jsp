<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/include/taglib.jsp" %>
<%@include file="/WEB-INF/views/include/include.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<main class="comWidth system">
    <section class="right menuList fl">
        <h4><a href=""> 系统管理</a> > <a href="" class="active">添加用户</a></h4>
        <form id="addIndu">
            <input type="hidden" id="userId" name="userId">
            <table class="addInfo">
                <tr>
                    <td><b>*</b>用户名</td>
                    <td><input type="text" id="realName" name="realName" value="${list.realName}"></td>
                    <td><b>*</b>性别</td>
                    <td><input type="text" id="sex" name="sex" value="${list.userSex}"></td>
                </tr>
                <tr>
                    <td><b>*</b>身份证号码</td>
                    <td><input type="text" id="userCard" name="userCard" value="${list.userCard}"></td>
                    <td><b>*</b>教育水平</td>
                    <td><input type="text" id="userEducation" name="userEducation" value="${list.userEducation}"></td>
                </tr>
                <tr>
                    <td width="200px"><b>*</b>用户地址</td>
                    <td width="350px"><input type="text" id="userAddress" name="userAddress" value="${list.userAddress}"></td>
                    <td><b>*</b>自我介绍</td>
                    <td><input type="text" id="userIntroduction" name="userIntroduction" value="${list.userIntroduction}"></input></td>
                </tr>
                <tr>
                    <td><b>*</b>联系电话1</td>
                    <td><input type="text" id="phoneOne" name="phoneOne" value="${list.phoneOne}"></td>
                    <td width="200px"><b>*</b>联系电话2</td>
                    <td width="350px"><input type="text" id="phoneTwo" name="phoneTwo" value="${list.phoneTwo}"></td>
                </tr>
                <tr>
                    <td><b>*</b>email</td>
                    <td><input type="text" id="email" name="email" value="${list.email}"></td>
                    <td><b>*</b>微博</td>
                    <td><input type="text" id="webo" name="webo" value="${list.webo}"></td>
                </tr>
                <tr>
                    <td><b>*</b>身份证正面</td>
                    <td><input type="text" id="cardFace" name="cardFace" value="${list.cardFace}"></td>
                    <td><b>*</b>身份证反面</td>
                    <td><input type="text" id="cardCon" name="cardCon" value="${list.cardCon}"></td>
                </tr>
                <tr>
                    <td><b>*</b>微信</td>
                    <td><input type="text" id="wechart" name="wechart" value="${list.wechart}"></td>
                </tr>
                <tr>
                    <td colspan="4" style="text-align:center;height:80px;">
                        <button id="saveBtn" type="button" onclick="saveUser()">保 &nbsp; 存</button>
                    </td>
                </tr>
            </table>
        </form>
    </section>
</main>
</body>
<script>
    function saveUser(){
        $.ajax({
            //提交数据的类型 POST GET
            type: 'post',
            //提交的网址
            url: '${ctx}/system/saveCompanyInfo/',
            //返回数据的格式
            dataType: "json",
            //提交的数据
            data:$('#addIndu').serialize(),
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            //成功返回之后调用的函数
            success: function (data) {
                $.tip.unloading();
                if (data.success) {
                    $.tip.submit("保存成功", function () {
                        window.location.href = "${ctx}/system/companyInfo/";
                    });
                } else {
                    $.tip.submit("保存失败", function () {
                        window.location.href = "${ctx}/system/companyInfo/companyInfo/addIndustry";
                    });
                }

            }

        });
    }
</script>
</html>
