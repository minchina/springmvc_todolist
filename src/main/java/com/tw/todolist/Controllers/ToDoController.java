package com.tw.todolist.Controllers;


import com.tw.todolist.Domain.ToDo;
import com.tw.todolist.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class ToDoController {



    @Autowired
    ToDoService toDoService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showAllToDos(){

        ModelAndView modelAndView = new ModelAndView("index");
        List<ToDo> allToDos = toDoService.findAllToDos();
        modelAndView.addObject("allToDos", allToDos);
        return modelAndView;
    }

    @RequestMapping(value = "/todo/add", method = RequestMethod.POST)
    @ResponseBody
    public ToDo addToDo(@RequestParam("name") String name, @RequestParam("user_id") Long userId){

        return toDoService.save(new ToDo(name, userId));
    }

    @RequestMapping(value = "/todo/delete", method = RequestMethod.POST)
    @ResponseBody
    public Long deleteToDo(@RequestParam("id") Long id)  {

        toDoService.deleteById(id);
        return id;

    }

    @RequestMapping(value = "/todo/update", method = RequestMethod.POST)
    @ResponseBody
    public ToDo updateToDoStatus(@RequestBody final ToDo toDo){

        toDoService.updateToDo(toDo);
        return toDo;

    }
}
