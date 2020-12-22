<%@ page import="javafx.print.Printer" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: 87367
  Date: 2020/10/19
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //1防止乱码
    response.setCharacterEncoding("UTF-8");
    //2输出
    PrintWriter writer=response.getWriter();
    writer.write("hello");
    writer.write("中国");
    //3跳转
//    response.sendRedirect("show.jsp");
    //4刷新
    response.setHeader("refresh","1");


%>
<%=new Date()%>
</body>
</html>
