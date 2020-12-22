package edu.njfu.test;

import edu.njfu.dao.UserDao;
import edu.njfu.model.User;

public class Test {
    public  static  void main(String arg[]){
        new UserDao().saveUser(new User("小红","123456"));
    }

}
