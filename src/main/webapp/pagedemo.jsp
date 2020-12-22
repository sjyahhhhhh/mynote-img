<%--
  Created by IntelliJ IDEA.
  User: 87367
  Date: 2020/10/20
  Time: 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>page demo</title>
</head>
<body>
<%=page.hashCode()
//什么的hihashcode
//hash表为了快速查找对象
//学生类
//stuNo，stuName,department
//重写equals,hashccode，只要stuNo与stuName相同，对象相同
//通过page演示，jsp页面转换为java类，编译执行，返回结果
%><br>
<%=page.getClass().toString()

%>
</body>
</html>
