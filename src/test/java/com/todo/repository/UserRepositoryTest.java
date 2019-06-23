package com.todo.repository;

import com.todo.base.IntegrationTestBase;
import com.todo.domain.User;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserRepositoryTest extends IntegrationTestBase {

    @Test
    public void findByUsername() {
        User user = userRepository.findAll().get(0);
        Assert.assertEquals(user, userRepository.findByUsername(user.getUsername()));
    }
}