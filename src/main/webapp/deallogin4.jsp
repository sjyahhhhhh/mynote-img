<%@ page import="java.sql.*" %>
<%@ page import="edu.njfu.dao.UserDao" %>
<%@ page import="edu.njfu.model.User" %><%--
  Created by IntelliJ IDEA.
  User: 87367
  Date: 2020/9/21
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");//只适用于post
    String username=request.getParameter("username");
    String userpassword=request.getParameter("userpassword");

    //创建UserDao对象
    UserDao userDao = new UserDao();
    //遍历结果集
    if (userDao.checkLogin(new User(username,userpassword))){
        session.setAttribute("user",username);
        response.sendRedirect("njfu.jsp");
    }
    else{
            out.println("<script> alert('非法访问'); location.href='login.html'</script>");
//        response.sendRedirect("error.jsp");
    }

%>
