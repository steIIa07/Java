import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JavaStreamExercise {
    public static void main(String[] args) {
        Multiply();
        Filter();
        Reverse();
    }

    private static void Multiply() {
        List<String> number = Arrays.asList("2", "3", "4", "5");
        number.stream().map(x -> 2 * Integer.parseInt(x)).forEach(y -> System.out.println(y));
        System.out.println();
    }

    private static void Filter() {
        List<String> stoplist = Arrays.asList("is", "was", "to", "have", "in", "on");
        List<String> teststr = Arrays.asList("The", "2019-20", "coronavirus", "pandemic", "was", "confirmed",
             "to", "have", "spread", "to", "Japan", "on", "16", "January", "2020", ".");
        List<String> ansList = teststr.stream()
            .filter(x -> !stoplist.contains(x))
            .filter(x -> x.matches("[a-zA-Z]+"))
            .collect(Collectors.toList());
        System.out.println(ansList);
        System.out.println();
    }

    private static void Reverse() {
        List<String> teststr = Arrays.asList("The", "2019-20", "coronavirus", "pandemic", "was", "confirmed",
            "to", "have", "spread", "to", "Japan", "on", "16", "January", "2020", ".");
        List<String> ansList = teststr.stream()
            .sorted((a, b) -> 
            {
                a = a.toLowerCase();
                b = b.toLowerCase();
                return b.compareTo(a);
            }).collect(Collectors.toList());
        System.out.println(ansList);
    }

}
