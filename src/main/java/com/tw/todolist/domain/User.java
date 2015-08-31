package com.tw.todolist.domain;


import com.google.common.collect.Lists;
import com.tw.todolist.domain.security.Role;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User {


    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name="";

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "userId")
    private List<ToDo> toDoList = new ArrayList<ToDo>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "userid")
    private List<Role> roles;

    private String password;

    public User(){

    }

    public User(String name){
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public List<ToDo> getToDoList() {
        return toDoList;
    }

    public void setToDoList(List<ToDo> toDoList) {
        this.toDoList = toDoList;
    }

    public void addToDo(ToDo toDo){
        toDoList.add(toDo);
    }

    public List<Role> getRoles() {
        return roles;
    }

    public String[] getRolesList() {
        String array[] = new String[roles.size()];
        for(int j =0;j<roles.size();j++){
            array[j] = roles.get(j).getName();
        }
        return array;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
