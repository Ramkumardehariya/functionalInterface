// package functionalInterface.stream;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Arrays;

public class Example {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "cherry");
        List<String> myStream= list.stream().filter(s -> s == "banana").collect(Collectors.toList());

        String[] array = {"apple", "banana", "cheeryy"};
        Stream<String> stram = Arrays.stream(array);

        Stream<Integer> integerStream = Stream.of(1,2,3);

        Stream<Integer> limit = Stream.iterate(0, n -> n+1).limit(100);

        Stream<Integer> limit1 = Stream.generate(() -> (int)(Math.random()*100)).limit(10);

        System.out.println(myStream);
        // System.out.println(stram);
        // System.out.println(integerStream);
        // System.out.println(limit);
        // System.out.println(limit1);
    }
}
