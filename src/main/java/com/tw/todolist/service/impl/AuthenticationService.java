package com.tw.todolist.service.impl;

import com.tw.todolist.domain.User;
import com.tw.todolist.domain.security.CurrentUser;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public User getLoggedInUser() {
        SecurityContext context = SecurityContextHolder.getContext();
        return ((CurrentUser)context.getAuthentication().getPrincipal()).getUser();
    }
}
