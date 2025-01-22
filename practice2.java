import java.math.BigDecimal;
import java.sql.Array;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/* Created by SK on 11/19/24 */
public class Test {
    public static void main(String args[]) {

        List<Integer> numberList = Arrays.asList(1, 2, 1, 4, 2, 3, 4, 5, 6);
        age();
        //last();
        //odd10();
        // fibonacci();
        //nonRepeatChar();
        //repeatFirstChar();
        //dupchars();
        //duplicates();
        //numStr();
        //palindrome();
        //repeatArray();
        //first10Even();
        // revint();
        // sum10();
        //reverse();
        //common();
        // sumavg();
        // lengthOrder();
        //largest();
        // sumDigits();
        //anagram();
        //maxmin3();
        //singlearray();
        //merge();
        //maxmin();
        // multiples5();
        //join();
        //sortDecimalsInReverse();
        //  frequencyOfNumber();
        //frequencyOfEachChar();
        //removeDuplicates(numberList);
        //seperateOddEven(numberList);
        //System.out.println("Sum of Squares of odd numbers in the list: " +sumOfsquaresOfOdds(numberList));
    }

    //public BigDecimal Total()
    public static Integer sumOfsquaresOfOdds(List<Integer> numList) {
        Integer total = 0;
       /* for(Integer number : numList){
            if( number%2!=0){
                total=total+ number* number;
            }
        }*/
        total = numList.stream().filter(number -> number % 2 == 1).map(number -> number * number).reduce(0, (a, b) -> a + b);
        return total;
    }

    /* seperate odd and even*/
    public static void seperateOddEven(List<Integer> numList) {
        Map<Boolean, List<Integer>> collect = numList.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
        Set<Map.Entry<Boolean, List<Integer>>> entries = collect.entrySet();
        for (Map.Entry i : entries) {
            if (i.getKey().equals("0")) {
                System.out.println("even values" + i.getValue().toString());
            } else {
                System.out.println("odd values" + i.getValue().toString());
            }
        }

    }

    /*2. How do you remove duplicate elements from a list using Java 8 streams*/
    public static void removeDuplicates(List<Integer> numList) {
        List<Integer> noDuplicates = numList.stream().distinct().toList();
        System.out.println(noDuplicates.toString());
    }

    //  3) How do you find frequency of each character in a string using Java 8 streams?
    public static void frequencyOfEachChar() {
        String s = "Rohini";
        Map<Character, Long> smap = s.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        for (Map.Entry<Character, Long> ms : smap.entrySet()) {
            System.out.println(ms.getKey() + ":" + ms.getValue());
        }
    }

    // 4) How do you find frequency of each element in an array or a list?
    public static void frequencyOfNumber() {
        List<Integer> alist = Arrays.asList(1, 1, 5, 4, 2, 3, 4, 5);
        System.out.println(alist.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
    }

    // 5) How do you sort the given list of decimals in reverse order?
    public static void sortDecimalsInReverse() {
        List<Integer> llist = Arrays.asList(1, 12, 123, 22, 32, 24, 54);
        llist.stream().sorted(Comparator.reverseOrder()).toList().forEach(System.out::println);
    }

    // 6) Given a list of strings, join the strings with ‘[‘ as prefix, ‘]’ as suffix and ‘,’ as delimiter?
    public static void join() {
        List<String> strs = Arrays.asList("Rohini, Santhosh, Sriram, Sahasra");
        System.out.println(strs.stream().collect(Collectors.joining(",", "[", "]")).toString());

    }

    //7) From the given list of integers, print the numbers which are multiples of 5?
    public static void multiples5() {
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 15, 20);
        intList.stream().filter(s -> s % 5 == 0).forEach(System.out::println);
    }

