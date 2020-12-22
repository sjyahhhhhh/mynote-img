<%@ page import="java.sql.*" %><%--
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
    Class.forName("com.mysql.cj.jdbc.Driver");
    String url="jdbc:mysql://localhost:3306/software18?serverTimezone=GMT%2B8";
    String dbName="root";
    String dbPassword="123456";
//    System.out.print(url);
    Connection conn=null;
    conn=DriverManager.getConnection(url,dbName,dbPassword);

    String sql="select *from tb_user where username=? ";
    PreparedStatement pst=conn.prepareStatement(sql);
    pst.setString(1,username);
    ResultSet resultset=pst.executeQuery();
    if (resultset.next()){
        out.print("用户名正确");
    }
    else{
        out.print("用户名错误");
    }

%>
