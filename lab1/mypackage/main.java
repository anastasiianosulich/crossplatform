package mypackage;
import java.math.BigInteger;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Введіть кількість дробів для обчислення суми: ");

        if (sc.hasNextInt())
        {
            int number = sc.nextInt();
            int i = 0;
            int m = 2;

            if(number > 0 && number > 15){

                BigFraction res = new BigFraction(BigInteger.valueOf(1), BigInteger.valueOf(1));
                BigFraction [] fractions = new BigFraction[number - 1];
                while (number - 1 > 0){
                    fractions[i] = new BigFraction(BigInteger.valueOf(1), BigInteger.valueOf(m));
                    ++i;
                    ++m;
                    number--;
                }

                for (int g = 0; g < fractions.length; ++g){
                    res = BigFraction.sum(res, fractions[g]);
                }
                System.out.println(res.toString());
            }
            else if(number > 0 && number < 15){

                Fraction res = new Fraction(1, 1);
                Fraction [] fractions = new Fraction[number - 1];
                while (number - 1 > 0){
                    fractions[i] = new Fraction(1, m);
                    ++i;
                    ++m;
                    number--;
                }
                for (int g = 0; g < fractions.length; ++g){
                    res = Fraction.sum(res, fractions[g]);
                }
                System.out.println(res.toString());
            }
        }
        else {
            System.out.println("Вибачте, але ви ввели не число. Перезапустіть програму і спробуйте ще раз!");
        }

    }
}
