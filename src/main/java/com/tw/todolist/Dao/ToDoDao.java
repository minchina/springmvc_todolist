package com.tw.todolist.Dao;


import com.tw.todolist.Models.ToDo;
import com.tw.todolist.Models.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ToDoDao extends Dao {


    public ToDoDao() throws SQLException {
    }

    public void update(ToDo toDo) throws SQLException {
        Integer id = toDo.getId();
        String name = toDo.getName();
        Integer status = toDo.getDone();

        PreparedStatement updateUser = connection.prepareStatement("UPDATE list SET done = ? , name = ? WHERE id = ?");
        updateUser.setInt(1, status);
        updateUser.setString(2, name);
        updateUser.setInt(3, id);
        updateUser.executeUpdate();

        close();
    }

    public ToDo add(ToDo toDo, User user) throws SQLException, ClassNotFoundException {
        String name = toDo.getName();
        int done = toDo.getDone();
        Integer userId = user.getId();

        PreparedStatement addUserSql = connection.prepareStatement("INSERT INTO list(name, done, userid) VALUE (?,?,?)");
        addUserSql.setString(1, name);
        addUserSql.setInt(2, done);
        addUserSql.setInt(3, userId);
        addUserSql.executeUpdate();

        return findLastTodo();
    }

    public ResultSet getAll() throws SQLException, ClassNotFoundException {
        PreparedStatement allToDos = connection.prepareStatement(" select * from list ");
        return allToDos.executeQuery();
    }

    public void remove(Integer id) throws SQLException, ClassNotFoundException {
        PreparedStatement removeSql = connection.prepareStatement("delete from list where id = ?");
        removeSql.setInt(1, id);
        removeSql.execute();
        close();
    }

    public List<ToDo> getToDoListByUserId(int userId) throws SQLException {
        List<ToDo> toDoList = new ArrayList<ToDo>();
        PreparedStatement userSet = connection.prepareStatement("select * from list where userid = ? ");
        userSet.setInt(1, userId);
        ResultSet resultSet = userSet.executeQuery();

        while (resultSet.next()) {
            toDoList.add(new ToDo(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(4), resultSet.getInt(3)));
        }
        return toDoList;

    }

    //这里应该还有问题.
    public ToDo findLastTodo() throws SQLException {
        ToDo toDo = null;
        PreparedStatement lastToDo = connection.prepareStatement("SELECT * FROM list WHERE id = (SELECT MAX (id) FROM list)");
        ResultSet resultSet = lastToDo.executeQuery();
        while (resultSet.next()) {
            toDo = new ToDo(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(4), resultSet.getInt(3));
        }
        return toDo;
    }
}
