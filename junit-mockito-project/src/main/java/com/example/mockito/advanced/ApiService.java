package com.example.mockito.advanced;

public class ApiService {
    private RestClient client;

    public ApiService(RestClient client) {
        this.client = client;
    }

    public String fetchData() {
        return "Fetched " + client.getResponse();
    }

    public boolean sendData(String url, String data) {
        String response = client.post(url, data);
        return response != null && !response.isEmpty();
    }

    public void removeData(String url) {
        client.delete(url);
    }
}
