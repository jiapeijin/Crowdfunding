<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <h4><a href=""> 系统管理</a> > <a href="" class="active">用户列表</a></h4>
        <div style="padding-left: 849px; padding-bottom: 10px;">
            <button onclick="window.location.href='${ctx}/system/userEditShow'"><i class="iconfont icon-c_add"></i> &nbsp;添加用户</button>
            <button><a href="${ctx}/system/userEditShow?loginName='lucy'"><i class="iconfont icon-c_add"></i>修改用户</a></button>
        </div>
        <div id="loanMangeTable">
            <table class="comInfo comTable" style="margin-bottom:10px;">
                <tbody>
                <tr>
                    <th width="550px" style="font-color:#a1a8a4;">id</th>
                    <th width="400px">登录名</th>
                    <th width="400px">用户名</th>
                    <th width="400px">性别</th>
                    <th width="400px" >教育经历</th>
                    <th width="400px">电话</th>
                    <th width="400px">email</th>
                    <th width="400px">微博</th>
                    <th width="400px">博客</th>
                </tr>
                <c:forEach items="${page.list}" var="list">
                    <tr>
                        <td>${list.id}</td>
                        <td>${list.loginName}</td>
                        <td>${list.realName}</td>
                        <td>${list.userSex}</td>
                        <td>${list.userEducation}</td>
                        <td>${list.phoneOne}</td>
                        <td>${list.email}</td>
                        <td>${list.webo}</td>
                        <td>${list.boke}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="page fr">
            <span>当前为第 ${page.pageNum} 页,</span>
            <span>总页数 ${page.pages} 页</span>
            <button id="prev"value="${page.prePage}">上一页</button>
            <button id="next" value="${page.nextPage}">下一页</button>
        </div>
    </section>
</main>
</body>
<script>
</script>
</html>
