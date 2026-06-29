package com.example.mockito.advanced;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ApiServiceTest {
    @Mock
    private RestClient mockClient;
    private ApiService service;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        service = new ApiService(mockClient);
    }

    @Test
    public void testFetchData() {
        when(mockClient.getResponse()).thenReturn("Mock Response");

        String result = service.fetchData();

        assertEquals("Fetched Mock Response", result);
        verify(mockClient).getResponse();
    }

    @Test
    public void testSendData() {
        when(mockClient.post(anyString(), anyString())).thenReturn("OK");

        boolean result = service.sendData("/api/data", "test");

        assertTrue(result);
        verify(mockClient).post("/api/data", "test");
    }

    @Test
    public void testSendDataFailure() {
        when(mockClient.post(anyString(), anyString())).thenReturn("");

        boolean result = service.sendData("/api/data", "test");

        assertFalse(result);
    }

    @Test
    public void testRemoveData() {
        service.removeData("/api/data");

        verify(mockClient).delete("/api/data");
    }

    @Test
    public void testMockingWithArgumentMatchers() {
        when(mockClient.post("url1", "data1")).thenReturn("Res1");
        when(mockClient.post("url2", "data2")).thenReturn("Res2");

        service.sendData("url1", "data1");
        service.sendData("url2", "data2");

        verify(mockClient).post("url1", "data1");
        verify(mockClient).post("url2", "data2");
    }
}
