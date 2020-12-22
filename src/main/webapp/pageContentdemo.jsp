<%--
  Created by IntelliJ IDEA.
  User: 87367
  Date: 2020/10/20
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    JspWriter out1=pageContext.getOut();
    out1.print("hello world");
    //
    ServletRequest request1= pageContext.getRequest();
    //
    ServletResponse response1= pageContext.getResponse();
    response1.getWriter().write("hello");
    //
    Exception exception= pageContext.getException();
    //
    Object page1 = pageContext.getPage();
    //
    ServletConfig servletConfig = pageContext.getServletConfig();
    //
    HttpSession session1 = pageContext.getSession();
    //
    ServletContext servletContext = pageContext.getServletContext();
    //page<request<session<application
    pageContext.setAttribute("user","pageUser");
    request.setAttribute("user","requestUser");
    session.setAttribute("user","sessionUser");
    application.setAttribute("user","applicationUser");
    out.print(pageContext.findAttribute("user"));
%>
<%--    <%=exception.getMessage()%>--%>


</body>
</html>
