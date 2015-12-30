package com.tw.todolist.repositoy.jdbcImpl;


import com.tw.todolist.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class JdbcUserRepositoryImpl implements JdbcUserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String USER = "SELECT name from user where id = ?";

    @Override
    public User findUser(Long id) {
        return selectOne(new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                return new User(resultSet.getString(1));
            }
        }, USER, id);
    }

    private <T> T selectOne(final RowMapper<T> rowMapper, final String query, final Object... params) {

        T result = jdbcTemplate.queryForObject(query, params, rowMapper);
        return result;
    }
}
