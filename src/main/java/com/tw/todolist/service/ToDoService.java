package com.tw.todolist.service;

import com.tw.todolist.Domain.ToDo;

import java.util.List;

public interface ToDoService {

    List<ToDo> findAllToDos();

    List<ToDo> findByUserId(Long id);
}
