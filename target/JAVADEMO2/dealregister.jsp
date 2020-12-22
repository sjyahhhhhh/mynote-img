<%@ page import="edu.njfu.model.User" %>
<%@ page import="edu.njfu.dao.UserDao" %><%--
  Created by IntelliJ IDEA.
  User: 87367
  Date: 2020/9/28
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //获取用户名和密码
    request.setCharacterEncoding("UTF-8");//只适用于post
    String userName=request.getParameter("username");
    String password=request.getParameter("password");
    User user=new User(userName,password);
    System.out.println(userName);
    System.out.println(password);
    //保存
    UserDao userDao=new UserDao();
    boolean result=userDao.saveUser(user);
    //根据保存结果返回
    if (result){
        //跳转成功界面
        response.sendRedirect("login.html");
    }else{
        //跳转error页面
        response.sendRedirect("error.jsp");
    }

%>
