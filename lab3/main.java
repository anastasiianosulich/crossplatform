import java.io.IOException;

public class main {

    public static void main(String[] args) {
        String path = "C:\\Users\\lichn\\java3ukr.txt";
        try {
            FileManager.FindDates(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
