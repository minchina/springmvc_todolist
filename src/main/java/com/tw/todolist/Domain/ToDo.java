package com.tw.todolist.Domain;

public class ToDo {
    private int id;
    private String name;
    private int done;
    private int userId;

    public ToDo(int id, String name, int userId , int done) {
        this.id = id;
        this.name = name;
        this.done = done;
        this.userId = userId;
    }

    public int getDone() {
        return done;
    }

    public void setDone(int done) {
        this.done = done;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
