<%--
  Created by IntelliJ IDEA.
  User: murray
  Date: 2020/12/14
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el demo3</title>
</head>
<body>
name
${requestScope.param.username}
${param.password}
<%
    Cookie cookie = new Cookie("username", "zhangsan");
    cookie.setMaxAge(60*60*24);
    response.addCookie(cookie);
%>
</body>
</html>
