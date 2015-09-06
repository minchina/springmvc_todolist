package com.tw.todolist.domain.form;

public class ToDoForm {

    private String name;


    public ToDoForm() {
    }

    public ToDoForm(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
