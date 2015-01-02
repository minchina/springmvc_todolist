package com.tw.todolist.Controllers;


import com.alibaba.fastjson.JSON;
import com.tw.todolist.Models.ToDo;
import com.tw.todolist.Models.User;
import com.tw.todolist.Services.ToDoService;
import com.tw.todolist.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String showAllUsers(ModelMap model, @ModelAttribute("user") String user) throws Exception {
        List<User> allUsers = userService.getAll();
        model.addAttribute("allUsers", allUsers);
        return "userlist";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    private void addUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
        PrintWriter printWriter = response.getWriter();
        String userName = request.getParameter("user_name");

        User user = userService.add(new User(userName));
        String jsonUser = JSON.toJSONString(user);
        printWriter.write(jsonUser);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
        PrintWriter printWriter = response.getWriter();
        String userName = request.getParameter("user_name");
        Integer userId = Integer.valueOf(request.getParameter("user_id"));

        User user = new User(userId, userName);
        userService.delete(user);
        printWriter.write("success");
    }

    @RequestMapping(value = "/{userName}/todos", method = RequestMethod.GET)
    private String showUserToDos(@PathVariable("userName") String userName, ModelMap modelMap) throws Exception {
        User user = userService.findUserByName(userName);
        List<ToDo> userToDoList = new ToDoService().getToDoListByUserId(user.getId());
        modelMap.addAttribute("userId", user.getId());
        modelMap.addAttribute("userToDoList", userToDoList);
        return "usertodolist";
    }

}
