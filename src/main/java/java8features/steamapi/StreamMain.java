package java8features.steamapi;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamMain {

    public static void main(String[] args) {

        int arr[] = {4,33,534,322,64,53, 33, 4, 66, 4};

        IntStream.of(arr).forEach(value -> System.out.printf("%d ", value));
        System.out.println();

        IntStream.of(arr).distinct().forEach(value -> System.out.printf("%d ", value));
        System.out.println();

        IntStream.of(arr).filter( num -> num > 50).forEach(val -> System.out.printf("%d ", val));
        System.out.println();

        List<Integer> collect = IntStream.of(arr).filter(num -> num > 50).boxed().collect(Collectors.toList());
        System.out.println(collect);


//        Find duplicates in an int array
        Set<Integer> removalSet = new HashSet<>();
        Set<Integer> collect1 = IntStream.of(arr).filter(num -> !removalSet.add(num)).boxed().collect(Collectors.toSet());
        collect1.forEach(val -> System.out.printf("%d ", val));
        System.out.println();


        Set<String> stringSet = new HashSet<>();
        stringSet.add("cde");
        stringSet.add("def");
        stringSet.add("abc");
        stringSet.add("cde");
        stringSet.add("klm");
        stringSet.add("abc");

        System.out.println("==================== string duplicates ===================");
        stringSet.forEach(value -> System.out.println(value));

        Set<Integer> numberSet = new HashSet<>();
        numberSet.add(43);
        numberSet.add(1);
        numberSet.add(55);
        numberSet.add(54);
        numberSet.add(5);
        numberSet.add(43);
        numberSet.add(3);

        System.out.println("==================== HashSet numbers ===================");
        numberSet.forEach(number -> System.out.printf("%d, ", number));
        System.out.println();

        numberSet = new LinkedHashSet<>();
        numberSet.add(43);
        numberSet.add(1);
        numberSet.add(55);
        numberSet.add(54);
        numberSet.add(5);
        numberSet.add(43);
        numberSet.add(3);

        System.out.println("==================== LinkedHashSet numbers ===================");
        numberSet.forEach(number -> System.out.printf("%d, ", number));
        System.out.println();

        numberSet = new TreeSet<>();
        numberSet.add(43);
        numberSet.add(1);
        numberSet.add(55);
        numberSet.add(54);
        numberSet.add(5);
        numberSet.add(43);
        numberSet.add(3);

        System.out.println("==================== TreeSet numbers ===================");
        numberSet.forEach(number -> System.out.printf("%d, ", number));
        System.out.println();


        numberSet.forEach(number -> System.out.printf("%d, ", number));

    }

}
