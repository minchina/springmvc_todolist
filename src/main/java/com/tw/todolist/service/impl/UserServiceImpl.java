package com.tw.todolist.service.impl;

import com.tw.todolist.domain.User;
import com.tw.todolist.mappers.UserMapper;
import com.tw.todolist.repositoy.UserRepository;
import com.tw.todolist.repositoy.jdbcImpl.JdbcUserRepository;
import com.tw.todolist.service.UserService;
import com.tw.todolist.utils.MyBatisSessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserMapper {

    @Autowired
    UserRepository userRepository;


    @Autowired
    JdbcUserRepository jdbcUserRepository;

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public User save(User user) {
        User existedUser = findByName(user.getName());
        if (existedUser != null) {
            throw new RuntimeException("username is already use!");
        }
        return userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findOne(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public User selectUser(Long id) {
        SqlSession sqlSession = MyBatisSessionFactory.getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            return userMapper.selectUser(id);
        } finally {
            sqlSession.close();
        }
    }
}
