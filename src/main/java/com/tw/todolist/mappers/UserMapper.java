package com.tw.todolist.mappers;

import com.tw.todolist.domain.User;

public interface UserMapper {

    User selectUser(Long id);
}
