package com.tw.todolist.Controllers;


import com.alibaba.fastjson.JSON;
import com.tw.todolist.Models.User;
import com.tw.todolist.Services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;


@Controller
@RequestMapping("/users")

public class UserController {

    @RequestMapping(method = RequestMethod.GET)
    public String showAllUsers(ModelMap model, @ModelAttribute("user") String user) throws Exception {
        List<User> allUsers = new UserService().getAll();
        model.addAttribute("allUsers", allUsers);
        return "userlist";
    }

    @RequestMapping(method = RequestMethod.POST)
    private void addUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
        PrintWriter printWriter = response.getWriter();
        String userName = request.getParameter("user_name");
        
        User user = new UserService().add(new User(userName));
        String jsonUser = JSON.toJSONString(user);
        printWriter.write(jsonUser);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    private void deleteUser(@PathVariable Integer userId ) throws Exception {
//        String userName = request.getParameter("user_name");
//        System.out.println(userName);
//        Integer userId = Integer.valueOf(request.getParameter("user_id"));
        System.out.println(userId);
//        User user = new User(userId,userName);
//        System.out.println(user);
//        new UserService().delete(user);
    }
}
