package com.tw.todolist.Servlet;

import com.tw.todolist.Models.User;
import com.tw.todolist.Services.UserService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class DeleteUserServlet extends HttpServlet{


    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response){
        Integer userId = Integer.valueOf(request.getParameter("user_id"));
        try {
            new UserService().delete(new User(userId));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
