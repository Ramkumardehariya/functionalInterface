// package functionalInterface.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Example1 {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,2,3,4,1,2,5,7,8,9,1,1,2,3);

        List<Integer> list1 = list.stream().filter(x -> x%2 == 0).collect(Collectors.toList());

        System.out.println(list1);

        List<Integer> list2 = list.stream()
                              .map(x -> x/2)
                              .sorted((a,b) -> (b-a))
                              .distinct()
                              .limit(8)
                              .skip(1)
                              .peek(x -> System.out.println(x))
                              .collect(Collectors.toList());

        Integer list3 = list.stream()
                              .distinct()
                              .sorted((a,b)-> b-a)
                              .reduce((a,b) -> a > b ? a : b)
                              .get();

        List<String> str = Arrays.asList("ram", "radhe", "shyam", "ghanshyam");

        List<String> temp = str.stream().filter(a -> a.startsWith("ra")).collect(Collectors.toList());
        System.out.println(temp);

    }
}
