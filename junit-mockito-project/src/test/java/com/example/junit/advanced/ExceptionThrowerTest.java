package com.example.junit.advanced;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExceptionThrowerTest {
    private ExceptionThrower thrower = new ExceptionThrower();

    @Test
    public void testThrowException() {
        assertThrows(RuntimeException.class, () -> {
            thrower.throwException();
        });
    }

    @Test
    public void testThrowExceptionMessage() {
        RuntimeException ex = assertThrows(RuntimeException.class, () -> {
            thrower.throwException();
        });
        assertEquals("This is a test exception", ex.getMessage());
    }

    @Test
    public void testThrowIllegalArgument() {
        assertThrows(IllegalArgumentException.class, () -> {
            thrower.throwIllegalArgument(null);
        });
    }

    @Test
    public void testThrowIllegalArgumentEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            thrower.throwIllegalArgument("");
        });
    }

    @Test
    public void testProcessWithNull() {
        assertThrows(NullPointerException.class, () -> {
            thrower.process(null);
        });
    }

    @Test
    public void testProcessWithEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            thrower.process("");
        });
    }

    @Test
    public void testProcessWithValid() {
        assertEquals(5, thrower.process("hello"));
    }
}
