package com.tw.todolist.Servlet;

import com.alibaba.fastjson.JSON;
import com.tw.todolist.Models.User;
import com.tw.todolist.Services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


public class UserListServlet extends HttpServlet {
    private List<User> userList;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            userList = new UserService().getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("userList", userList);
        request.getRequestDispatcher("/userlist.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = null;
        String userName = request.getParameter("user_name");
        PrintWriter printWriter = response.getWriter();
        try {
            user = new UserService().add(new User(userName));
        } catch (Exception e) {
            e.printStackTrace();
        }
        String jsonUser = JSON.toJSONString(user);
        printWriter.print(jsonUser);
    }
}
