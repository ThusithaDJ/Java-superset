package java8features.steamapi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapReduceMain {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,3,4,5,3,2,5);

        int total = 0;
        for (Integer i : numbers) {
            total += i * 2;
        }

        System.out.println("Total is : " + total);


        Integer reduce = numbers.stream()
                                .map(e -> e * 2)
                                // e -> element of the stream
                                .reduce(0, (c, e) -> c + e);
                                // 0 -> is the initial value(just like total variable)
                                // e -> is element after the calculation in map()/if any
                                // c -> is like current value. first time it's value 0, next time it's c+e
        System.out.println("Total value from stream and MapReduce: "+reduce);

        List l = Arrays.asList(2,3,1,3).stream().filter((num) -> num > 1).collect(Collectors.toList());
        l.forEach(num -> System.out.print(num));
    }
}
