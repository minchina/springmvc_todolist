package org.tw.todo.integrationTests;


import com.tw.todolist.domain.security.Role;
import com.tw.todolist.domain.User;
import com.tw.todolist.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class SaveUserIntegrationTest {

    @Autowired
    private UserService userService;


    @Test
    public void shouldSaveUser() {
        User user = new User();
        user.setName("demo");
        user.setPassword("demo");
        user.setRoles(Arrays.asList(new Role("ROLE_ADMIN")));
        userService.save(user);
    }
}
