package com.example.junit.advanced;

public class ExceptionThrower {
    public void throwException() {
        throw new RuntimeException("This is a test exception");
    }

    public void throwIllegalArgument(String arg) {
        if (arg == null || arg.isEmpty()) {
            throw new IllegalArgumentException("Argument cannot be null or empty");
        }
    }

    public int process(String input) {
        if (input == null) {
            throw new NullPointerException("Input cannot be null");
        }
        if (input.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be empty");
        }
        return input.length();
    }
}
