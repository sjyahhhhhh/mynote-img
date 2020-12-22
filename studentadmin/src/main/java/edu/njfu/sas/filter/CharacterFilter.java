package edu.njfu.sas.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

//@WebFilter(urlPatterns = "/*")
public class CharacterFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        HttpServletResponse response =(HttpServletResponse)servletResponse;

        //2.拦截所有的request和response
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //3.做一个包装类，增强getparameter的功能，使中文不乱码
        CharacterRequest characterRequest = new CharacterRequest(request);
        //4.放行过滤器
        filterChain.doFilter(characterRequest,response);
    }

    @Override
    public void destroy() {

    }
}


class  CharacterRequest extends HttpServletRequestWrapper{
    //request包装对象
    private  HttpServletRequest request;
    public CharacterRequest(HttpServletRequest request) {
        super(request);
        this.request=request;
    }

    //重写getparameter方法
    @Override
    public String getParameter(String name) {
        String value=super.getParameter(name);
        if (value!=null){
            return null;
        }
        String method =super.getMethod();
        if (method.equalsIgnoreCase("get")){
            //忽略大小写
            //如果是get方式请求，需要进行编码转换，因为是放在url中的
            try {
                value = new String(value.getBytes("iso-8859-1"), "utf-8");
            } catch (UnsupportedEncodingException e) {
                throw  new RuntimeException(e);
            }
            //把西文编码转换为中文编码
        }
        return value;
    }

    /**
     * 1.在一个javal类中可以有多个类但是只能有一个public
     * 2.public类名与文件名一致
     * 3在java中有很多诸如xxxwrapper的类，是包装类，遵循装饰者模式，首先需要一个被包装或者装饰对象
     * 4.可以增强部分的方法，比如IO流
     * BufferedReader（InputStreamReader（inputStream））
     * 本例中，CharacterRequest装饰request，增强getparamter方法
     *
     */
}