package com.tw.todolist.domain;


import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.tw.todolist.domain.security.Role;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
@NamedQueries({
        @NamedQuery(name = "findUserByName", query = "from User us where us.name=:userName")
})
public class User {


    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name = "";

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "userId")
    private List<ToDo> toDoList = new ArrayList<ToDo>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = {
            @JoinColumn(name = "USER_ID", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "ROLE_ID",
                    nullable = false, updatable = false)})
    private Set<Role> roles = new HashSet<Role>();

    private String password;

    public User() {

    }

    public User(String name) {
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

    public void addToDo(ToDo toDo) {
        toDoList.add(toDo);
    }

    public String[] getRolesList() {

        List<Role> roleArrayList = new ArrayList<Role>(this.roles);
        Iterable<String> transformed = Iterables.transform(roleArrayList, new Function<Role, String>() {
            @Override
            public String apply(Role role) {
                return role.getName();
            }
        });
        return Iterables.toArray(transformed, String.class);


    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
