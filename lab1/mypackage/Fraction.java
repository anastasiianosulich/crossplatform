package mypackage;


public class Fraction {

    private int numerator;
    private int denominator;

    Fraction() {
        this.numerator = (int)(java.lang.Math.random() * 31);
        this.denominator = (1 + (int) ( java.lang.Math.random() * 30 ) );
    }

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        simplify();
    }

    void simplify()
    {
        int gcd = findGCD(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
    }


    //GCD Function
    int findGCD(int a, int b)
    { int temp;
        while(b != 0)
        {
            temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static Fraction sum(Fraction a, Fraction b) {

        int cDenominator = MyMath.nok(a.denominator, b.denominator);
        int cNumerator =
                a.numerator * (cDenominator / a.denominator) +
                        b.numerator * (cDenominator / b.denominator);

        Fraction c = new Fraction(cNumerator, cDenominator);
        return c;
    }

    @Override
    public String toString() {
        return "Fraction(дріб) {" +
                "numerator (чисельник)=" + numerator +
                ", denominator (знаменник)=" + denominator +
                '}';
    }
}
