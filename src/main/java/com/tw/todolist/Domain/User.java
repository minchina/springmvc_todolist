package com.tw.todolist.Domain;


public class User {
    private String name="";
    private Integer id = 0;

    public User(int id, String name) {
        this.id=id;
        this.name = name;

    }

    public User(String name) {
        this.name = name;
    }

    public User(int id){
        this.id = id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
