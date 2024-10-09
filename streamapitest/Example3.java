package functionalInterface.streamapitest;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.OptionalInt;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.Map;
import java.util.List;

public class Example3 {
    public static void main(String[] args) {
        int arr[] = {89,7,8,9,10,18,2,3,4,5,6,20,12,45,67,71,12,14,17,18,2,3,4,5,5,5,6};

        // 1. Find the sum of all even numbers in an array using Stream API.
        int sumEven = Arrays.stream(arr)
                            .filter(a -> a%2 == 0)
                            .sum();
        System.out.println(sumEven);

        // 2. Find the largest/smallest number in an array using Stream API.
        OptionalInt smallest = Arrays.stream(arr).min();
        System.out.println(smallest.getAsInt());

        OptionalInt largest = Arrays.stream(arr).max();
        System.out.println(largest.getAsInt());
        
        // 3. Count occurrences of each character in a string using Stream API.
        String str = "ramkumar";
        Map<Character,Long> countChar = str.chars()
                                     .mapToObj(c -> (char)c)
                                     .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println("count character: "+countChar);

        // 4. Find the first non-repeated character in a string using Stream API.
        Character ch = str.chars()
                          .mapToObj(c -> (char)c)
                          .filter(s -> str.indexOf(s) == str.lastIndexOf(s))
                          .findFirst()
                          .orElse(null);
        System.out.println(ch);

        // 5. Check if two strings are anagrams using Stream API.
        String first = "aman";
        String second = "naam";

        boolean isAnagram = Arrays.equals(first.chars().sorted().toArray(), second.chars().sorted().toArray());
        System.out.println(isAnagram);
      

        // 6. Reverse a string using Stream API.
        String reverseString = str.chars()
                                  .mapToObj(c -> (char)c)
                                  .collect(Collectors.toList())
                                  .reversed()
                                  .toString();
        System.out.println(reverseString);

        // 7. Check if a string is a palindrome using Stream API.
        String st = "ramkumar";

        boolean isPalindrome = IntStream.range(0, st.length()/2)
                 .allMatch(i -> st.charAt(i) == st.charAt(st.length()-i-1));

        System.out.println(isPalindrome);

        // 8. Find the second largest element in an array using Stream API.
        int maxi = Arrays.stream(arr)
                         .boxed()
                         .sorted((a,b) -> b-a)
                         .skip(1)
                         .findFirst()
                         .orElse(null);

        System.out.println("second largest "+maxi);

        // 9. Find all duplicate elements in an array using Stream API.
        // List<Integer> allDuplicate = Arrays.stream(arr)
        //                                    .boxed()
        //                                    .collect(Collectors.groupingBy(n -> n, Collectors.counting()))
        //                                    .entrySet()
        //                                    .stream()
        //                                    .filter(a -> a.getValue()>1)
        //                                    .map(Map.Entry::getKey)
        //                                    .collect(Collectors.toList());
        List<Integer> allDuplicate = Arrays.stream(arr)
                                           .boxed()
                                           .filter(i -> Arrays.stream(arr).filter(n -> n == i).count() > 1)
                                           .distinct()
                                           .collect(Collectors.toList());
        System.out.println(allDuplicate);


        // 10. Remove all occurrences of a specific element from an array using Stream API.
        int element = 2;
        List<Integer> allOccurence = Arrays.stream(arr)
                                           .boxed()
                                           .filter(n -> n != element)
                                           .collect(Collectors.toList());
        System.out.println(allOccurence);

        
        // 11. Merge two sorted arrays using Stream API.
        int []arr1 = {1,3,5,7,9,11};
        int []arr2 = {2,4,6,8,10,12,13,14};

        int []mergeArray = IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2))
                                            .sorted()
                                            .toArray();
        System.out.println(Arrays.toString(mergeArray));

        
        // 12. Find the intersection of two arrays using Stream API.
        int []arr3 = {1,2,4,6,7,9,10};
        int []arr4 = {2,3,4,5,6,7,8,9};
        List<Integer> intersection = Arrays.stream(arr3)
                                           .filter(n -> Arrays.stream(arr4).anyMatch(i -> n==i))
                                           .distinct()
                                           .boxed()
                                           .collect(Collectors.toList());
        System.out.println(intersection);
        

        // 13. Find the union of two arrays using Stream API.
        int []union = IntStream.concat(Arrays.stream(arr3), Arrays.stream(arr4))
                                       .distinct()
                                       .sorted()
                                       .toArray();
        System.out.println(Arrays.toString(union));
        
        // 14. Rotate an array by K positions using Stream API.
        int k = 7;
        int []arr5 = {1,2,3,4,5,6,7,8,9,10,11,12,12};
        k = k%arr5.length;

        int []rotateArray = IntStream.concat(Arrays.stream(arr5,k,arr5.length), Arrays.stream(arr5,0,k)).toArray();

        System.out.println(Arrays.toString(rotateArray));

        
        // 15. Find the most frequent element in an array using Stream API.
        int mostFrequent = Arrays.stream(arr)
                                 .boxed()
                                 .collect(Collectors.groupingBy(n -> n,Collectors.counting()))
                                 .entrySet()
                                 .stream()
                                 .max(Comparator.comparingLong(Map.Entry::getValue))
                                 .get()
                                 .getKey();
        System.out.println(mostFrequent);
        
    }
}
