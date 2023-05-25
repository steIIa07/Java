import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.AbstractMap.SimpleEntry;

public class WordCount {
    public static void main(String[] args) {
        String fileName = args[0];
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            Map<String, Integer> wordCountMap = reader.lines()
                .flatMap(line -> Arrays.stream(line.split(" ")))
                .filter(word -> word.matches("[a-zA-Z]+") && word.length() > 0)
                .map(word -> new SimpleEntry<>(word, 1))
                .collect(Collectors.groupingBy(SimpleEntry::getKey, Collectors.summingInt(SimpleEntry::getValue)));

            wordCountMap.forEach((word, count) -> System.out.println(word + ": " + count));
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
