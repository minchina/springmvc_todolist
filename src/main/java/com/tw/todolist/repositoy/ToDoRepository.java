package com.tw.todolist.repositoy;

import com.tw.todolist.Domain.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional(readOnly = true)
public interface ToDoRepository extends JpaRepository<ToDo, Long>{

    List<ToDo> findByUserId(Long userId);

    @Modifying
    @Transactional
    @Query("delete from ToDo todo where todo.id = ?1")
    void deleteById(Long id);
}
