package com.todo.controller;

import com.todo.dto.UserDTO;
import org.junit.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class UserControllerTest extends ApiTestBase {
    @Test
    public void testCreate() throws Exception{
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername("test");
        userDTO.setPassword("test");
        mvc.perform(post("/api/v1/user").content("{\"username\": \"newUser\", \"password\": \"password\"}")
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }
}