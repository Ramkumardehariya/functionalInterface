import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Example2 {
    public static void main(String[] args) {
        List<List<String>> list = Arrays.asList(
            Arrays.asList("Ram","Shyma"), 
            Arrays.asList("Rakesh","Radhe"),
            Arrays.asList("sundar","susheel")
            );
        
        List<Integer> stram = list.stream().flatMap(x -> x.stream()).map(str -> str.length()).collect(Collectors.toList());

        System.out.println(stram);
    }
}
