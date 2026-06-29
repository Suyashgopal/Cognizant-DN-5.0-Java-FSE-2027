package com.example.spring.service;

import com.example.spring.entity.User;
import com.example.spring.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class UserServiceTest {
    @Mock
    private UserRepository mockRepo;
    private UserService service;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        service = new UserService();
        service.userRepository = mockRepo;
    }

    @Test
    public void testGetUserById() {
        User user = new User(1L, "John", "john@example.com");
        when(mockRepo.findById(1L)).thenReturn(Optional.of(user));

        User result = service.getUserById(1L);

        assertEquals("John", result.getName());
        verify(mockRepo).findById(1L);
    }

    @Test
    public void testGetUserByIdNotFound() {
        when(mockRepo.findById(999L)).thenReturn(Optional.empty());

        User result = service.getUserById(999L);

        assertNull(result);
    }

    @Test
    public void testSaveUser() {
        User user = new User("Alice", "alice@example.com");
        User saved = new User(1L, "Alice", "alice@example.com");
        when(mockRepo.save(user)).thenReturn(saved);

        User result = service.saveUser(user);

        assertEquals(1L, result.getId());
        verify(mockRepo).save(user);
    }

    @Test
    public void testGetAllUsers() {
        List<User> users = Arrays.asList(
            new User(1L, "John", "john@example.com"),
            new User(2L, "Alice", "alice@example.com")
        );
        when(mockRepo.findAll()).thenReturn(users);

        List<User> result = service.getAllUsers();

        assertEquals(2, result.size());
        verify(mockRepo).findAll();
    }

    @Test
    public void testDeleteUser() {
        service.deleteUser(1L);

        verify(mockRepo).deleteById(1L);
    }

    @Test
    public void testGetUserByEmail() {
        User user = new User(1L, "Bob", "bob@example.com");
        when(mockRepo.findByEmail("bob@example.com")).thenReturn(user);

        User result = service.getUserByEmail("bob@example.com");

        assertEquals("Bob", result.getName());
        verify(mockRepo).findByEmail("bob@example.com");
    }

    @Test
    public void testFindByName() {
        List<User> users = Arrays.asList(
            new User(1L, "John", "j1@example.com"),
            new User(2L, "John", "j2@example.com")
        );
        when(mockRepo.findByName("John")).thenReturn(users);

        List<User> result = service.findByName("John");

        assertEquals(2, result.size());
    }
}
