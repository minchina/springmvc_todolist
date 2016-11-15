package org.tw.todo.integrationTests;


import com.tw.todolist.domain.User;
import com.tw.todolist.service.UserService;
import com.tw.todolist.service.impl.UserHibernateImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class SaveUserIntegrationTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserHibernateImpl userHibernateDao;

    @Test
    public void saveUser(){
        userService.save(new User("ning"));
        User selectedUser = userService.findByName("ning");
        User user = userService.selectUser(selectedUser.getId());
        assertThat(user.getName(), is("ning"));
    }

    @Test
    public void testSearchUser() {
        userService.save(new User("ning"));
        List<User> users = userHibernateDao.findUserByName("ning");
        assertThat(users.size(), is(1));
        assertThat(users.get(0).getName(), is("ning"));
    }


}
