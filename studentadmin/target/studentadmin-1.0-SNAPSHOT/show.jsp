<%--
  Created by IntelliJ IDEA.
  User: 87367
  Date: 2020/10/19
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%=request.getAttribute("student")
%>
<%=session.getAttribute("hello2")%>
</body>
</html>
