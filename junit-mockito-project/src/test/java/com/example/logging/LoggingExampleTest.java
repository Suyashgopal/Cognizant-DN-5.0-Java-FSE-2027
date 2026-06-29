package com.example.logging;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoggingExampleTest {
    @Test
    public void testLoggingLevels() {
        LoggingExample log = new LoggingExample();
        // Should not throw
        log.logLevels();
        assertTrue(true);
    }

    @Test
    public void testLogWithException() {
        LoggingExample log = new LoggingExample();
        Exception ex = new IllegalArgumentException("Test error");
        // Should not throw
        log.logWithException(ex);
        assertTrue(true);
    }

    @Test
    public void testProcessValidData() {
        LoggingExample log = new LoggingExample();
        log.processData("123");
        // Should successfully parse
        assertTrue(true);
    }

    @Test
    public void testProcessInvalidData() {
        LoggingExample log = new LoggingExample();
        log.processData("not-a-number");
        // Should handle parse error
        assertTrue(true);
    }

    @Test
    public void testMultipleLogging() {
        LoggingExample log = new LoggingExample();
        log.processData("100");
        log.processData("200");
        log.processData("abc");
        assertTrue(true);
    }
}
