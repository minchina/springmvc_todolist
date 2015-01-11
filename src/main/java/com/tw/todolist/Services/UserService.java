package com.tw.todolist.Services;

import com.tw.todolist.Dao.UserDao;
import com.tw.todolist.Domain.User;
import java.util.List;

public class UserService {


    UserDao userDao;

    public UserService() throws Exception {
        userDao = new UserDao();
    }

    public User add(User user) throws Exception {
        return userDao.add(user);
    }

    public List<User> getAll() throws Exception {
        return userDao.getAll();
    }

    public User findUserByName(String name) throws Exception{
        return userDao.findUserByName(name);
    }

    public User findUserById(Integer id) throws Exception {
        return userDao.findUserById(id);
    }

    public void delete(Integer id) throws Exception {
        userDao.delete(id);
    }
}
