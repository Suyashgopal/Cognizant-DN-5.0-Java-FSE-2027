package com.example.junit.advanced;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

public class EvenCheckerTest {
    private EvenChecker checker = new EvenChecker();

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 10})
    public void testIsEven(int num) {
        assertTrue(checker.isEven(num), num + " should be even");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, 9})
    public void testIsOdd(int num) {
        assertTrue(checker.isOdd(num), num + " should be odd");
    }

    @ParameterizedTest
    @CsvSource({
        "2, true",
        "3, false",
        "4, true",
        "5, false",
        "100, true"
    })
    public void testIsEvenCsv(int num, boolean exp) {
        assertEquals(exp, checker.isEven(num));
    }

    @Test
    public void testSumOfEvens() {
        assertEquals(12, checker.sumOfEvens(1, 2, 3, 4, 5, 6));
    }

    @Test
    public void testSumOfEvensEmpty() {
        assertEquals(0, checker.sumOfEvens());
    }
}
