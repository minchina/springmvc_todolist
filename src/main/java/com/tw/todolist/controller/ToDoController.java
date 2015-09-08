package com.tw.todolist.controller;


import com.tw.todolist.domain.ToDo;
import com.tw.todolist.domain.User;
import com.tw.todolist.domain.form.ToDoForm;
import com.tw.todolist.enumeration.Gender;
import com.tw.todolist.service.ToDoService;
import com.tw.todolist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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
        ToDoForm toDoForm = new ToDoForm("");
        toDoForm.setGender(Gender.MALE);
        todo.addObject("todos", allToDos);
        todo.addObject("newtodo", toDoForm);
        return todo;
    }
    @RequestMapping(value = "/v1/todo/added", method = RequestMethod.GET)
    public String show(HttpServletRequest httpServletRequest, Model model) {
        List<ToDo> allToDos = toDoService.findAllToDos();
        ModelAndView todo = new ModelAndView("newTodo");
        ToDoForm toDoForm = new ToDoForm("");
        toDoForm.setGender(Gender.MALE);
        model.addAttribute("todos", allToDos);
        model.addAttribute("newtodo", toDoForm);

        return "redirect:add";
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
