package com.tw.todolist.service;

import com.tw.todolist.Domain.ToDo;

import java.util.List;

public interface ToDoService {

    List<ToDo> findAllToDos();

    ToDo findByName(String name);

    ToDo save(ToDo toDo);

    void deleteById(Long id);

    void updateToDo(ToDo toDo);

}
