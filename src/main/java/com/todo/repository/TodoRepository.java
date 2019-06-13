package com.todo.repository;

import com.todo.domain.Todo;
import com.todo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * User: kevinfan
 * Date: 2019-06-12
 */
public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findAllByUser(User user);
    Todo findByIdAndUser(Long id, User user);
    @Query("select t from Todo t where t.user = :user and t.content like %:content%")
    List<Todo> findByUserAndAndContentLike(@Param("user") User user, @Param("content") String content);
}
