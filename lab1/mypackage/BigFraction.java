package mypackage;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigFraction {

    private BigInteger numerator;
    private BigInteger denominator;

    BigFraction() {
        this.numerator = BigDecimal.valueOf(java.lang.Math.random() * 31).toBigInteger();
        this.denominator = BigInteger.valueOf(1).add(BigDecimal.valueOf(java.lang.Math.random() * 30).toBigInteger());
    }

    public BigFraction(BigInteger numerator, BigInteger denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }


    public static BigFraction sum(BigFraction a, BigFraction b) {

        BigInteger cDenominator = BigMyMath.nok(a.denominator, b.denominator);
        BigInteger cNumerator =
                a.numerator.multiply(cDenominator.divide(a.denominator)).add(
                        b.numerator.multiply((cDenominator.divide(b.denominator))));

        BigFraction c = new BigFraction(cNumerator, cDenominator);
        return c;
    }

    @Override
    public String toString() {
        return "Fraction(дріб){" +
                "numerator(чисельник)=" + numerator +
                ", denominator(знаменник)=" + denominator +
                '}';
    }
}
