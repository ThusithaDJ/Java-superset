package datastructures;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CollectionPerformanceMain {

    public static void main(String[] args) {

        int count = 1000000;

        List<String> stringList = addToAnArrayList(count);
        emptyTheList(stringList);

    }

    public static List<String> addToAnArrayList(int count) {
        System.out.println("Starting to generate random words and adding to a list:" + count);

        List<String> stringList = new ArrayList<>();
        Instant start = Instant.now();
        for (int step = 0; step <= count; step++) {
            stringList.add(generateRandomWord());
        }

        System.out.println("Completed generating random words and adding to a list:" + count +" Time: "+ Duration.between(start, Instant.now()));

        return stringList;
    }

    private static void emptyTheList(List<String> stringList) {
        System.out.println("Started to empty the list: " + stringList.size());

        Instant start = Instant.now();
        int listSize = stringList.size();
        while (listSize > 0) {
            int index = new Random().nextInt(listSize);
            stringList.remove(index);
            listSize = stringList.size();
        }

        System.out.println("Completed emptying the list: " + stringList.size() +" Time: " + Duration.between(start, Instant.now()));
    }

    private static String generateRandomWord() {
        String characters = "abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();

        // Generate a random word length between 1 and 10
        int wordLength = random.nextInt(10) + 1;

        // Generate the random word
        StringBuilder randomWord = new StringBuilder();
        for (int i = 0; i < wordLength; i++) {
            // Choose a random character from the characters string
            char randomChar = characters.charAt(random.nextInt(characters.length()));

            // Append the character to the random word
            randomWord.append(randomChar);
        }

        return randomWord.toString();
    }
}
