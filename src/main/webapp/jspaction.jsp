<%--
  Created by IntelliJ IDEA.
  User: 87367
  Date: 2020/10/20
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //jsp:include
    //jsp:forward
%>
<jsp:include page="logo.jsp"/>
<jsp:include page="adv.jsp"/>
<jsp:include page="main.jsp"/>
<jsp:include page="footer.jsp"/>
<%
    //jsp:include与page include
    //功能相同
    //区别：include静态,包含文件与被包含文件
    // jsp：include动态包含，程序执行到包含文件时才动态生成%>
<%
    //jsp:forward不可跳转外部网页
    //只能使用相对路径
%>
<jsp:forward page="njfu.jsp"/>
</body>
</html>
