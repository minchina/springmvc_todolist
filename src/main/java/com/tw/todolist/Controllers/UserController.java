package com.tw.todolist.Controllers;


import com.tw.todolist.Models.User;
import com.tw.todolist.Services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.util.List;


@Controller
@RequestMapping("/users")

public class UserController {
    
    @RequestMapping(method = RequestMethod.GET)
    public String showAllUsers(ModelMap model) throws Exception {
        List<User> allUsers = new UserService().getAll();
        model.addAttribute("allUsers", allUsers);
        return "userlist";
    }
}
