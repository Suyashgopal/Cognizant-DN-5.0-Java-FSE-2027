package com.example.mockito.advanced;

public interface NetworkClient {
    String connect();
    String send(String msg);
    void disconnect();
    boolean isConnected();
}
