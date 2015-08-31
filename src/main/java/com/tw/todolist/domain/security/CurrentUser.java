package com.tw.todolist.domain.security;

import com.tw.todolist.domain.User;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.List;

public class CurrentUser extends org.springframework.security.core.userdetails.User {

    private User user;

    public CurrentUser(User user) {
        super(user.getName(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getRolesList()));
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public Long getId() {
        return user.getId();
    }

    public List<Role> getRoles() {
        return user.getRoles();
    }

}
