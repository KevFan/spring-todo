package com.todo.controller;

import com.todo.base.IntegrationTestBase;
import org.junit.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class UserControllerTest extends IntegrationTestBase {
    @Test
    public void testCreate() throws Exception{
        mvc.perform(post("/api/v1/user")
                .content("{\"username\": \"newUser\", \"password\": \"password\"}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}