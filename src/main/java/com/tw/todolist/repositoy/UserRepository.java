package com.tw.todolist.repositoy;

import com.tw.todolist.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

    @Modifying
    @Query("delete from User u where u.id = ?1")
    void deleteById(Long id);

    User findByName(String name);


}
