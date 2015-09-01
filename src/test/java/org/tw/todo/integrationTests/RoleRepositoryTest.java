package org.tw.todo.integrationTests;


import com.tw.todolist.domain.User;
import com.tw.todolist.domain.security.Role;
import com.tw.todolist.repositoy.RoleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class RoleRepositoryTest {

    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void shouldGetUsersByRoleAdmin() {
        Role role = roleRepository.findByName("ROLE_ADMIN");
        Set<User> users = role.getUsers();
        assertThat(users.size(), is(2));
    }

    @Test
    public void shouldGetUsersByRoleUser() {
        Role role = roleRepository.findByName("ROLE_USER");
        Set<User> users = role.getUsers();
        assertThat(users.size(), is(1));
    }

    @Test
    public void shouldCannotGetUsersByRoleOther() {
        Role role = roleRepository.findByName("ROLE_TEST");
        assertNull(role);
    }
}
