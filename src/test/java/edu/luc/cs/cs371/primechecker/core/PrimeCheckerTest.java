package edu.luc.cs.cs371.primechecker.core;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.math.BigInteger;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PrimeCheckerTest {

    @ParameterizedTest
    @ValueSource(ints = {-7, -1, 0, 1, 4, 6, 8, 9, 6008, 6033})
    void isPrime_ShouldReturnFalse(int number) {
        assertFalse(PrimeChecker.isPrimeSlow(BigInteger.valueOf(number)));
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 5, 7, 17, 6007})
    void isPrime_ShouldReturnTrue(int number) {
        assertTrue(PrimeChecker.isPrimeSlow(BigInteger.valueOf(number)));
    }
}
