package datastructures;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CollectionPerformanceMain {

    private static final Random random = new Random();
    private static final Logger logger = Logger.getLogger(CollectionPerformanceMain.class.getName());

    public static void main(String[] args) {

        int count = 1000000;

        List<String> stringList = addToAnArrayList(count);
        emptyTheList(stringList);

        stringList = addToAnLinkedList(count);
        emptyTheList(stringList);

    }

    public static List<String> addToAnArrayList(int count) {
        logger.log(Level.INFO,"Starting to generate random words and adding to a list: {0}",  count);
        return getStrings(count, new ArrayList<>());
    }

    public static List<String> addToAnLinkedList(int count) {
        logger.log(Level.INFO,"Starting to generate random words and adding to a list: {0}",  count);
        return getStrings(count, new LinkedList<>());
    }

    private static List<String> getStrings(int count, List<String> stringList) {
        Instant start = Instant.now();
        for (int step = 0; step <= count; step++) {
            stringList.add(generateRandomWord());
        }

        Object[] ob = {count, Duration.between(start, Instant.now())};
        logger.log(Level.INFO, "Completed generating random words and adding to a list: {0} Time: {1}", ob);

        return stringList;
    }

    private static void emptyTheList(List<String> stringList) {
        logger.log(Level.INFO, "Started to empty the list: {0}", stringList.size());

        Instant start = Instant.now();
        int listSize = stringList.size();
        while (listSize > 0) {
            int index = random.nextInt(listSize);
            stringList.remove(index);
            listSize = stringList.size();
        }

        Object[] ob = {stringList.size(), Duration.between(start, Instant.now())};
        logger.log(Level.INFO, "Completed emptying the list: {0} Time: {1}", ob);
    }

    private static String generateRandomWord() {
        String characters = "abcdefghijklmnopqrstuvwxyz";

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
