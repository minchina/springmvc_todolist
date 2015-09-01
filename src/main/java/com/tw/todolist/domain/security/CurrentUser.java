package com.tw.todolist.domain.security;

import com.tw.todolist.domain.User;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.List;
import java.util.Set;

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

    public Set<Role> getRoles() {
        return user.getRoles();
    }

}
