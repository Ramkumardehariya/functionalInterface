package functionalInterface.streamapitest;
import java.util.HashMap;
import java.util.Map;

public class Second {
    public static void main(String[] args) {
        String str = "ramkumar";

        // Map<Character,Integer> charCount = new HashMap<>();

        // str.chars().forEach(c -> charCount.put((char)c, charCount.getOrDefault((char)c, 0)+1));


        // Character result = str.chars()
        //                       .mapToObj(c -> (char) c)
        //                       .filter(c -> charCount.get(c) == 1)
        //                       .findFirst()
        //                       .orElse(null);



        Character result = str.chars()
                              .mapToObj(c -> (char)c)
                              .filter(s -> str.indexOf(s) == str.lastIndexOf(s))
                              .findFirst()
                              .orElse(null);   
        System.out.println(result);

        
    }
}
