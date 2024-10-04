import java.util.Arrays;
import java.util.List;

public class Example3 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Ram", "Shyam", "Kamal");
        list.forEach(System.out::println);
    }
}
