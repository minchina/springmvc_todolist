package com.tw.todolist.repositoy;

import com.tw.todolist.domain.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface ToDoRepository extends JpaRepository<ToDo, Long>{

    @Modifying
    @Transactional
    @Query("delete from ToDo todo where todo.id = ?1")
    void deleteById(Long id);

    @Modifying
    @Transactional
    @Query("update ToDo todo set todo.name = ?2,todo.complete = ?3 where todo.id = ?1")
    void updateToDo(Long id, String name, boolean complete);

    ToDo findByName(String name);
}
