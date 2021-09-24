package mypackage;

import java.math.BigInteger;

public class BigMyMath {
    static BigInteger nok(BigInteger a, BigInteger b) {
        return (a.multiply(b)).divide(nod(a, b));
    }

    static BigInteger nod(BigInteger a, BigInteger b) {
        if (b.intValue() == 0) {
            return a;
        }
        return nod(b, a.mod(b));
    }
}
