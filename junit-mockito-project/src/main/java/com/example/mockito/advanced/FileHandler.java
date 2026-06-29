package com.example.mockito.advanced;

public interface FileHandler {
    String readFile(String path);
    void writeFile(String path, String content);
    boolean exists(String path);
    void delete(String path);
}
