package com.example.junit.basic;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {
    private Calculator calc;

    @Before
    public void setUp() {
        calc = new Calculator();
    }

    @Test
    public void testAdd() {
        assertEquals(5, calc.add(2, 3));
    }

    @Test
    public void testAddNegative() {
        assertEquals(-1, calc.add(-2, 1));
    }

    @Test
    public void testSubtract() {
        assertEquals(2, calc.subtract(5, 3));
    }

    @Test
    public void testMultiply() {
        assertEquals(15, calc.multiply(3, 5));
    }

    @Test
    public void testMultiplyByZero() {
        assertEquals(0, calc.multiply(5, 0));
    }

    @Test
    public void testDivide() {
        assertEquals(3, calc.divide(15, 5));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivideByZero() {
        calc.divide(10, 0);
    }

    @Test
    public void testIsPositive() {
        assertTrue(calc.isPositive(5));
        assertFalse(calc.isPositive(-5));
        assertFalse(calc.isPositive(0));
    }

    @Test
    public void testIsNegative() {
        assertTrue(calc.isNegative(-5));
        assertFalse(calc.isNegative(5));
        assertFalse(calc.isNegative(0));
    }

    @Test
    public void testAssertions() {
        assertEquals(5, 2 + 3);
        assertTrue(5 > 3);
        assertFalse(5 < 3);
        assertNull(null);
        assertNotNull(new Object());
    }
}
