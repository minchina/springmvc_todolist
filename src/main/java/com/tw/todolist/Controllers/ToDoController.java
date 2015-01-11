package com.tw.todolist.Controllers;


import com.alibaba.fastjson.JSON;
import com.tw.todolist.Domain.ToDo;
import com.tw.todolist.Services.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping("/")
public class ToDoController {


    @Autowired
    private ToDoService toDoService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showAllToDos() throws Exception {
        
        ModelAndView modelAndView = new ModelAndView("index");
        List<ToDo> allToDos = toDoService.getAll();
        modelAndView.addObject("allToDos", allToDos);
        return modelAndView;
    }

    @RequestMapping(value = "/todo/add", method = RequestMethod.POST)
    public void addToDo(@RequestParam("name") String name, @RequestParam("user_id") Integer userId,
                        HttpServletResponse response) throws Exception {
        PrintWriter printWriter = response.getWriter();
        ToDo toDo = createToDoByUserId(name, userId);
        toDo = toDoService.add(toDo, userId);

        printWriter.print(JSON.toJSONString(toDo));
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

    private ToDo createToDoByUserId(String name, Integer userId) {
        Integer toDoId = 0;
        Integer done = 0;

        return new ToDo(toDoId, name, userId, done);
    }
}
