package edu.njfu.sas.filter;


import edu.njfu.model.User;
import edu.njfu.sas.dao.impl.UserDaoImpl;
import edu.njfu.sas.model.User2;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;

public class AutoLoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
       //转换 父类转换为子类
        HttpServletRequest request= (HttpServletRequest)servletRequest;
       //2.获取cookie，是保存在client的键值对
        Cookie[] cookies = request.getCookies();
        //3.在cookie中查找key:autologin
        String autoLogin=null;
        for (Cookie cookie:cookies){
            if (cookie.getName().equalsIgnoreCase("autoLogin")){
                autoLogin= cookie.getValue();
            }
        }
        //4.判断autologin是否为null，null表示没找到
        if (autoLogin!=null){
            //自动登陆
            //把真的用户名与密码做出字符串：zhangsan:
            String[] users = autoLogin.split(":");
            User2 user = new User2(users[0], users[1]);
            try {
                boolean result = new UserDaoImpl().checkLogin(user);
                if (result){
                    //登陆成功
                    request.getSession().setAttribute("user",user);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        //放行
        filterChain.doFilter(request,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
