package homework0410;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;




public class MainPattern {

    String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    String passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&_+\\-=]).{8,}$";


    public static void main(String[] args) {

        String text = "На дворе трава, на траве дрова.";

        String wordPattern = "\\W+";  // Регулярное выражение для слов

        Pattern pattern = Pattern.compile(wordPattern);
        Matcher matcher = pattern.matcher(text);

        Map<String, Integer> wordCount = new HashMap<>();

        while (matcher.find()) {
            String word = matcher.group().toLowerCase();  // Приведение слова к нижнему регистру
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Вывод количества встречающихся слов
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}






