package edu.njfu.sas.servelt;

import javax.jws.WebParam;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/ServletConfigDemoServlet"
//        ,
//        initParams = {
//                @WebInitParam(name="pageSize",value="10"),
//                @WebInitParam(name = "encoding",value = "utf-8")
//        }
        )
public class ServletConfigDemoServlet extends HttpServlet {
    private String pageSize;
    private String encoding;
    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext application = config.getServletContext();
        pageSize = application.getInitParameter("pageSize");
         encoding = application.getInitParameter("encoding");

        super.init(config);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.getWriter().write(pageSize+encoding);
    }
}
