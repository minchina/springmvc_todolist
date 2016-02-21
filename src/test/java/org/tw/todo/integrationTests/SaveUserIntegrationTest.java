package org.tw.todo.integrationTests;


import com.tw.todolist.domain.User;
import com.tw.todolist.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class SaveUserIntegrationTest {

    @Autowired
    private UserService userService;


    @Test
    public void saveUser(){
        userService.save(new User("ning"));
        User selectedUser = userService.findByName("ning");
        User user = userService.selectUser(selectedUser.getId());
        assertThat(user.getName(), is("ning"));
    }


}
