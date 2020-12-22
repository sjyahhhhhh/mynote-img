<%--
  Created by IntelliJ IDEA.
  User: murray
  Date: 2020/12/14
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>upload</title>
</head>
<body>
<form action="FileUploadServlet" method="post" enctype="multipart/form-data">
    <input type="text" name="username"><br>
    <input type="file" id="upload" name="onloadfile" multiple><br>
    <input type="submit" value="submit">
</form>
</body>
</html>
