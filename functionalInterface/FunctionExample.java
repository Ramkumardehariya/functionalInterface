// package functionalInterface.functionalInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Function;
import java.util.List;

public class FunctionExample {
    public static void main(String[] args) {
        Function<String,Integer> function1 = x -> x.length();
        Function<String,String> function2 = s -> s.substring(0, 3);

        Function<List<Student> , List<Student>> studentsWithVipAsprefix = li -> {
            List<Student> result = new ArrayList<>();
            for(Student s : li){
                if(function2.apply(s.getName()).equalsIgnoreCase("vip")){
                    result.add(s);
                }
            }
            return result;
        };

        Student s1 = new Student(2, "vipul");
        Student s2 = new Student(2, "vipulav");
        Student s3 = new Student(2, "Arnav");
        Student s4 = new Student(2, "vipulsha");
        Student s5 = new Student(2, "Ram");

        List<Student> students = Arrays.asList(s1, s2, s3,s4,s5);

        List<Student> filterStudents = studentsWithVipAsprefix.apply(students);
        System.out.println(filterStudents);
    }

    private static class Student{
        private int id;
        private String name;
        

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
        @Override
        public String toString() {
            return "Student [name=" + name + "]";
        }
        
        
        
    }
}
