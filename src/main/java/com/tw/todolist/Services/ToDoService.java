package com.tw.todolist.Services;

import com.tw.todolist.Dao.ToDoDao;
import com.tw.todolist.Domain.ToDo;
import com.tw.todolist.Domain.User;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ToDoService {

    ToDoDao toDoDao;

    public ToDoService() throws Exception {
        toDoDao = new ToDoDao();
    }

    public ToDo add(ToDo toDo,Integer userId) throws Exception {
        User user = new UserService().findUserById(userId);
        return toDoDao.add(toDo,user);
    }

    public List<ToDo> getAll() throws Exception {
        List<ToDo> toDoList = new ArrayList<ToDo>();
        ResultSet resultSet = toDoDao.getAll();
        while (resultSet.next()) {
            toDoList.add(new ToDo(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(4), resultSet.getInt(3)));
        }
        return toDoList;
    }

    public void delete(Integer id) throws Exception{
        toDoDao.remove(id);
    }

    public void update(ToDo toDo) throws Exception {
        toDoDao.update(toDo);
    }

    public List<ToDo> getToDoListByUserId(int userId) throws Exception{
        return toDoDao.getToDoListByUserId(userId);
    }
}
