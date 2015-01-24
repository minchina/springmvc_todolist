package com.tw.todolist.repositoy;

import com.tw.todolist.Domain.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional(readOnly = true)
public interface ToDoRepository extends JpaRepository<ToDo, Long>{


}
