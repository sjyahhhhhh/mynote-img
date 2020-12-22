package edu.njfu.sas.servelt;

import com.google.gson.Gson;
import edu.njfu.sas.dao.UserDao;
import edu.njfu.sas.dao.impl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/AnotherServlet")
public class AnotherServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        Map map = new HashMap();
        UserDao userDao = new UserDaoImpl();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username!=null){
            map.put("result",username);
            map.put("msg","success");


        }else{
            map.put("result",username);
            map.put("msg","failure");
        }
        writer.write(new Gson().toJson(map));

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request, response);
    }
}
