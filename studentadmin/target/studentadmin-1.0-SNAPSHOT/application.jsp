<%--
  Created by IntelliJ IDEA.
  User: 87367
  Date: 2020/10/19
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>访问次数统计</title>
</head>
<body>
<%
    Object count=application.getAttribute("count");
    if (count==null){
        count=1;
    }
    else
    {
        count=(Integer)count+1;
    }
    application.setAttribute("count",count);
%>
<h1><%=count%></h1>
</body>
</html>
