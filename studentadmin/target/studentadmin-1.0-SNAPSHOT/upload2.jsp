<%--
  Created by IntelliJ IDEA.
  User: murray
  Date: 2020/12/21
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传照片</title>
</head>
<body>
<form>
    请上传照片<input type="file" id="uploadfile" name="uploadfile">
</form>
<img src="" id="img01" style="width: 300px;height: 300px">
<img src="http://localhost:8080/studentadmin/ImageCodeServlet">
<script>
    var ima01=document.getElementById("img01");
    ima01.style.display="none"
    document.getElementById("uploadfile").addEventListener("change",function (){
        var uploadfile=document.getElementById("uploadfile").files;
        var reader =new FileReader();
        reader.readAsDataURL(uploadfile[0]);
        reader.onload=function (){
            ima01.src=reader.result
            ima01.style.display="block"
        }
    })
</script>
</body>
</html>
