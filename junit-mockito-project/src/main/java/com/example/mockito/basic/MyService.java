package com.example.mockito.basic;

public class MyService {
    private ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public String fetchData() {
        if (api.isAvailable()) {
            return "Fetched " + api.getData();
        }
        return "Service unavailable";
    }

    public void storeData(String data) {
        if (api.isAvailable()) {
            api.sendData(data);
        }
    }

    public String processAndFetch() {
        String raw = api.getData();
        return raw.toLowerCase();
    }
}
