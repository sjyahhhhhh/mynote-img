<%--
  Created by IntelliJ IDEA.
  User: 87367
  Date: 2020/10/19
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    out.print("hello<br>");
    System.out.println("adkdhjakhd");
    out.flush();
%>
<script>
    document.write("jsp<br>");
</script>
<%
    response.getWriter().write("ahhhh");
%>
</body>
</html>
