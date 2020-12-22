package edu.njfu.sas.servelt;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletDemo2 extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("GenericServlet is doing");
        PrintWriter writer = servletResponse.getWriter();
        writer.write("hello");
    }
}
