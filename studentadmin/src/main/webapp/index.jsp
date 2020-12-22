<%--
  Created by IntelliJ IDEA.
  User: 87367
  Date: 2020/11/24
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="RequestDispacherServlet">展示学生列表</a>
    <%
        /**
         * 把所有的jsp文件放在jsp文件夹中
         * 如果需要访问特定页面
         *
         */
        request.getRequestDispatcher("index.html").forward(request,response);
    %>
</body>
</html>
