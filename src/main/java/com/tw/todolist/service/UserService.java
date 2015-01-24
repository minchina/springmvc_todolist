package com.tw.todolist.service;


import com.tw.todolist.Domain.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    List<User> findAllUsers();
}
