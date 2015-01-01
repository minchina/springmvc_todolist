package com.tw.todolist.Servlet;

import com.tw.todolist.Models.ToDo;
import com.tw.todolist.Services.ToDoService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IndexServlet extends HttpServlet {
    private List<ToDo> toDoList = new ArrayList<ToDo>();


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            toDoList = new ToDoService().getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("toDoList", toDoList);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
