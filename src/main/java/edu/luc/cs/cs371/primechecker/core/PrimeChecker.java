package edu.luc.cs.cs371.primechecker.core;

import java.math.BigInteger;

public interface PrimeChecker {

    static boolean isPrimeSlow(final BigInteger i) {
        final var compareToTwo = i.compareTo(BigInteger.TWO);
        if (compareToTwo < 0) {
            return false;
        }
        if (compareToTwo == 0) {
            return true;
        }
        if (!i.testBit(0)) {
            return false;
        }
        final var sqroot = i.sqrt();
        var k = BigInteger.valueOf(3);
        while (k.compareTo(sqroot) <= 0) {
            if (i.mod(k).equals(BigInteger.ZERO)) {
                return false;
            }
            k = k.add(BigInteger.TWO);
        }
        return true;
    }
}
