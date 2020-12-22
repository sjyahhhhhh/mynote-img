<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %><%--
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
    String url="jdbc:mysql://localhost:3306/library?serverTimezone=GMT%2B8";
    String dbName="root";
    String dbPassword="123456";
//    System.out.print(url);
    Connection conn=null;
    conn=DriverManager.getConnection(url,dbName,dbPassword);


    //statement
    String sql="select*from student";
    Statement statement=conn.createStatement();
    ResultSet resultset=statement.executeQuery(sql);

    while (resultset.next())
        out.print(resultset.getString(1)+resultset.getString(2)+resultset.getString(3));

%>
