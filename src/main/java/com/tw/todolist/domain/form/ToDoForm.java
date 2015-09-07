package com.tw.todolist.domain.form;

import com.tw.todolist.enumeration.Gender;

import java.util.List;

public class ToDoForm {

    private String name;

    private List<Gender> genders;


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

    public List<Gender> getGenders() {
        return genders;
    }

    public void setGenders(List<Gender> genders) {
        this.genders = genders;
    }
}
