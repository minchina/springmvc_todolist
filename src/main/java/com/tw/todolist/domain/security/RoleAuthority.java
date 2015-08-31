package com.tw.todolist.domain.security;

import org.springframework.security.core.GrantedAuthority;

public class RoleAuthority implements GrantedAuthority {

    
    private String name;


    public RoleAuthority() {
    }
    public RoleAuthority(String name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
