package com.tw.todolist.service.impl;

import com.tw.todolist.domain.ToDo;
import com.tw.todolist.repositoy.ToDoRepository;
import com.tw.todolist.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoServiceImpl implements ToDoService {

    @Autowired
    ToDoRepository toDoRepository;

    @Override
    public List<ToDo> findAllToDos() {
        return toDoRepository.findAll();
    }

    @Override
    public ToDo findByName(String name) {
        return toDoRepository.findByName(name);
    }


    @Override
    public ToDo save(ToDo toDo) {
        return toDoRepository.save(toDo);
    }

    @Override
    public void deleteById(Long id) {
        toDoRepository.deleteById(id);
    }

    @Override
    public void updateToDo(ToDo toDo) {

        toDoRepository.updateToDo(toDo.getId(),toDo.getName(),toDo.isComplete());
    }
}
