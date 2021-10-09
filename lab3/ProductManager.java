import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class ProductManager {

    private List<Product> _products = new ArrayList<>();
    private DateFormat _dateFormat = new SimpleDateFormat("dd.MM.yyyy");
    private List<Date> _expDates = new ArrayList<>();

    public void ReadFromFile(String filePath, List<Product> products){
        if(products == null){
            products = _products;
        }
        Path path = Paths.get(filePath);
        try {
            Scanner scanner = new Scanner(path);
            while (scanner.hasNextLine()) {
                var strings = scanner.nextLine().split(" ");
                int len = strings.length;
                var price = Float.parseFloat(strings[len - 1]);
                var expDate = _dateFormat.parse(strings[len - 2]);
                var manDate = _dateFormat.parse(strings[len - 3]);
                var name = strings[0];
                int i = 1;
                while (i < len - 3){
                    name += " " + strings[i];
                    ++i;
                }
                products.add(new Product(name, manDate, expDate, price));
                if(!_expDates.contains(expDate)){
                    _expDates.add(expDate);
                }
            }
            scanner.close();
        }
        catch (ParseException ex){

        }
        catch (IOException ex){

        }
    }

    public void Audit(){
        var todayInMillies = ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault()).toInstant().toEpochMilli();
        for(Product product : _products){
            long diffInMillies = Math.abs(product.GetExpDate().getTime() - todayInMillies);
            long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
            if(diff < 3){
                product.SetPrice(product.GetPrice() - product.GetPrice() * 0.1f);
            }
        }
        PrintProducts();
    }

    public void PrintProductsWithExceptString(String exceptStr){
        List<Date> expDates = new ArrayList<>();
        var productsWithoutWord = new ArrayList<Product>();
        var pattern = ".*" + exceptStr.toLowerCase() + ".*";
        System.out.println("Таблиця продуктів без слова \"" + exceptStr + "\" у назві:");

        for (var product : _products){
            if(!Pattern.matches(pattern, product.GetName().toLowerCase())){
                productsWithoutWord.add(product);
                if(!expDates.contains(product.GetExpDate()))
                {expDates.add(product.GetExpDate());}
            }
        }
        for (var date : expDates){
            int flag = 0;
            System.out.print(new SimpleDateFormat("dd-MM-yyyy").format(date) + "            ");
            for(Product product : productsWithoutWord){
                if(product.GetExpDate().equals(date) && flag == 1){
                    System.out.println("                      " + product.GetName() + "    " + new DecimalFormat(".##").format(product.GetPrice()));
                }
                if(product.GetExpDate() == date && flag == 0){
                    System.out.println(product.GetName() + "    " + new DecimalFormat(".##").format(product.GetPrice()) );
                    flag = 1;
                }
            }
        }
    }

    public void PrintProducts(){
        for (var date : _expDates){
            int flag = 0;
            System.out.print(new SimpleDateFormat("dd-MM-yyyy").format(date) + "            ");
            for(Product product : _products){
                    if(product.GetExpDate().equals(date) && flag == 1){
                        System.out.println("                      " + product.GetName() + "    " + new DecimalFormat(".##").format(product.GetPrice()));
                    }
                if(product.GetExpDate() == date && flag == 0){
                    System.out.println(product.GetName() + "    " + new DecimalFormat(".##").format(product.GetPrice()) );
                    flag = 1;
                }
            }
        }
    }

    public void GetExceptionalProducts(String firstPath, String secondPath){
        var products1 = new ArrayList<Product>();
        var products2 = new ArrayList<Product>();
        ReadFromFile(firstPath, products1);
        ReadFromFile(secondPath, products2);
        var buf1 = new ArrayList<Product>(products1);
        var buf2 = new ArrayList<Product>(products2);
        buf1.removeAll(products2);
        buf2.removeAll(products1);
        buf1.addAll(buf2);
        var resultProducts = new ArrayList<Product>(buf1);
        for (var product : buf1){
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(product.GetManDate());
            if(Calendar.getInstance().get(Calendar.YEAR) != calendar.get(Calendar.YEAR)){

                resultProducts.remove(product);
            }
        }
        System.out.println("Unique product collection: ");

        for (var product : resultProducts){
            System.out.println(product);
        }
    }


}
