import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.io.IOException;


public class FileManager {

    private static List<SimpleDateFormat> dateFormats = new ArrayList<>() {{
        add(new SimpleDateFormat("dd/MM/yyyy"));
        add(new SimpleDateFormat("dd.MM.yyyy"));
        add(new SimpleDateFormat("dd-MM-yyyy"));
    }};

    private static List<String> datesInStringFormat = new ArrayList<>();
    private static ArrayList<Date> dates = new ArrayList<>();

    public static void FindDates(String filePath) throws IOException {

        Path path = Paths.get(filePath);
        Scanner scanner = new Scanner(path);
        scanner.useDelimiter(" |\r\n");
        while(scanner.hasNext()){
            var word = scanner.next();

            for(SimpleDateFormat dateFormat : dateFormats){
                try{
                    Date sdf = dateFormat.parse(word);
                    datesInStringFormat.add(dateFormat.format(sdf));
                    dates.add(sdf);
                    break;
                }
                catch (ParseException e) {

                }
            }
        }
        scanner.close();
        var midDate = PrintDateRange();
        PrintSentences(filePath);
        ReplaceDatesWithAverageOne(filePath, midDate);
    }


    public static void PrintSentences(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        Scanner scanner = new Scanner(path);
        scanner.useDelimiter("\\. |\\.\r\n");
        while(scanner.hasNext()){
            var sentence = scanner.next();

            for(String date : datesInStringFormat){
                if(sentence.contains(date)){
                    System.out.println(sentence.toUpperCase());
                    break;
                }
            }
        }
    }


    public static String PrintDateRange(){
        if(dates.size() == 0){
            System.out.println("There is no dates in the source");
            return "";
        }
        if(dates.size() == 1){
            System.out.println("There is only one date in the source: " + dates.get(0));
            return "";
        }
        var min = Collections.min(dates);
        var max = Collections.max(dates);
        System.out.println("Date range: " + new SimpleDateFormat("dd-MM-yyyy").format(min) + "   -   " + new SimpleDateFormat("dd-MM-yyyy").format(max));
        var midDate = new java.sql.Date((min.getTime() + max.getTime()) / 2L);
        System.out.println("middle date: " + new SimpleDateFormat("dd-MM-yyyy").format(midDate));
        return new SimpleDateFormat("dd-MM-yyyy").format(midDate);
    }

    public static void ReplaceDatesWithAverageOne(String filePath, String midDate) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filePath));
        FileWriter newResultFile = new FileWriter("C:\\Users\\lichn\\java3res.txt");

        int ind = 0, lind = 0;
        for(String str : lines)
        {
            ind = 0;
            String additionalStr = "";
            if(lind < datesInStringFormat.size()) {
                int s  = str.indexOf(datesInStringFormat.get(lind));
                while (s != -1){
                    additionalStr += str.substring(ind, s) + midDate;
                    lind++;
                    ind = s + 10;
                    if(lind >= datesInStringFormat.size()) break;
                    s = str.indexOf(datesInStringFormat.get(lind), ind);
                }
            }
            additionalStr += str.substring(ind);
            newResultFile.write(additionalStr + "\r\n");
        }

        newResultFile.close();
    }

}
