package com.tw.todolist.service.impl;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public Object getLoggedInUser() {
        SecurityContext context = SecurityContextHolder.getContext();
        return context.getAuthentication().getDetails();
    }
}
