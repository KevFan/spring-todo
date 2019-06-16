package com.todo.controller;

import com.todo.base.IntegrationTestBase;
import org.junit.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class AuthenticationTest extends IntegrationTestBase {
    @Test
    public void testLoginUnSuccessful() throws Exception{
        mvc.perform(post("/api/v1/authenticate")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                .param("username", "user")
                .param("password", "wrongPassword"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    public void testLoginSuccessful() throws Exception{
        mvc.perform(post("/api/v1/authenticate")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                .param("username", "user")
                .param("password", "password"))
                .andExpect(status().isOk());
    }
}