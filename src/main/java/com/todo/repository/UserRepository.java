package com.todo.repository;

import com.todo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * User: kevinfan
 * Date: 2019-06-12
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
