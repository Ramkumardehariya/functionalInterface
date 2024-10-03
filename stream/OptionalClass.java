// package functionalInterface.stream;

import java.util.Optional;

public class OptionalClass {

    static Optional<String> getName(int id){
        String name = null;
        return Optional.ofNullable(name);
    }
    public static void main(String[] args) {
        Optional<String> name = getName(2);

        name.ifPresent(System.out::println);
    }
}
