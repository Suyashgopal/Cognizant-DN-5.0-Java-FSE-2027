package com.example.mockito.advanced;

public interface RestClient {
    String getResponse();
    String post(String url, String data);
    void delete(String url);
}
