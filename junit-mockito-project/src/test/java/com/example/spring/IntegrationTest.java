package com.example.spring;

import com.example.spring.entity.User;
import com.example.spring.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private UserRepository repo;

    @Test
    public void testFullFlow() throws Exception {
        User newUser = new User("Test User", "test@example.com");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(newUser);

        mvc.perform(post("/users")
            .contentType(MediaType.APPLICATION_JSON)
            .content(json))
            .andExpect(status().isOk());

        mvc.perform(get("/users"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].name").value("Test User"));
    }

    @Test
    public void testCreateAndRetrieve() throws Exception {
        User user = new User("Integration Test", "integ@test.com");
        User saved = repo.save(user);

        mvc.perform(get("/users/" + saved.getId()))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name").value("Integration Test"));
    }

    @Test
    public void testUpdateIntegration() throws Exception {
        User user = new User("Original", "orig@example.com");
        User saved = repo.save(user);

        User updated = new User(saved.getId(), "Updated", "orig@example.com");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(updated);

        mvc.perform(put("/users/" + saved.getId())
            .contentType(MediaType.APPLICATION_JSON)
            .content(json))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name").value("Updated"));
    }

    @Test
    public void testDeleteIntegration() throws Exception {
        User user = new User("To Delete", "delete@example.com");
        User saved = repo.save(user);

        mvc.perform(delete("/users/" + saved.getId()))
            .andExpect(status().isOk());
    }
}
