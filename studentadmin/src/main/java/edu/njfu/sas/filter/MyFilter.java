package edu.njfu.sas.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("myfilter init is called");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //检查用户是否已经登录，如果没有
        //如何判断是否已经登陆
        //如果存在则认为用户已经登陆，
        //用户已经登陆，不做任何处理
        //用户没有登陆，跳转到登陆页面
        HttpSession session = ((HttpServletRequest) servletRequest).getSession();
        Object user = session.getAttribute("user");
        if (user==null){
            PrintWriter writer = ((HttpServletResponse) servletResponse).getWriter();
            writer.write("<script>alert('please login'); location.href='index.html';</script>");
        }else{
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
