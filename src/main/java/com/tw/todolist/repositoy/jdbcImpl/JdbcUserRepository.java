package com.tw.todolist.repositoy.jdbcImpl;

import com.tw.todolist.domain.User;

public interface JdbcUserRepository {

    User findUser(Long id);
}
