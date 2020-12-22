<%--
  Created by IntelliJ IDEA.
  User: 87367
  Date: 2020/9/21
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String username=request.getParameter("username");
    String userpassword=request.getParameter("userpassword");
    out.print("你输入的内容"+username+userpassword);

%>