    //8) Given a list of integers, find maximum and minimum of those numbers?
    public static void maxmin() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        int max = list.stream().max(Comparator.naturalOrder()).get();
        System.out.println("max:" + max);
        int min = list.stream().min(Comparator.naturalOrder()).get();
        System.out.println("min:" + min);
    }

    //9) How do you merge two unsorted arrays into single sorted array using Java 8 streams?
    public static void merge() {
        List<Integer> alist = Arrays.asList(1, 2, 3, 84, 5);
        List<Integer> blist = Arrays.asList(5, 6, 7, 8, 9);
        IntStream.concat(alist.stream().mapToInt(Integer::intValue), blist.stream().mapToInt(Integer::intValue)).sorted().forEach(System.out::println);
        int[] a = new int[]{1, 2, 3};
        int[] b = new int[]{4, 5, 6};
        int[] c = IntStream.concat(Arrays.stream(a), Arrays.stream(b)).toArray();
        System.out.println(Arrays.toString(c));

    }

    //10) How do you merge two unsorted arrays into single sorted array without duplicates?
    public static void singlearray() {
        int[] a = new int[]{3, 4, 2, 1};
        int[] b = new int[]{7, 5, 6, 8, 1};
        int c[] = IntStream.concat(Arrays.stream(a), Arrays.stream(b)).sorted().distinct().toArray();
        System.out.println(Arrays.toString(c));
    }

    //11) How do you get three maximum numbers and three minimum numbers from the given list of integers?
    public static void maxmin3() {
        List<Integer> alist = Arrays.asList(1, 5, 3, 4, 7, 6, 9, 8);
        System.out.println("Min3");
        alist.stream().sorted().limit(3).forEach(System.out::println);
        System.out.println("Max3");
        alist.stream().sorted(Comparator.reverseOrder()).limit(3).forEach(System.out::println);
    }

    //12) Java 8 program to check if two strings are anagrams or not?
    public static void anagram() {
        String a = "racecar";
        String b = "carrace";
        String s1 = Stream.of(a.split("")).map(s -> s.toUpperCase()).sorted().collect(Collectors.joining());
        String s2 = Stream.of(b.split("")).map(s -> s.toUpperCase()).sorted().collect(Collectors.joining());
        if (s1.equals(s2)) {
            System.out.println("Anagram");
        } else {
            System.out.println("Not Anagram");
        }
    }

    //13) Find sum of all digits of a number in Java 8?
    public static void sumDigits() {
        Integer number = 1234;
        Integer sum = Stream.of(String.valueOf(number).split("")).collect(Collectors.summingInt(Integer::parseInt));
        System.out.println("sum:" + sum);
    }

    //14) Find second largest number in an integer array?
    public static void largest() {
        List<Integer> a = Arrays.asList(1, 7, 8, 9);
        Integer largest = a.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        System.out.println("second largest:" + largest);
    }
    //15) Given a list of strings, sort them according to increasing order of their length?

    public static void lengthOrder() {
        List<String> strList = Arrays.asList("Sriram", "Sahasra", "Santhosh", "Rohini");
        strList.stream().sorted(Comparator.comparing(String::length)).forEach(System.out::println);
    }

// 16) Given an integer array, find sum and average of all elements?

    public static void sumavg() {
        int[] c = new int[]{1, 2, 3, 4};
        Integer sum = Arrays.stream(c).sum();
        Double avg = Arrays.stream(c).average().getAsDouble();
        System.out.println("sum" + sum + "avg" + avg);
    }
    //17) How do you find common elements between two arrays?

    public static void common() {
        List<Integer> a = Arrays.asList(1, 2, 3);
        List<Integer> b = Arrays.asList(2, 3, 4);
        a.stream().filter(b::contains).forEach(System.out::println);
    }

    //18) Reverse each word of a string using Java 8 streams?
    public static void reverse() {
        String s = "Reverse each word";

        String r = Stream.of(s.split(" ")).map(w -> new StringBuffer(w).reverse()).collect(Collectors.joining(" "));
        System.out.println("String reverse:" + r);
    }

    //19) How do you find sum of first 10 natural numbers?
    public static void sum10() {
        int sum = IntStream.rangeClosed(1, 10).sum();
        System.out.println("Sum" + sum);
    }

    //20) Reverse an integer array
    public static void revint() {
        int[] a = new int[]{1, 2, 3, 4};
        int[] reversedString = IntStream.rangeClosed(1, a.length).map(i -> a[a.length - i]).toArray();
        System.out.println(Arrays.toString(reversedString));
    }
