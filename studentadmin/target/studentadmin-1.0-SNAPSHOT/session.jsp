<%--
  Created by IntelliJ IDEA.
  User: 87367
  Date: 2020/10/19
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>session demo</title>
</head>
<body>
<%
//用户与服务器地一次交互有时间限制3分钟
//    sesscion.setAttribute();
    //get
    session.setAttribute("hello2","hello world2");
    response.sendRedirect("show.jsp");
    //实现防盗链

%>
</body>
</html>
