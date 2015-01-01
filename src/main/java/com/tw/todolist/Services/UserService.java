package com.tw.todolist.Services;

import com.tw.todolist.Dao.UserDao;
import com.tw.todolist.Models.User;

import java.sql.SQLException;
import java.util.List;

public class UserService {


    UserDao userDao;

    public UserService() throws SQLException {
        userDao = new UserDao();
    }

    public User add(User user) throws SQLException, ClassNotFoundException {
        return userDao.add(user);
    }

    public List<User> getAll() throws Exception {
        return userDao.getAll();
    }

    public User findUserByName(String name) throws SQLException {
        return userDao.findUserByName(name);
    }

    public User findUserById(Integer id) throws SQLException {
        return userDao.findUserById(id);
    }

    public void delete(User user) throws SQLException {
        userDao.delete(user);
    }
}
