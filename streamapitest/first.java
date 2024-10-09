package functionalInterface.streamapitest;
// package Test;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class first {
    public static void main(String[] args) {

        String input = "ramkumar";
        
        Map<Character, Integer> charCountMap = new HashMap<>();
        input.chars().forEach(c -> charCountMap.put((char) c, charCountMap.getOrDefault((char) c, 0) + 1));
        
        Map<Character,Integer> map = charCountMap.entrySet().stream()
                .filter(c -> c.getValue() > 1).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        
        System.out.println("all duplicate character: " + map);

    }
}
