package edu.njfu.sas.servelt;

import com.google.gson.Gson;
import edu.njfu.sas.model.User2;
import edu.njfu.sas.dao.impl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/ListUserServlet")
public class ListUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html,charset=utf-8");
        response.setCharacterEncoding("utf-8");
        UserDaoImpl userDao = new UserDaoImpl();
        List<User2> allUser= null;
        try {
            allUser = userDao.getAllUser();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Gson gson = new Gson();
        String users=gson.toJson(allUser);
        response.getWriter().write(users);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
