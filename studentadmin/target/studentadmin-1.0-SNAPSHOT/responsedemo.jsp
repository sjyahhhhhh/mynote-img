<%@ page import="edu.njfu.dao.impl.StudentDaoImpl" %>
<%@ page import="edu.njfu.dao.Student" %>
<%@ page import="edu.njfu.dao.StudentDao" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 87367
  Date: 2020/10/19
  Time: 14:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%request.setCharacterEncoding("UTF-8");%>
<form action="responsedemo.jsp" method="get">
    输入信息<input type="text" name="name">
    <input type="submit" value="submit"  name="submit">
</form>
<%
    String submit=request.getParameter("submit");
    if (submit!=null&&submit.equals("submit"))
    {
        out.println(request.getParameter("name"));
            StudentDao student=new StudentDaoImpl();
            List<Student> stud=student.getAllStudent();
            request.setAttribute("student",stud);
//        request.setAttribute("hello","helloworld");
        request.getRequestDispatcher("show.jsp").forward(request,response);
    }


%>
</body>
</html>
