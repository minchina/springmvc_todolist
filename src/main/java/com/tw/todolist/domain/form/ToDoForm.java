package com.tw.todolist.domain.form;

import com.tw.todolist.enumeration.Gender;

public class ToDoForm {

    private String name;

    private Gender gender;


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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
