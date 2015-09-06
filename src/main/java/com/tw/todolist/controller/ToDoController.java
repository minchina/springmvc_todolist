package com.tw.todolist.controller;


import com.tw.todolist.domain.ToDo;
import com.tw.todolist.domain.User;
import com.tw.todolist.domain.form.ToDoForm;
import com.tw.todolist.service.ToDoService;
import com.tw.todolist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class ToDoController {

    @Autowired
    private UserService userService;

    @Autowired
    private ToDoService toDoService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showAllToDos(){

        ModelAndView modelAndView = new ModelAndView("index");
        List<ToDo> allToDos = toDoService.findAllToDos();
        modelAndView.addObject("allToDos", allToDos);
        return modelAndView;
    }

    @RequestMapping(value = "/todo/add", method = RequestMethod.POST)
    @ResponseBody
    public ToDo addToDo(@RequestParam("name") ToDo toDo, @RequestParam("user_id") Long userId){
        User user = userService.findOne(userId);
        user.addToDo(toDo);
        userService.save(user);
        return toDoService.findByName(toDo.getName());

    }

    @RequestMapping(value = "/todo/delete", method = RequestMethod.POST)
    @ResponseBody
    public Long deleteToDo(@RequestParam("id") Long id)  {

        toDoService.deleteById(id);
        return id;

    }

    @RequestMapping(value = "/todo/update", method = RequestMethod.POST)
    @ResponseBody
    public ToDo updateToDoStatus(@RequestBody final ToDo toDo){

        toDoService.updateToDo(toDo);
        return toDo;

    }

    @RequestMapping(value = "/v1/todo/add", method = RequestMethod.GET)
    public ModelAndView showAddPage() {
        List<ToDo> allToDos = toDoService.findAllToDos();
        ModelAndView todo = new ModelAndView("newTodo");
        todo.addObject("todos", allToDos);
        todo.addObject("newtodo", new ToDoForm("todo1"));
        return todo;
    }
    @RequestMapping(value = "/v1/todo/add", method = RequestMethod.POST)
    @ResponseBody
    public List<ToDo> addTodo(@RequestBody ToDoForm toDoForm) {
        ToDo toDo = new ToDo();
        mapToDoFormToDomain(toDo, toDoForm);
        toDoService.save(toDo);
        return toDoService.findAllToDos();

    }

    private void mapToDoFormToDomain(ToDo toDo, ToDoForm toDoForm) {
        toDo.setComplete(false);
        toDo.setName(toDoForm.getName());
    }
}
