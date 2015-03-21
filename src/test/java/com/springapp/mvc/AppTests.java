package com.springapp.mvc;

import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;
import com.tw.todolist.domain.User;
import com.tw.todolist.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AppTests {

    @Autowired
    private UserService userService;

    @Test
    public void should_save_user_success(){

    }
    
    public List<String> getUserNames(){
        return FluentIterable.from(userService.findAllUsers()).transform(new Function<User, String>() {
            @Override
            public String apply(User input) {
                return input.getName();
            }
        }).toList();
    }
}
