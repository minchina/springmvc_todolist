package com.tw.todolist.controller;


import com.tw.todolist.domain.ToDo;
import com.tw.todolist.domain.User;
import com.tw.todolist.service.ToDoService;
import com.tw.todolist.service.UserService;
import com.tw.todolist.service.impl.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/users")

public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    ToDoService toDoService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showAllUsers(){

        List<User> allUsers = userService.findAllUsers();

        ModelAndView modelAndView = new ModelAndView("userList");
        modelAndView.addObject("allUsers", allUsers);
        return modelAndView;

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public User addUser(@RequestParam("user_name") User newUser){
        return userService.save(newUser);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    private Long deleteUser(@RequestParam("user_id") Long id) throws Exception {

        userService.deleteById(id);
        return id;
    }

    @RequestMapping(value = "/{userName}/todos", method = RequestMethod.GET)
    private ModelAndView showUserToDos(@PathVariable("userName") String name){
        User user = userService.findByName(name);
        ModelAndView modelAndView = new ModelAndView("userToDoList");
        List<ToDo> userToDoLists = user.getToDoList();
        modelAndView.addObject("userToDoList", userToDoLists);
        modelAndView.addObject("userId", user.getId());
        return modelAndView;

    }
}
