package functionalInterface.streamapitest;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Example5 {
    public static void main(String[] args) {
        Predicate<Integer> predicate = x -> x%2 == 0;

        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);

        for(int i = 0; i<list.size(); i++){
            if(predicate.test(list.get(i))){
                System.out.print(list.get(i)+" ");
            }
        }
        System.out.println();

        Function<Integer,Integer> function = a -> a/2;

        for(int i = 0; i<list.size(); i++){
            System.out.print(function.apply(list.get(i))+" ");
        }
        System.out.println();
        Consumer<Integer> consumer = x -> System.out.print(x+" ");

        for(Integer num: list){
            consumer.accept(num);
        }
        System.out.println();
        Supplier<Integer> supplier = () -> 100;

        List<Integer> temp = Arrays.asList(supplier.get());

        System.out.println(temp);



    }
}
