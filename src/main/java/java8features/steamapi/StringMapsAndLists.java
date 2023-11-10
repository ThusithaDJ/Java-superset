package java8features.steamapi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class StringMapsAndLists {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Bimal", "Amal", "Sunimal", "Anil", "Amal");

        names.stream().forEach(n -> System.out.print(n+", "));
        System.out.println();

        //TODO: Sort ascending order and print
        names = names.stream().sorted().collect(Collectors.toList());
        names.stream().forEach(n -> System.out.print(n+", "));
        System.out.println();

        //TODO: Sort descending order and print
        names = Arrays.asList("Bimal", "Amal", "Sunimal", "Anil", "Amal");
        names = names.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        names.stream().forEach(n -> System.out.print(n+", "));
        System.out.println();

        //TODO: Remove duplicates sort descending order and print
        names = Arrays.asList("Bimal", "Amal", "Sunimal", "Anil", "Amal");
        names = names.stream().collect(Collectors.toSet()).stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        names.stream().forEach(n -> System.out.print(n+", "));
        System.out.println();

        //TODO: Remove duplicates sort descending order and print
        names = Arrays.asList("Bimal", "Amal", "Sunimal", "Anil", "Amal");
        LinkedList<String> withoutDup = new LinkedList<>();
        names.stream().sorted(Comparator.reverseOrder()).forEach(n -> {
            if (withoutDup.size() == 0 || !withoutDup.peekLast().equals(n)) {
                withoutDup.push(n);
            }
        });
        withoutDup.forEach(n -> System.out.print(n +","));

    }

}
