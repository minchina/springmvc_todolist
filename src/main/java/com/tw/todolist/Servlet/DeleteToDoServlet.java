package com.tw.todolist.Servlet;

import com.tw.todolist.Services.ToDoService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class DeleteToDoServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        Integer id = Integer.valueOf(request.getParameter("id"));
        try {
            new ToDoService().delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        out.print("success");
    }
}
