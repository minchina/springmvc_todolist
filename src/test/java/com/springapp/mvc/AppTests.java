package com.springapp.mvc;

import com.tw.todolist.Domain.User;
import com.tw.todolist.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AppTests {

    @Autowired
    private UserService userService;

    @Test
    public void should_save_user_success(){
        User user = new User("mnc");
        assertThat(user.getName(), is("mnc"));
    }
}
