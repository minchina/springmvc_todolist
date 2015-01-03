package com.tw.todolist.Controllers;


import com.alibaba.fastjson.JSON;
import com.tw.todolist.Models.ToDo;
import com.tw.todolist.Services.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping("/")
public class ToDoController {


    @Autowired
    private ToDoService toDoService;

    @RequestMapping(method = RequestMethod.GET)
    public String showAllToDos(ModelMap modelMap) throws Exception {
        List<ToDo> allToDos = toDoService.getAll();
        modelMap.addAttribute("allToDos", allToDos);
        return "index";
    }

    @RequestMapping(value = "/todo/add", method = RequestMethod.POST)
    public void addToDo(@RequestParam("name") String name, @RequestParam("user_id") Integer userId,
                        HttpServletResponse response) throws Exception {
        PrintWriter printWriter = response.getWriter();
        Integer toDoId = 0;
        Integer done = 0;

        ToDo toDo = new ToDo(toDoId, name, userId, done);
        toDo = toDoService.add(toDo, userId);

        String jsonToDo = JSON.toJSONString(toDo);
        printWriter.print(jsonToDo);
    }

    @RequestMapping(value = "/todo/delete", method = RequestMethod.POST)
    public void deleteToDo(@RequestParam("id") Integer id, HttpServletResponse response) throws Exception {
        toDoService.delete(id);
    }

    @RequestMapping(value = "/todo/update", method = RequestMethod.POST)
    public void updateToDoStatus(@RequestParam("id") Integer id, @RequestParam("name") String name, 
                                 @RequestParam("status") Integer status, HttpServletResponse response) throws Exception {

        ToDo toDo = new ToDo(id, name, 0, status);
        toDoService.update(toDo);
    }
}
