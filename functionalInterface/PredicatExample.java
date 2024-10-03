// package functionalInterface.functionalInterface;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.List;

public class PredicatExample {
    public static void main(String[] args) {
        Predicate<Integer> predicate = x -> x > 1000;
        System.out.println(predicate.test(100));

        int salary = 10000;
        if(predicate.test(salary)){
            System.out.println("salary is greater");
        }


        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);

        int sum = numbers.stream().filter(n->n%2 == 0).mapToInt(n ->n).sum();

        System.out.println(sum);

        Predicate<Integer> isEven = x -> x%2 == 0;
        List<Integer> num = Arrays.asList(1,2,3,4,5);

        for(Integer i : num){
            if(isEven.test(i)){
                System.out.println(i);
            }
        }
    }
}
