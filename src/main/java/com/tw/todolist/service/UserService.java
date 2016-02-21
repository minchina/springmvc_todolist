package com.tw.todolist.service;


import com.tw.todolist.domain.User;

import java.util.List;


public interface UserService {

    List<User> findAllUsers();

    User findByName(String name);

    User save(User user);

    void deleteById(Long id);

    User findOne(Long id);

    User selectUser(Long id);
}
