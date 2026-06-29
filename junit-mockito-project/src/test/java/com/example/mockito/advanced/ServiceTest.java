package com.example.mockito.advanced;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ServiceTest {
    @Mock
    private Repository mockRepository;
    private Service service;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        service = new Service(mockRepository);
    }

    @Test
    public void testServiceWithMockRepository() {
        when(mockRepository.getData()).thenReturn("Mock Data");

        Object result = service.fetchData();

        assertEquals("Mock Data", result);
        verify(mockRepository).getData();
    }

    @Test
    public void testSaveData() {
        Object data = "Test Data";
        service.store(data);

        verify(mockRepository).save(data);
    }

    @Test
    public void testGetById() {
        when(mockRepository.findById(1L)).thenReturn("User 1");

        Object result = service.getById(1L);

        assertEquals("User 1", result);
        verify(mockRepository).findById(1L);
    }

    @Test
    public void testConsecutiveCalls() {
        when(mockRepository.getData())
            .thenReturn("First")
            .thenReturn("Second")
            .thenReturn("Third");

        assertEquals("First", service.fetchData());
        assertEquals("Second", service.fetchData());
        assertEquals("Third", service.fetchData());
    }

    @Test
    public void testVerifyMultipleCalls() {
        when(mockRepository.getData()).thenReturn("Data");

        service.fetchData();
        service.fetchData();
        service.fetchData();

        verify(mockRepository, times(3)).getData();
    }
}
