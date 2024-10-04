

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// import addressbooksystems.Contacts;

class Student {

    private int id;
    private String firstName;
    private int age;
    private String gender;
    private String dept;
    private String city;
    private int rank;
    private List<String> contacts;

    public Student(int id, String firstName, int age, String gender, String dept, String city, int rank, List<String> contacts) {
        this.id = id;
        this.firstName = firstName;
        this.age = age;
        this.gender = gender;
        this.dept = dept;
        this.city = city;
        this.rank = rank;
        this.contacts = contacts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public List<String> getContacts() {
        return contacts;
    }

    public void setContacts(List<String> contacts) {
        this.contacts = contacts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && age == student.age && rank == student.rank && Objects.equals(firstName, student.firstName) && Objects.equals(gender, student.gender) && Objects.equals(dept, student.dept) && Objects.equals(city, student.city) && Objects.equals(contacts, student.contacts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, age, gender, dept, city, rank, contacts);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", dept='" + dept + '\'' +
                ", city='" + city + '\'' +
                ", rank=" + rank +
                ", contacts=" + contacts +
                '}';
    }
}

public class StudentTest{
    public static void main(String[] args) {
        List<Student> studentList = Stream.of(
            new Student(1, "Rohit", 30, "Male", "Mechanical Engineering", "Mumbai", 122, Arrays.asList("+912632632782", "+1673434729929")),
            new Student(2, "Pulkit", 56, "Male", "Computer Engineering", "Delhi", 67, Arrays.asList("+912632632762", "+1673434723929")),
            new Student(3, "Ankit", 25, "Female", "Mechanical Engineering", "Kerala", 164, Arrays.asList("+912632633882", "+1673434709929")),
            new Student(4, "Satish Ray", 30, "Male", "Mechanical Engineering", "Kerala", 26, Arrays.asList("+9126325832782", "+1671434729929")),
            new Student(5, "Roshan", 23, "Male", "Biotech Engineering", "Mumbai", 12, Arrays.asList("+012632632782")),
            new Student(6, "Chetan", 24, "Male", "Mechanical Engineering", "Karnataka", 90, Arrays.asList("+9126254632782", "+16736784729929")),
            new Student(7, "Arun", 26, "Male", "Electronics Engineering", "Karnataka", 324, Arrays.asList("+912632632782", "+1671234729929")),
            new Student(8, "Nam", 31, "Male", "Computer Engineering", "Karnataka", 433, Arrays.asList("+9126326355782", "+1673434729929")),
            new Student(9, "Sonu", 27, "Female", "Computer Engineering", "Karnataka", 7, Arrays.asList("+9126398932782", "+16563434729929", "+5673434729929")),
            new Student(10, "Shubham", 26, "Male", "Instrumentation Engineering", "Mumbai", 98, Arrays.asList("+912632646482", "+16734323229929")))
                .collect(Collectors.toList());


        // 1. Find the list of students whose rank is in between 50 and 100
        List<Student> usingRank = studentList.stream()
                                             .filter(st -> st.getRank() >= 50 && st.getRank() <= 100)
                                             .collect(Collectors.toList());
        System.out.println(usingRank);
        System.out.println();


        //2. Find the Students who stays in Karnataka and sort them by their names
        List<Student> sortedByname = studentList.stream()
                                                .filter(x -> x.getCity().toLowerCase().contains("karnataka"))
                                                .sorted((p1,p2) -> p1.getFirstName().compareTo(p2.getFirstName()))
                                                .collect(Collectors.toList());
        System.out.println("sorted by name: "+sortedByname);
        System.out.println();

        // 3. Find all departments names
        List<String> findDepartment = studentList.stream().map(x -> x.getDept()).collect(Collectors.toList());
        System.out.println("find all departement is: "+findDepartment);
        System.out.println();

        //4.  Find all the contact numbers
        List<List<String>> findContact = studentList.stream()
                                                    .map(x -> x.getContacts())
                                                    .collect(Collectors.toList());
        System.out.println("All contacts is: "+findContact);
        System.out.println();

        //5.  Group The Student By Department Names
        Map<String,List<Student>> groupBydepartment = studentList.stream()
                                                                 .collect(Collectors.groupingBy(std -> std.getDept()));
        System.out.println("Grouping by department is: "+groupBydepartment);
        System.out.println();


        //6. Find the department who is having maximum number of students
        String maxStudentDept = studentList.stream()
                                           .collect(Collectors.groupingBy(Student::getDept, Collectors.counting()))
                                           .entrySet()
                                           .stream()
                                           .max(Map.Entry.comparingByValue())
                                           .map(Map.Entry::getKey)
                                           .orElse("No department");
        System.out.println("maximum number of student in department is: "+maxStudentDept);
        System.out.println();
                   

        //7. Find the average age of male and female students
        Map<String,Double> findAvg = studentList.stream()
                                                 .collect(Collectors.groupingBy(Student::getGender, Collectors.averagingInt(Student::getAge)));
        System.err.println("find averge using student: "+findAvg);
        System.out.println();

        //8. Find the highest rank in each department
        Map<String,Optional<Student>> highestRank = studentList.stream()
                                                    .collect(Collectors.groupingBy(Student::getDept, Collectors.maxBy(Comparator.comparingInt(Student::getRank))));
        System.out.println("Highest rank in each department is: "+highestRank);


        //9 .Find the student who has second rank
        Optional<Student> secondRank = studentList.stream()
                                                  .sorted(Comparator.comparingInt(Student::getRank))
                                                  .skip(1)
                                                  .findFirst();
        System.out.println("second ranke is : "+secondRank);
         
    }
}
