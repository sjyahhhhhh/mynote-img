package edu.njfu.sas.servelt;

import edu.njfu.sas.dao.impl.UserDaoImpl;
import edu.njfu.sas.model.User2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AutoUserLoginServlet")
public class AutoUserLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1获取用户名密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User2 user = new User2(username, password);
        try {
            boolean result = new UserDaoImpl().checkLogin(user);
            //2验证
            //3 验证成功把用户名密码保存到session中
            if (result){
                request.getSession().setAttribute("user",user);
            }
            //4.创建cookie，设置存活期，保存路径，发送到client
            String autoLogin = request.getParameter("autoLogin");
            if (autoLogin!=null){
                Cookie cookie = new Cookie("autoLogin",username+":"+password);
                //设置cookie的最大存活期
                cookie.setMaxAge(Integer.getInteger(autoLogin));
                cookie.setPath(request.getContextPath());
                response.addCookie(cookie);
            }else{
                //给出提示，跳转到登陆页面
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
