package edu.njfu.sas.servelt;

import com.google.gson.Gson;
import edu.njfu.sas.dao.UserDao;
import edu.njfu.sas.dao.impl.UserDaoImpl;
import edu.njfu.sas.model.User2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/UserLoginServlet2")
public class UserLoginServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html,charset=utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter writer = response.getWriter();
        //获取用户输入
        String username=request.getParameter("userName");
        String password=request.getParameter("password");
        Map map = new HashMap();
        if (username!=null&&password!=null){
            //创建对象
            User2 user=new User2(username,password);
            UserDao userDao = new UserDaoImpl();
            //验证密码
            boolean result = false;
            try {
                result = userDao.checkLogin(user);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            if (result){
                //信息保存到session
                request.getSession().setAttribute("user",user);
                //跳转到liststudent页面
                request.getRequestDispatcher("liststudeents.jsp").forward(request,response);
            }else{
                //用户名密码错误
                 writer.write("<script>alert('用户名密码错误'); location.href='index.html';</script>");
            }
        }else{
            writer.write("<script>alert('用户名密码错误'); location.href='index.html';</script>");
        }
        writer.write(new Gson().toJson(map));

        //输出

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
