package functionalInterface.streamapitest;
import java.util.Arrays;
import java.util.List;

public class Third {
    public static void main(String[] args) {
        // Given a list of names, use the Stream API to count the number of names starting withthe letter "J".

        List<String> list = Arrays.asList("ram", "ramesh", "john", "Jay");

        long countName = list.stream()
                          .filter(name -> name.toLowerCase().startsWith("j"))  
                          .count();

        System.out.println(countName);
    }
}
