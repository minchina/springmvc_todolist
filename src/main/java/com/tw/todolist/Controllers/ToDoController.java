package com.tw.todolist.Controllers;


import com.alibaba.fastjson.JSON;
import com.tw.todolist.Models.ToDo;
import com.tw.todolist.Services.ToDoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
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

    @RequestMapping(value = "/todo/add", method = RequestMethod.POST)
    public void addToDo(HttpServletRequest request, HttpServletResponse response) throws Exception {
        PrintWriter printWriter = response.getWriter();

        String name = request.getParameter("name");
        Integer userId = Integer.valueOf(request.getParameter("user_id"));
        Integer toDoId = 0;
        Integer done = 0;

        ToDo toDo = new ToDo(toDoId, name, userId, done);
        toDo = new ToDoService().add(toDo, userId);

        String jsonToDo = JSON.toJSONString(toDo);
        printWriter.print(jsonToDo);
    }

    @RequestMapping(value = "/todo/delete", method = RequestMethod.POST)
    public void deleteToDo(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Integer id = Integer.valueOf(request.getParameter("id"));
        new ToDoService().delete(id);
    }

    @RequestMapping(value = "/todo/update", method = RequestMethod.POST)
    public void updateToDoStatus(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer id = Integer.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        Integer status = Integer.valueOf(request.getParameter("status"));

        ToDo toDo = new ToDo(id, name, 0, status);
        new ToDoService().update(toDo);
    }
}
