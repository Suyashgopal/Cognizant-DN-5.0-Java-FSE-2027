package com.example.mockito.advanced;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class FileServiceTest {
    @Mock
    private FileHandler mockHandler;
    private FileService service;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        service = new FileService(mockHandler);
    }

    @Test
    public void testReadAndProcess() {
        when(mockHandler.exists("/file.txt")).thenReturn(true);
        when(mockHandler.readFile("/file.txt")).thenReturn("File Content");

        String result = service.readAndProcess("/file.txt");

        assertEquals("Processed File Content", result);
        verify(mockHandler).exists("/file.txt");
        verify(mockHandler).readFile("/file.txt");
    }

    @Test
    public void testReadFileNotFound() {
        when(mockHandler.exists("/missing.txt")).thenReturn(false);

        String result = service.readAndProcess("/missing.txt");

        assertEquals("File not found", result);
        verify(mockHandler, never()).readFile(anyString());
    }

    @Test
    public void testSaveFile() {
        service.saveFile("/new.txt", "Content");

        verify(mockHandler).writeFile("/new.txt", "Content");
    }

    @Test
    public void testInOrderVerification() {
        when(mockHandler.exists("/file.txt")).thenReturn(true);
        when(mockHandler.readFile("/file.txt")).thenReturn("Data");

        service.readAndProcess("/file.txt");

        InOrder order = inOrder(mockHandler);
        order.verify(mockHandler).exists("/file.txt");
        order.verify(mockHandler).readFile("/file.txt");
    }

    @Test
    public void testExceptionHandling() {
        when(mockHandler.readFile(anyString())).thenThrow(new RuntimeException("Read error"));

        assertThrows(RuntimeException.class, () -> {
            when(mockHandler.exists(anyString())).thenReturn(true);
            mockHandler.readFile("file.txt");
        });
    }
}
