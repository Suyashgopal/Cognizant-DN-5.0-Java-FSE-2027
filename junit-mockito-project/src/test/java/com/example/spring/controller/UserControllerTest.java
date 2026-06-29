package com.example.spring.controller;

import com.example.spring.entity.User;
import com.example.spring.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;

@WebMvcTest(UserController.class)
public class UserControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService mockService;

    @Test
    public void testGetUser() throws Exception {
        User user = new User(1L, "John", "john@example.com");
        when(mockService.getUserById(1L)).thenReturn(user);

        mvc.perform(get("/users/1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name").value("John"))
            .andExpect(jsonPath("$.email").value("john@example.com"));

        verify(mockService).getUserById(1L);
    }

    @Test
    public void testGetUserNotFound() throws Exception {
        when(mockService.getUserById(999L)).thenReturn(null);

        mvc.perform(get("/users/999"))
            .andExpect(status().isNotFound());
    }

    @Test
    public void testCreateUser() throws Exception {
        User user = new User("Alice", "alice@example.com");
        User saved = new User(1L, "Alice", "alice@example.com");
        when(mockService.saveUser(any(User.class))).thenReturn(saved);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(user);

        mvc.perform(post("/users")
            .contentType(MediaType.APPLICATION_JSON)
            .content(json))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(1L));

        verify(mockService).saveUser(any(User.class));
    }

    @Test
    public void testGetAllUsers() throws Exception {
        when(mockService.getAllUsers()).thenReturn(Arrays.asList(
            new User(1L, "John", "john@example.com"),
            new User(2L, "Alice", "alice@example.com")
        ));

        mvc.perform(get("/users"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].name").value("John"))
            .andExpect(jsonPath("$[1].name").value("Alice"));

        verify(mockService).getAllUsers();
    }

    @Test
    public void testUpdateUser() throws Exception {
        User user = new User(1L, "John Updated", "john@example.com");
        when(mockService.updateUser(any(User.class))).thenReturn(user);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(user);

        mvc.perform(put("/users/1")
            .contentType(MediaType.APPLICATION_JSON)
            .content(json))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name").value("John Updated"));

        verify(mockService).updateUser(any(User.class));
    }

    @Test
    public void testDeleteUser() throws Exception {
        mvc.perform(delete("/users/1"))
            .andExpect(status().isOk());

        verify(mockService).deleteUser(1L);
    }
}
