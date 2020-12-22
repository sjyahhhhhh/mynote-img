<%@ page import="edu.njfu.model.User" %>
<%@ page import="edu.njfu.sas.model.User2" %><%--
  Created by IntelliJ IDEA.
  User: murray
  Date: 2020/12/14
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el demo</title>
</head>
<body>
<%
    User2 user=new User2("zhangsan","123456");
    request.setAttribute("username","zhangsan");
    request.setAttribute("password","123456");
    request.setAttribute("user",user);

    request.getRequestDispatcher("/eldemo2.jsp").forward(request,response);
%>
</body>
</html>
