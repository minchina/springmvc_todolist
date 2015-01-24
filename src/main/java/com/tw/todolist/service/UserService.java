package com.tw.todolist.service;


import com.tw.todolist.Domain.User;

import java.util.List;


public interface UserService {

    List<User> findAllUsers();

    User save(User user);

    void deleteById(Long id);
}
