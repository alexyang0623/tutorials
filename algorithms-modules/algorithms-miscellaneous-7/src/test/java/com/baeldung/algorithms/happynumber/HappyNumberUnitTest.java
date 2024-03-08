package com.baeldung.algorithms.happynumber;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

class HappyNumberDecider {

    public static boolean isHappyNumber(int n) {
        Set<Integer> checkedNumbers = new HashSet<>();
        while (true) {
            n = sumDigitsSquare(n);
            if (n == 1) {
                return true;
            }
            if (checkedNumbers.contains(n)) {
                return false;
            }
            checkedNumbers.add(n);
        }
    }

    public static boolean isHappyNumber2(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = sumDigitsSquare(slow);
            fast = sumDigitsSquare(sumDigitsSquare(fast));
        } while (slow != fast);

        return slow == 1;
    }

    private static int sumDigitsSquare(int n) {
        int squareSum = 0;
        while (n != 0) {
            squareSum += (n % 10) * (n % 10);
            n /= 10;
        }
        return squareSum;
    }
}

public class HappyNumberUnitTest {

    @Test
    void whenUsingIsHappyNumber_thenGetTheExpectedResult() {
        assertTrue(HappyNumberDecider.isHappyNumber(7));
        assertTrue(HappyNumberDecider.isHappyNumber(10));
        assertTrue(HappyNumberDecider.isHappyNumber(13));
        assertTrue(HappyNumberDecider.isHappyNumber(19));
        assertTrue(HappyNumberDecider.isHappyNumber(23));

        assertFalse(HappyNumberDecider.isHappyNumber(4));
        assertFalse(HappyNumberDecider.isHappyNumber(6));
        assertFalse(HappyNumberDecider.isHappyNumber(11));
        assertFalse(HappyNumberDecider.isHappyNumber(15));
        assertFalse(HappyNumberDecider.isHappyNumber(20));

    }

    @Test
    void whenUsingIsHappyNumber2_thenGetTheExpectedResult() {
        assertTrue(HappyNumberDecider.isHappyNumber2(7));
        assertTrue(HappyNumberDecider.isHappyNumber2(10));
        assertTrue(HappyNumberDecider.isHappyNumber2(13));
        assertTrue(HappyNumberDecider.isHappyNumber2(19));
        assertTrue(HappyNumberDecider.isHappyNumber2(23));

        assertFalse(HappyNumberDecider.isHappyNumber2(4));
        assertFalse(HappyNumberDecider.isHappyNumber2(6));
        assertFalse(HappyNumberDecider.isHappyNumber2(11));
        assertFalse(HappyNumberDecider.isHappyNumber2(15));
        assertFalse(HappyNumberDecider.isHappyNumber2(20));

    }

}