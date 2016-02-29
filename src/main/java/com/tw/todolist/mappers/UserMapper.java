package com.tw.todolist.mappers;

import com.tw.todolist.domain.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    String SELECT_USER = "select * from user where id = #{id}";

    @Select(SELECT_USER)
    User selectUser(Long id);
}
