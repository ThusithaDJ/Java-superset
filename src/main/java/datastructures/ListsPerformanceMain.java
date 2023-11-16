package datastructures;

import org.apache.log4j.Logger;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Vector;

public class ListsPerformanceMain {

    private static final Random random = new Random();
    private static final Logger logger = Logger.getLogger(ListsPerformanceMain.class);

    private static final Map<String, String> actionSummary = new HashMap<>();
    public static void main(String[] args) {

        int count = 100;

        List<String> randomRemoveArrayList = addToAnArrayList(count);
        List<String> sequantialRemoveArrayList = new ArrayList<>(randomRemoveArrayList);

        List<String> randomRemoveLinkedList = addToAnLinkedList(count);
        List<String> sequantialRemoveLinkedList = new LinkedList<>(randomRemoveLinkedList);

        List<String> randomRemoveVector = addToAVector(count);

        findValueFromArrayList(randomRemoveArrayList);
        findValueFromLinkedList(randomRemoveLinkedList);

        randomlyEmptyTheList(randomRemoveArrayList);
        sequentiallyEmptyTheList(sequantialRemoveArrayList);

        randomlyEmptyTheList(randomRemoveLinkedList);
        sequentiallyEmptyTheList(sequantialRemoveLinkedList);

        randomlyEmptyTheList(randomRemoveVector);
        sequentiallyEmptyTheList(randomRemoveVector);


        actionSummary.forEach((k, v) -> {
            System.out.println( "| "+k +" \t | "+v +" |");
        });
    }

    private static List<String> addToAVector(int count) {
        return getStringList(count, new Vector<>());
    }

    private static void findValueFromLinkedList(List<String> randomRemoveLinkedList) {
        String s;
        Instant start;
        randomRemoveLinkedList.add("TheLastWordForLinkedList");
        start = Instant.now();
        s = randomRemoveLinkedList.stream().filter(v -> v.equals("TheLastWordForLinkedList")).findFirst().orElse("Didn't find");

        actionSummary.put("Find\t\t\t\t\t| "+randomRemoveLinkedList.getClass().getName().replace("java.util.", ""), "\t | "+Duration.between(start, Instant.now()));
    }

    private static void findValueFromArrayList(List<String> randomRemoveArrayList) {
        randomRemoveArrayList.add("TheLastWordForArrayList");
        Instant start = Instant.now();
        String s = randomRemoveArrayList.stream().filter(v -> v.equals("TheLastWordForArrayList")).findFirst().orElse("Didn't find");
        actionSummary.put("Find\t\t\t\t\t| "+randomRemoveArrayList.getClass().getName().replace("java.util.", ""), "\t | "+Duration.between(start, Instant.now()));
    }

    public static List<String> addToAnArrayList(int count) {
        return getStringList(count, new ArrayList<>());
    }

    public static List<String> addToAnLinkedList(int count) {
        return getStringList(count, new LinkedList<>());
    }

    private static List<String> getStringList(int count, List<String> stringList) {
        Instant start = Instant.now();
        for (int step = 0; step <= count; step++) {
            stringList.add(generateRandomWord());
        }

        actionSummary.put("Random Add\t\t\t| "+stringList.getClass().getName().replace("java.util.", ""), "\t | "+ Duration.between(start, Instant.now()));
        return stringList;
    }

    private static void randomlyEmptyTheList(List<String> stringList) {
        Instant start = Instant.now();
        int listSize = stringList.size();
        while (listSize > 0) {
            int index = random.nextInt(listSize);
            stringList.remove(index);
            listSize = stringList.size();
        }

        String className = stringList.getClass().getName().replace("java.util.", "");
        className = className.equals("Vector") ? "Vector\t" :className;

        actionSummary.put("Random remove\t\t\t| "+className, "\t | "+Duration.between(start, Instant.now()));
    }

    private static void sequentiallyEmptyTheList(List<String> stringList) {
        Instant start = Instant.now();
        int listSize = stringList.size();
        while (listSize > 0) {
            stringList.remove(0);
            listSize = stringList.size();
        }

        actionSummary.put("Sequentially remove\t| "+stringList.getClass().getName().replace("java.util.", ""), "\t | "+Duration.between(start, Instant.now()));
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
