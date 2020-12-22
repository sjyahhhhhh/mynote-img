package edu.njfu.dao;
import edu.njfu.model.*;
import edu.njfu.util.DBHelper;
import edu.njfu.util.Md5Util;

import java.util.ArrayList;
import java.util.List;

public class UserDao {

    public boolean checkLogin(User user){
        //登录检验
        String sql ="select*from tb_user where username=?and password=?";
        List<Object>params=new ArrayList<Object>();
        params.add(user.getUsername());
    //明文转密文
        String encryptPassword= Md5Util.stringToMD5(user.getPassword());
        params.add(encryptPassword);
//
        DBHelper dbHelper = new DBHelper();
        List<Object> query=dbHelper.query(sql,params);
//        System.out.println(query);

        return query.size()>0;

    }
    public boolean saveUser(User u){
        //注册用户
        String sql="insert into tb_user(username,password)values(?,?)";
        //对占位符赋值
        List<Object> params=new ArrayList<>();
        params.add(u.getUsername());
        params.add(Md5Util.stringToMD5(u.getPassword()));

        DBHelper db = new DBHelper();
        int result=db.update(sql,params);


        return result>0;
    }


}
