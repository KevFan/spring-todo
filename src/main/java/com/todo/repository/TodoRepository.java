package com.todo.repository;

import com.todo.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * User: kevinfan
 * Date: 2019-06-12
 */
public interface TodoRepository extends JpaRepository<Todo, Long> {
}
