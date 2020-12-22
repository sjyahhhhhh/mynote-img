package edu.njfu.sas.servelt;

import edu.njfu.sas.dao.impl.UserDaoImpl;
import edu.njfu.sas.model.User2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户提交的数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User2 user = new User2(username,password);
        UserDaoImpl userDao = new UserDaoImpl();
        boolean result = false;
        result = userDao.checkUser(user);
        if (result){
            request.getRequestDispatcher("/liststudents.jsp").forward(request,response);
        }else{
            PrintWriter out=response.getWriter();
            out.write("<script>alert('登陆失败');location.href='error.jsp'</script>");

        }
        //创建user
        //验证使用userdao来验证
        //页面跳转
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
