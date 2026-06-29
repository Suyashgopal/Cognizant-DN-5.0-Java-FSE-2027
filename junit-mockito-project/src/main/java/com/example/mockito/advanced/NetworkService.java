package com.example.mockito.advanced;

public class NetworkService {
    private NetworkClient client;

    public NetworkService(NetworkClient client) {
        this.client = client;
    }

    public String communicate() {
        String conn = client.connect();
        if (client.isConnected()) {
            return "Connected: " + conn;
        }
        return "Connection failed";
    }

    public void sendMessage(String msg) {
        if (client.isConnected()) {
            client.send(msg);
        }
    }

    public void close() {
        client.disconnect();
    }
}
