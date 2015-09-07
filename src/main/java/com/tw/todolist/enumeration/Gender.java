package com.tw.todolist.enumeration;

import java.util.Arrays;
import java.util.List;

public enum Gender {

    MALE("male"),
    FEMALE("female");

    private String description;


    Gender(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Gender> getGenders() {
        return Arrays.asList(MALE,FEMALE);
    }
}
