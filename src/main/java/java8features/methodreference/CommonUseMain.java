package java8features.methodreference;

import java.util.Arrays;
import java.util.List;

public class CommonUseMain {

    public static void main(String[] args) {

        List<String> messages = Arrays.asList("hello", "baeldung", "readers!");
        messages.forEach(System.out::println);

        messages.forEach(MyStringUtil::capitalize);

    }

    class MyStringUtil {

        public static void capitalize(String word) {
            System.out.println(word.toUpperCase());
        }
    }
}
