package com.tw.todolist.Controllers;


import com.tw.todolist.Domain.User;
import com.tw.todolist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/users")

public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String showAllUsers(ModelMap model) throws Exception {

        List<User> allUsers = userService.findAllUsers();
        model.addAttribute("allUsers", allUsers);
        return "userlist";
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public User addUser(@RequestParam("user_name") User newUser) throws Exception {

        return userService.save(newUser);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    private String deleteUser(@RequestParam("user_id") Long id) throws Exception {

        userService.deleteById(id);
        return "redirect:/users";
    }
//
//    @RequestMapping(value = "/{userName}/todos", method = RequestMethod.GET)
//    private ModelAndView showUserToDos(@PathVariable("userName") String userName, ModelAndView modelAndView) throws Exception {
//
//        User user = userService.findUserByName(userName);
//        List<ToDo> userToDoList = new ToDoService().getToDoListByUserId(user.getId());
//        modelAndView.addObject("userId",user.getId());
//        modelAndView.addObject("userToDoList",userToDoList);
//        modelAndView.setViewName("usertodolist");
//
//        return modelAndView;
//
//    }

}
