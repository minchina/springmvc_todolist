package com.tw.todolist.Controllers;


import com.tw.todolist.Models.ToDo;
import com.tw.todolist.Services.ToDoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/")
public class ToDoController {
    
    
    @RequestMapping(method = RequestMethod.GET)
    public String showAllToDos(ModelMap modelMap) throws Exception {
        List<ToDo> allToDos = new ToDoService().getAll();
        modelMap.addAttribute("allToDos", allToDos);
        return "index";
    }
}
