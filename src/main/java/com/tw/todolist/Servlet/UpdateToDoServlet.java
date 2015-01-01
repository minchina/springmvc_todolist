package com.tw.todolist.Servlet;

import com.tw.todolist.Models.ToDo;
import com.tw.todolist.Services.ToDoService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;


public class UpdateToDoServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        Integer status = Integer.valueOf(request.getParameter("status"));

        ToDo toDo = new ToDo(id,name,0,status);

        try {
            new ToDoService().update(toDo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
