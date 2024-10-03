// package functionalInterface.functionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
        Consumer<String> consumer = s -> System.out.println(s);

        Consumer<List<Integer>> listConsumer = li -> {
            for(Integer i : li){
                System.out.println(i+100);
            }
        };
        listConsumer.accept(Arrays.asList(1,2,3,4));
    }
}
