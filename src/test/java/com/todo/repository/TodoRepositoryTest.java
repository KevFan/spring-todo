package com.todo.repository;

import com.todo.base.IntegrationTestBase;
import com.todo.domain.Todo;
import com.todo.domain.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TodoRepositoryTest extends IntegrationTestBase {

    @Test
    public void findAllByUser() {
        User user = userRepository.findByUsername("user");
        List<Todo> todos = todoRepository.findAllByUser(user);
        Assert.assertEquals(todos.size(), 3);
        for (Todo todo : todos) {
            Assert.assertEquals(user, todo.getUser());
        }
    }

    @Test
    public void findByIdAndUser() {
        Todo todo = todoRepository.findAll().get(0);
        Assert.assertEquals(todo, todoRepository.findByIdAndUser(todo.getId(), todo.getUser()));
    }

    @Test
    public void findByUserAndAndContentLike() {
        User user = userRepository.findByUsername("user");
        List<Todo> todos = todoRepository.findByUserAndAndContentLike(user, "todo");
        Assert.assertEquals(todos.size(), 3);
        for (Todo todo : todos) {
            Assert.assertEquals(user, todo.getUser());
            Assert.assertTrue(todo.getContent().contains("todo"));
        }

        todos = todoRepository.findByUserAndAndContentLike(user, "2");
        Assert.assertEquals(todos.size(), 1);
        Assert.assertEquals(user, todos.get(0).getUser());
        Assert.assertTrue(todos.get(0).getContent().contains("2"));
    }
}