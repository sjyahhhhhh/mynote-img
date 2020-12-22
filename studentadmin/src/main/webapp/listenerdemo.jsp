<%--
  Created by IntelliJ IDEA.
  User: murray
  Date: 2020/12/10
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>监听器页面测试</title>
</head>
<body>
<%
    application.setAttribute("name","zhangsan");
    application.setAttribute("name","lisi");
    application.removeAttribute("name");
    ///


    session.setAttribute("name","zhangsan");
    session.setAttribute("name","lisi");
    session.removeAttribute("name");
%>
</body>
</html>
