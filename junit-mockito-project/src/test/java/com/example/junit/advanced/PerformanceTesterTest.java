package com.example.junit.advanced;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;
import java.util.concurrent.TimeUnit;

public class PerformanceTesterTest {
    private PerformanceTester tester = new PerformanceTester();

    @Test
    @Timeout(1)
    public void testFastTask() {
        tester.fastTask();
    }

    @Test
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    public void testPerformTask() {
        tester.performTask();
    }

    @Test
    @Timeout(value = 10, unit = TimeUnit.SECONDS)
    public void testSlowTask() {
        tester.slowTask();
    }

    @Test
    public void testProcessData() {
        String result = tester.processData("hello");
        assertEquals("HELLO", result);
    }

    @Test
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    public void testProcessDataTimeout() {
        String result = tester.processData("test");
        assertNotNull(result);
    }
}