// 21) Print first 10 even numbers
    public static void first10Even(){
        IntStream.rangeClosed(1,10).map(n->n*2).forEach(System.out::println);
    }
//22) How do you find the most repeated element in an array?
    public static void repeatArray(){
        List<String> a = Arrays.asList("1","1","1","2","2","3","3","3","3");
        Map<String, Long> map = a.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map.Entry<String, Long> e=map.entrySet().stream().max(Map.Entry.comparingByValue()).get();
        System.out.println("Most key"+ e.getKey()+ "Most Value"+ e.getValue());
    }

//23) Palindrome program using Java 8 streams
 public static void palindrome(){
    String s="ROTOR";
   boolean isPalindrome=IntStream.range(0,s.length()/2).noneMatch(i->s.charAt(i)!=s.charAt(s.length()-i-1));
   if(isPalindrome){
       System.out.println("it is palidrome");
   }else{
       System.out.println("it is not a palidrome");
   }
 }

 //24) Given a list of strings, find out those strings which start with a number?
    public static void numStr(){
        List<String> s=Arrays.asList("1abce", "def", "2def", "kjdf", "3dj");
        s.stream().filter(str-> Character.isDigit(str.charAt(0))).forEach(System.out::println);
    }
    //25) How do you extract duplicate elements from an array?
    public static void duplicates(){
        List<Integer> a= Arrays.asList(1,1,2,2,3,3,3,4);
        Set unique=new HashSet();
        Set ans=a.stream().filter(i->!unique.add(i)).collect(Collectors.toSet());
        System.out.println(ans);
    }

    //26) Print duplicate characters in a string?
    public static void dupchars(){
        String s ="abacdaabb";
        Set unique= new HashSet();
        Set ans=Stream.of(s.split("")).filter(c->!unique.add(c)).collect(Collectors.toSet());
        System.out.println(ans);
    }

//27) Find first repeated character in a string?
    public static void repeatFirstChar(){
        String s ="abcadf";
        Map<String, Long> charcterCountMap=Stream.of(s.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        String s1 = charcterCountMap.entrySet().stream().filter(str -> str.getValue() > 1).map(e -> e.getKey()).findFirst().get();
        System.out.println("s"+s1);
    }
    //28) Find first non-repeated character in a string?
    public static void nonRepeatChar(){
        String s="aabbcdef";
        Map<String, Long> charcterCountMap= Stream.of(s.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        String s2=charcterCountMap.entrySet().stream().filter(f->f.getValue()==1).map(e->e.getKey()).findFirst().get();
        System.out.println("s:"+s2);
    }
//29) Fibonacci series
    public static void fibonacci(){
        Stream.iterate(new int[] {0,1}, f-> new int[]{ f[1], f[0]+f[1]}).
                limit(10).map(f->f[0]).forEach(i->System.out.println(i));
    }

   //30) First 10 odd numbers
    public static void odd10(){
       // IntStream.rangeClosed(0,9).map(i->i*2+1).forEach(System.out::println);
        Stream.iterate(new int[] {1,3}, f->new int[]{f[1],f[1]+2}).limit(10).
                map(f->f[0]).forEach(System.out::println);
    }
    //31) How do you get last element of an array?
    public static void last(){
        List<String> a =Arrays.asList("1","2","3","4");
        String b=a.stream().skip(a.size()-1).findFirst().get();
        System.out.println(b.toString());
    }
    //32) Find the age of a person in years if the birthday has given?
    public static void age(){
        LocalDate birthDay = LocalDate.of(1980, 12, 4);
        LocalDate today=LocalDate.now();
        System.out.println(ChronoUnit.YEARS.between(birthDay,today));
    }
}
