package com.tw.todolist.controller;


import com.tw.todolist.domain.ToDo;
import com.tw.todolist.domain.User;
import com.tw.todolist.service.EventLogger;
import com.tw.todolist.service.ToDoService;
import com.tw.todolist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

import static com.google.common.collect.Maps.newLinkedHashMap;


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
        User savedUser = userService.save(newUser);
        Map<String, Object> message = newLinkedHashMap();
        message.put("user_name", savedUser.getName());
        message.put("user_id", savedUser.getId());
        EventLogger.log("add_user", message);
        return savedUser;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    private Long deleteUser(@RequestParam("user_id") Long id) throws Exception {
        userService.deleteById(id);
        Map<String, Object> message = newLinkedHashMap();
        message.put("user_id", id);
        EventLogger.log("delete_user", message);
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
