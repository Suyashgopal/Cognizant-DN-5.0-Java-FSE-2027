package com.example.junit.advanced;

public class EvenChecker {
    public boolean isEven(int num) {
        return num % 2 == 0;
    }

    public boolean isOdd(int num) {
        return num % 2 != 0;
    }

    public int sumOfEvens(int... nums) {
        int sum = 0;
        for (int n : nums) {
            if (isEven(n)) {
                sum += n;
            }
        }
        return sum;
    }
}
