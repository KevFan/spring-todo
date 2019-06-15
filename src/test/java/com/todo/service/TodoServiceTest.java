package com.todo.service;

import com.todo.base.IntegrationTestBase;
import com.todo.domain.Todo;
import com.todo.dto.TodoDTO;
import com.todo.response.TodoResponse;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.test.context.support.WithMockUser;

import java.util.List;

public class TodoServiceTest extends IntegrationTestBase {

    @Autowired
    private TodoService todoService;

    @WithMockUser(username = "user")
    @Test
    public void testFindAll() {
        List<Todo> todos = todoService.findAll();
        Assert.assertFalse(todos.isEmpty());
        for (Todo todo : todos) {
            Assert.assertEquals(todo.getUser().getUsername(), "user");
        }
    }

    @WithMockUser(username = "user")
    @Test
    public void testCreate() {
        TodoDTO todoDTO = new TodoDTO();
        todoDTO.setContents("someContents");

        TodoResponse response = todoService.create(todoDTO);
        Assert.assertEquals(response.getHttpStatus(), HttpStatus.CREATED);
        Assert.assertEquals(response.getTodo().getContent(), todoDTO.getContents());
        Assert.assertEquals(response.getTodo().getUser().getUsername(), "user");
    }

    @WithMockUser(username = "user")
    @Test
    public void testUpdate() {
        TodoDTO todoDTO = new TodoDTO();
        todoDTO.setContents("someContents");

        TodoResponse response = todoService.create(todoDTO);
        Assert.assertEquals(response.getTodo().getContent(), todoDTO.getContents());

        todoDTO.setContents("updatedContents");
        response = todoService.update(response.getTodo().getId(), todoDTO);

        Assert.assertEquals(response.getHttpStatus(), HttpStatus.ACCEPTED);
        Assert.assertEquals(response.getTodo().getContent(), todoDTO.getContents());
        Assert.assertEquals(response.getTodo().getUser().getUsername(), "user");
    }

    @WithMockUser(username = "user")
    @Test
    public void testDelete() {
        TodoDTO todoDTO = new TodoDTO();
        todoDTO.setContents("someContents");

        TodoResponse response = todoService.create(todoDTO);

        Assert.assertEquals(HttpStatus.OK, todoService.delete(response.getTodo().getId()));
    }

    @WithMockUser(username = "user")
    @Test
    public void testSearch() {
        List<Todo> todos = todoService.search("todo");
        for (Todo todo : todos) {
            Assert.assertTrue(todo.getContent().contains("todo"));
            Assert.assertEquals(todo.getUser().getUsername(), "user");
        }
    }
}