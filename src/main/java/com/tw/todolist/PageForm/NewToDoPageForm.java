package com.tw.todolist.pageForm;

import com.sun.istack.internal.NotNull;

public class NewToDoPageForm {

    @NotNull
    private String name;

    @NotNull
    private String age;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
