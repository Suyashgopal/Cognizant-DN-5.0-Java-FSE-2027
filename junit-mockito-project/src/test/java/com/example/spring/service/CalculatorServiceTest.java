package com.example.spring.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CalculatorServiceTest {
    @Autowired
    private CalculatorService calcService;

    @Test
    public void testAdd() {
        assertEquals(5, calcService.add(2, 3));
    }

    @Test
    public void testSubtract() {
        assertEquals(2, calcService.subtract(5, 3));
    }

    @Test
    public void testMultiply() {
        assertEquals(15, calcService.multiply(3, 5));
    }

    @Test
    public void testDivide() {
        assertEquals(3, calcService.divide(15, 5));
    }

    @Test
    public void testDivideByZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            calcService.divide(10, 0);
        });
    }
}
