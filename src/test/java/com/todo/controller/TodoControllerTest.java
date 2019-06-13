package com.todo.controller;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class TodoControllerTest extends ApiTestBase {

    @Test
    public void testFindAllUnAuthorized() throws Exception {
        mvc.perform(get("/api/v1/todo")).andExpect(status().isUnauthorized());
    }

    @WithMockUser(username = "user")
    @Test
    public void testFindAllAuthorized() throws Exception {
        mvc.perform(get("/api/v1/todo")).andExpect(status().isOk());
    }

    @Test
    public void testCreateUnAuthorized() throws Exception {
        mvc.perform(post("/api/v1/todo").contentType(MediaType.APPLICATION_JSON)
                .content("{\"contents\": \"my todo\"}")).andExpect(status().isUnauthorized());
    }

    @WithMockUser(username = "user")
    @Test
    public void testCreateAuthorized() throws Exception {
        mvc.perform(post("/api/v1/todo").contentType(MediaType.APPLICATION_JSON)
                .content("{\"contents\": \"my todo\"}")).andExpect(status().isCreated());
    }

    @Test
    public void testUpdateUnAuthorized() throws Exception {
        mvc.perform(put("/api/v1/todo/1").contentType(MediaType.APPLICATION_JSON)
                .content("{\"contents\": \"updated todo\"}")).andExpect(status().isUnauthorized());
    }

    @WithMockUser(username = "user")
    @Test
    public void testUpdateAuthorized() throws Exception {
        mvc.perform(put("/api/v1/todo/2").contentType(MediaType.APPLICATION_JSON)
                .content("{\"contents\": \"updated todo\"}")).andExpect(status().isAccepted());
    }

    @WithMockUser(username = "user")
    @Test
    public void testUpdateAuthorizedNotFound() throws Exception {
        mvc.perform(put("/api/v1/todo/10").contentType(MediaType.APPLICATION_JSON)
                .content("{\"contents\": \"updated todo\"}")).andExpect(status().isNotFound());
    }

    @Test
    public void testDeleteUnAuthorized() throws Exception {
        mvc.perform(delete("/api/v1/todo/1")).andExpect(status().isUnauthorized());
    }

    @WithMockUser(username = "user")
    @Test
    public void testDeleteAuthorized() throws Exception {
        mvc.perform(delete("/api/v1/todo/1")).andExpect(status().isOk());
    }

    @WithMockUser(username = "user")
    @Test
    public void testDeleteAuthorizedNotFound() throws Exception {
        mvc.perform(delete("/api/v1/todo/10")).andExpect(status().isNotFound());
    }
}