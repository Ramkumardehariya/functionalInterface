package functionalInterface.streamapitest;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.List;
import java.util.Map.Entry;
import java.util.function.Function;

public class Example4 {
    public static void main(String[] args) {
        int []arr = {1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,9,12,34,56,78,12};


        // 1. Find the Sum of Elements in an Array:
        int arr1[] = {1,2,3,4,5,6,7,8,9,10};
        int sum = Arrays.stream(arr1).sum();
        System.out.println(sum);

        
        // 2. Find the Maximum Element in an Array:
        int maxi = Arrays.stream(arr).max().getAsInt();
        System.out.println(maxi);
        
        // 3. Find the Minimum Element in an Array:
        int mini = Arrays.stream(arr).min().getAsInt();
        System.out.println(mini);
        
        // 4. Count the Even and Odd Numbers:
        long odd = Arrays.stream(arr1)
                        .filter(n -> n%2 != 0)
                        .count();
        System.out.println("odd is: "+odd);

        long even = Arrays.stream(arr1)
                        .filter(n -> n%2 == 0)
                        .count();
        System.out.println("even is: "+even);
        
        // 5. Calculate the Average of Elements:
        double average = Arrays.stream(arr1)
                            .average().getAsDouble();
        System.out.println("Average is: "+average);
        
        // 6. Remove Duplicates from an Array:
        int []removeDuplicate = Arrays.stream(arr).distinct().toArray();
        System.out.println(Arrays.toString(removeDuplicate));
        
        // 7. Reverse an Array:
        List<Integer> reversedArray = Arrays.stream(arr1)
                                    .boxed()
                                    .collect(Collectors.toList()).reversed();
        System.out.println(reversedArray);

        // 8. Rotate an Array by K Positions:
        int k = 5;
        k = k%arr1.length;
        int rotateArray[] = IntStream.concat(Arrays.stream(arr1,k, arr1.length), Arrays.stream(arr1, 0, k)).toArray();
        System.out.println("rotatateArray is: "+Arrays.toString(rotateArray));

        // 9. Find the Second Largest Element:
        int secondLargest = Arrays.stream(arr1)
                                  .boxed()
                                  .sorted((a,b) -> b-a)
                                  .skip(2)
                                  .findFirst()
                                  .get();
        System.out.println(secondLargest);
        // 10. Check if an Array is Sorted:
        int arr4[] = {1,2,3,4};
        int length = arr4.length;
        boolean arrayisSorted = IntStream.range(0, length-1)
                                         .allMatch(i -> arr4[i] <= arr4[i+1]);
        System.out.println("Array is sorted or not: "+arrayisSorted);

        
        // 11. Merge Two Arrays:
        int []mergeArray = IntStream.concat(Arrays.stream(arr), Arrays.stream(arr1))
                                    .sorted()
                                    .toArray();
        System.out.println("merged array: "+Arrays.toString(mergeArray));
        
        // 12. Find the Intersection of Two Arrays:
        int []intersection = Arrays.stream(arr)
                                   .filter(i -> Arrays.stream(arr1).anyMatch(n -> i == n))
                                   .distinct()
                                   .toArray();
        System.out.println("Intersectioin array is: "+Arrays.toString(intersection));
        
        // 13. Find the Union of Two Arrays:
        int []union = IntStream.concat(Arrays.stream(arr), Arrays.stream(arr1))
                               .distinct()
                               .sorted()
                               .toArray();
        System.out.println("union is: "+Arrays.toString(union));
        
        // 14. Count the Frequency of Each Element:
        Map<Integer,Long> map = Arrays.stream(arr)
                                         .boxed()
                                         .collect(Collectors.groupingBy(i -> i,Collectors.counting()));
        System.out.println(map);
        

       
        // 15. Find the Most Frequent Element:
        int mostFrequent = Arrays.stream(arr)
                                 .boxed()
                                 .collect(Collectors.groupingBy(i -> i,Collectors.counting()))
                                 .entrySet()
                                 .stream()
                                 .max(Comparator.comparingLong(Map.Entry::getValue))
                                 .get()
                                 .getKey();
        System.out.println("most Frequent element is: "+mostFrequent);

        // 16. Find the Missing Number in a Sequence:
        int []arr3 = {1,2,3,4,5,6,7,8,9,10,12,13};
        int missingNumber = (arr3.length+1)*(arr3.length+2)/2-Arrays.stream(arr3).sum();

        System.out.println("missing Number is: "+missingNumber);

        
        // 17. Find Common Elements in Multiple Arrays:


       
        // 18. Create a New Array from Existing Array with Conditions:

        
        // 19. Find the Kth Smallest/Largest Element:
        int kth = 4;
        int arr5[] = {6,5,4,3,2,7,8,9,1,10,19,11,12,13,15};
        int smallest = Arrays.stream(arr5).boxed().sorted().skip(kth-1).findFirst().orElse(null);
        System.out.println("kth Smallest number is: "+smallest);

        int largest = Arrays.stream(arr5).boxed().sorted((a,b) -> b-a).skip(kth-1).findFirst().orElse(null);
        System.out.println("kth largest number is: "+largest);

       
        // 20. Check for Pairs that Sum to a Target Value:
        int[] arr6 = {2, 4, 3, 7, 5, 8, 1};
        int target = 9;
        List<Entry<Integer,Integer>> pairSum = IntStream.range(0, arr6.length)
                                                        .boxed()
                                                        .flatMap(i -> IntStream.range(i+1, arr6.length)
                                                                               .filter(j -> arr[i]+arr[j] == target)
                                                                               .mapToObj(j -> new AbstractMap.SimpleEntry<>(arr[i],arr[j])))
                                                        .collect(Collectors.toList());

        System.out.println(pairSum);

       
        // 21. Check if Two Arrays are Equal:
        boolean arraysEqual = Arrays.equals(arr6,arr6);
        System.out.println(arraysEqual);


       
        // 22. Sort an Array:
        Arrays.sort(arr6);
        System.out.println(Arrays.toString(arr6));

        
        // 23. Find the Length of the Longest Consecutive Sequence:

        
        // 24. Find the Longest Increasing Subsequence:

       
        // 25. Generate All Subarrays:

       
        // String Questions
        // 26. Count the Number of Vowels in a String:
        String str = "ramkumar";
        long num = str.chars().mapToObj(c -> (char)c).filter(a -> "aeiou".indexOf(a) != -1).count();

        System.out.println(num);
        // 27. Check if a String is a Palindrome:
        boolean palindromeOrNot = IntStream.range(0, str.length()/2).allMatch(i -> str.charAt(i) == str.charAt(str.length()-i-1));
        System.out.println("Palindrome or not: "+palindromeOrNot);

        
        // 28. Reverse a String:
        String reverseString = str.chars().mapToObj(c -> (char)c).collect(Collectors.toList()).reversed().toString();
        System.out.println(reverseString);

        
        // 29. Find the First Non-Repeated Character:
        Character ch = str.chars().mapToObj(c -> (char)c)
                                  .filter(c -> str.indexOf(c) == str.lastIndexOf(c))
                                  .findFirst()
                                  .orElse(null);
        System.out.println(ch);

        
        // 30. Find the Length of Each Word in a Sentence:
        String temp = "I am ramkumar dehariya";

        Arrays.stream(temp.split("\\s"))
              .forEach(i -> System.out.println(i+ ": "+i.length()));

        
        // 31. Remove All Spaces from a String:
        String removeSpace = temp.chars()
                                 .filter(c -> !Character.isWhitespace(c))
                                 .mapToObj(c -> String.valueOf((char) c))
                                 .collect(Collectors.joining());
        System.out.println(removeSpace);


       
        // 32. Find All Permutations of a String:
        // Stream<String> permutation = str.chars()
        //                                 .mapToObj(c -> (char)c)
        //                                 .flatMap(ch -> findPermutation(ch.))

        
        // 33. Count the Frequency of Each Character:
        Map<Character,Long> countFrequency = str.chars()
                                                .mapToObj(c -> (char)c)
                                                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(countFrequency);
                                                   
                                        
        // 34. Find the Longest Word in a Sentence:
        String longestWord = Arrays.stream(temp.split("\\s"))
                                   .max((word1, word2) -> Integer.compare(word1.length(), word2.length()))
                                   .orElse(null);
        System.out.println(longestWord);


        
        // 35. Replace All Occurrences of a Character:
        String allOccurence = str.chars()
                                 .mapToObj(c -> c == 'a' ? "o" : (char) c)
                                 .collect(Collectors.toList()).toString();
        System.out.println(allOccurence);

        
        // 36. Check if Two Strings are Anagrams:
        String str1 = "listen";
        String str2 = "silent";

        boolean anagrams = str1.chars()
                               .boxed()
                               .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                               .equals(str2.chars()
                                           .boxed()
                                           .collect(Collectors.groupingBy(Function.identity(),Collectors.counting())));
        System.out.println(anagrams);

        
        // 37. Find All Substrings of a String:
        IntStream.range(0, str.length())
                 .forEach(i -> IntStream.range(i+1, str.length()+1)
                                        .mapToObj(j -> str.substring(i,j))
                                        .forEach(System.out::print));

        
        // 38. Check if a String Contains Only Digits:
        String str3 = "012344rt";
        boolean containsDigit = str3.chars().allMatch(Character::isDigit);
        System.out.println(containsDigit);

        
        // 39. Convert a String to Title Case:

        
        // 40. Count the Number of Words in a Sentence:
        long countWords = Arrays.stream(temp.split("\\s")).count();
        System.out.println(countWords);

       
        // 41. Find the Longest Palindromic Substring:

        
        // 42. Check if a String Contains Only Unique Characters:
        String str4 = "ram";
        char []tempChar = str4.toCharArray();

        Arrays.sort(tempChar);
        boolean uniqueCharacter = IntStream.range(1, tempChar.length)
                 .allMatch(i -> tempChar[i] != tempChar[i-1]);
        System.out.println(uniqueCharacter);



        
        // 43. Generate a Random String of Given Length:

        
        // 44. Capitalize the First Letter of Each Word:

      
        // 45. Find the First Repeated Character:

        
        // Combined Array and String Questions
        // 46. Convert an Array of Strings to a Single String:

        
        // 47. Find the Maximum Length of Words in an Array of Strings:

        
        // 48. Remove Empty Strings from an Array:

        
        // 49. Sort an Array of Strings by Length:

       
        // 50. Check for anagrams in an array of strings:
    }
}
