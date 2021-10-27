import java.security.InvalidParameterException;

public class main {
    public static void main(String[] args) {
        var textProcessor = new TextProcessor();

        try {
            textProcessor.ProcessText("");
        }
        catch (InvalidParameterException e) {
            System.out.println(e.getMessage());
        }

        try {
            textProcessor.ProcessText("     ");
        }
        catch (InvalidParameterException e) {
            System.out.println(e.getMessage());
        }

        try {
            textProcessor.ProcessText(null);
        }
        catch (InvalidParameterException e) {
            System.out.println(e.getMessage());
        }

        try {
            textProcessor.ProcessText("$^ * (&^ ? 23 ^^^");
        }
        catch (InvalidParameterException e) {
            System.out.println(e.getMessage());
        }
        try {
            textProcessor.ProcessText("3563 45 %$# (& !");
        }
        catch (InvalidParameterException e) {
            System.out.println(e.getMessage());
        }
        try {
            var input = "hvv    rur vruur vruvjr. ygr yvr vyr! vfvj vruv ruhgi> fhhgbgb ujf54 jugt 45ufg g";
            System.out.println("\n" + input);
            System.out.println(textProcessor.ProcessText(input));
        }
        catch (InvalidParameterException e) {
            System.out.println(e.getMessage());
        }
        try {
            var input = "43YGdvv jdfh det65ftv dbv76 45u54 &fbv *() ! @#hbKh$$";
            System.out.println("\n" + input);
            System.out.println(textProcessor.ProcessText(input));
        }
        catch (InvalidParameterException e) {
            System.out.println(e.getMessage());
        }
    }
}
