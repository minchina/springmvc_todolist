package com.tw.todolist.Services;

import com.tw.todolist.Dao.ToDoDao;
import com.tw.todolist.Models.ToDo;
import com.tw.todolist.Models.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ToDoService {
    private List<ToDo> toDoList = new ArrayList<ToDo>();
    ToDoDao toDoDao;

    public ToDoService() throws SQLException {
        toDoDao = new ToDoDao();
    }

    public ToDo add(ToDo toDo,Integer userId) throws SQLException, ClassNotFoundException {
        User user = new UserService().findUserById(userId);
        return toDoDao.add(toDo,user);
    }

    public List<ToDo> getAll() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = toDoDao.getAll();
        while (resultSet.next()) {
            toDoList.add(new ToDo(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(4), resultSet.getInt(3)));
        }
        return toDoList;
    }

    public void delete(Integer id) throws SQLException, ClassNotFoundException {
        toDoDao.remove(id);
    }

    public void update(ToDo toDo) throws SQLException {
        toDoDao.update(toDo);
    }

    public List<ToDo> getToDoListByUserId(int userId) throws SQLException {
        return toDoDao.getToDoListByUserId(userId);
    }
}
