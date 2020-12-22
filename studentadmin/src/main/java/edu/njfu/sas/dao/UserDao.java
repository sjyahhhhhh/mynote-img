package edu.njfu.sas.dao;

import edu.njfu.model.User;
import edu.njfu.sas.model.User2;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    public boolean checkUser(User2 user) throws SQLException;
    public boolean checkLogin(User2 user) throws SQLException;

    public List<User2> getAllUser() throws SQLException;

    boolean saveUser(User user);
}
