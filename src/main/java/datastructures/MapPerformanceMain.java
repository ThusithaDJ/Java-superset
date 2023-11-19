package datastructures;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MapPerformanceMain {
    private static final Random random = new Random();
    private static final List<String> actionSummary = new ArrayList<>();

    public static void main(String[] args) {

        int count = 100000;

        Map<String, String> hashMap = new HashMap<>();

        getStringMap(count, hashMap);
        randomlyEmptyTheMap(hashMap);

        count = 10000000;
        hashMap = new HashMap<>();

        getStringMap(count, hashMap);
        randomlyEmptyTheMap(hashMap);

        Map<String, String> hashtable = new Hashtable<>();

        count = 10000000;
        getStringMap(count, hashtable);
        randomlyEmptyTheMap(hashtable);

        actionSummary.forEach(v -> System.out.println( "| "+v +" |"));
    }

    private static Map<String, String> getStringMap(int count, Map<String, String> stringMap) {
        Instant start = Instant.now();
        for (int step = 0; step <= count; step++) {
            String word = generateRandomWord();
            stringMap.put(word, word);
        }

        actionSummary.add("Random Add\t\t\t| "+stringMap.getClass().getName().replace("java.util.", "")+ "\t | "+ Duration.between(start, Instant.now()));
        return stringMap;
    }

    private static void randomlyEmptyTheMap(Map<String, String> stringMap) {
        Instant start = Instant.now();
        stringMap.clear();

        String className = stringMap.getClass().getName().replace("java.util.", "");
        className = className.equals("Vector") ? "Vector\t" :className;

        actionSummary.add("Random remove\t\t\t| "+className + "| \t | "+Duration.between(start, Instant.now()));
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

