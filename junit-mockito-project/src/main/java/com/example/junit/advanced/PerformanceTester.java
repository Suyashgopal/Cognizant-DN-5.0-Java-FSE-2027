package com.example.junit.advanced;

public class PerformanceTester {
    public void performTask() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void fastTask() {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += i;
        }
    }

    public void slowTask() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public String processData(String data) {
        return data.toUpperCase();
    }
}
