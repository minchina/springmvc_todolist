package com.tw.todolist.service.impl;

import com.tw.todolist.domain.User;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.util.List;


public class UserHibernateImpl extends HibernateDaoSupport {


    public List<User> findUserByName(String name) {
        return (List<User>) getHibernateTemplate().findByNamedQueryAndNamedParam("findUserByName", "userName", name);

    }
}
