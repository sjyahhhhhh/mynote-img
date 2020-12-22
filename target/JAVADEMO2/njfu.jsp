<%--
  Created by IntelliJ IDEA.
  User: 87367
  Date: 2020/10/19
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%
    String userName=(String)session.getAttribute("user");
    if (userName==null){
        out.println("<script>alert('非法访问');location.href='login.html'</script>");
    }else{

    }
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="logo.jsp"%>
<%@ include file="adv.jsp"%>
<%@ include file="main.jsp"%>
<%@ include file="footer.jsp"%>
