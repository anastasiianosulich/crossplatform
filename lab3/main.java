import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class main {

    public static void main(String[] args) {

        String firstPath = "C:\\Users\\lichn\\lab3.txt";
        String secondPath = "C:\\Users\\lichn\\second.txt";

        var productManager = new ProductManager();
        productManager.ReadFromFile(firstPath, null);

        while (true){
            System.out.println("Виберіть бажану операцію: \nНатисніть 1 - для переоцінки продуктів, до закінчення терміну споживання яких лишилося менше 3 днів\n" +
                    "Натисніть 2 - для вилучення з таблиці продукту за певною назвою\n" +
                    "Натисніть 3 - для організації унікальної колекції продуктів з 2 файлів\n" +
                    "Натисніть 4 - для виходу з програми.");
            Scanner in = new Scanner(System.in);
            int choice = in.nextInt();
            if (choice == 4) return;
            if(choice == 1){
                productManager.Audit();
            }
            if(choice == 2){
                Scanner i = new Scanner(System.in);
                String word = i.nextLine();
                productManager.PrintProductsWithExceptString(word);
            }
            if(choice == 3){
                productManager.GetExceptionalProducts(firstPath, secondPath);
            }
        }


    }
}
