import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextProcessor {

     public static String ProcessText(String text){

         if(text == null){
             throw new InvalidParameterException("Стрічка є null, що є некоректно. Спробуйте ще раз!");
         }
        if(text.isBlank()){
            throw new InvalidParameterException("Стрічка є порожньою, що є некоректно. Спробуйте ще раз!");
        }

        var words = text.split("\s+");
        var pattern = "\\S*[a-zA-Z]+\\S*";

        int counter = 0;
        for (var word : words){
            if(!word.matches(pattern)){
                counter++;
            }
        }
        if(counter == words.length){
            throw new InvalidParameterException("Жодне слово у стрічці не містить букв, що є некоректно. Спробуйте ще раз!");
        }
        else {
            var newWords = new ArrayList<String>();
            for (var word : words){
                Pattern template = Pattern.compile("[a-zA-Z]+?");
                Matcher matcher = template.matcher(word);
                int index = 0;
                while (matcher.find()) {
                    index = matcher.start();
                }
                word = word.substring(0, index) + word.substring(index, index + 1).toUpperCase() + word.substring(index + 1);
                newWords.add(word);
            }
            return (String.join(" ", newWords));
        }
    }
}
