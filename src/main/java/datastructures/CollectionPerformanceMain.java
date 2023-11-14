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

        int count = 500000;

        List<String> randomRemoveArrayList = addToAnArrayList(count);
        List<String> sequantialRemoveArrayList = new ArrayList<>(randomRemoveArrayList);

        List<String> randomRemoveLinkedList = addToAnLinkedList(count);
        List<String> sequantialRemoveLinkedList = new LinkedList<>(randomRemoveLinkedList);

        findValueFromArrayList(randomRemoveArrayList);
        findValueFromLinkedList(randomRemoveLinkedList);

        randomlyEmptyTheList(randomRemoveArrayList);
        sequantiallyEmptyTheList(sequantialRemoveArrayList);

        randomlyEmptyTheList(randomRemoveLinkedList);
        sequantiallyEmptyTheList(sequantialRemoveLinkedList);

    }

    private static void findValueFromLinkedList(List<String> randomRemoveLinkedList) {
        String s;
        Instant start;
        randomRemoveLinkedList.add("TheLastWordForLinkedList");
        start = Instant.now();
        s = randomRemoveLinkedList.stream().filter(v -> v.equals("TheLastWordForLinkedList")).findFirst().orElse("Didn't find");
        logger.log(Level.INFO, "????????????????????????????????? Found the value from LinkedList {0}. Time {1}", List.of(s, Duration.between(start, Instant.now())).toArray());
    }

    private static void findValueFromArrayList(List<String> randomRemoveArrayList) {
        randomRemoveArrayList.add("TheLastWordForArrayList");
        Instant start = Instant.now();
        String s = randomRemoveArrayList.stream().filter(v -> v.equals("TheLastWordForArrayList")).findFirst().orElse("Didn't find");
        logger.log(Level.INFO, "????????????????????????????????? Found the value from ArrayList {0}. Time {1}", List.of(s, Duration.between(start, Instant.now())).toArray());
    }

    public static List<String> addToAnArrayList(int count) {
        logger.log(Level.INFO,"Starting to generate random words and adding to {0}: {1}", List.of("an ArrayList", count).toArray());
        return getStringList(count, new ArrayList<>());
    }

    public static List<String> addToAnLinkedList(int count) {
        logger.log(Level.INFO,"Starting to generate random words and adding to a {0} list: {1}",  List.of("a LinkedList", count).toArray());
        return getStringList(count, new LinkedList<>());
    }

    private static List<String> getStringList(int count, List<String> stringList) {
        Instant start = Instant.now();
        for (int step = 0; step <= count; step++) {
            stringList.add(generateRandomWord());
        }


        logger.log(Level.INFO, "+++++++++++++++++++++++++++++++ Completed generating random words and adding to a {0}: {1} Time: {2}", List.of(stringList.getClass().getName(), count, Duration.between(start, Instant.now())).toArray());

        return stringList;
    }

    private static void randomlyEmptyTheList(List<String> stringList) {
        logger.log(Level.INFO, "Started to empty the {0} : {1}", List.of(stringList.getClass().getName(), stringList.size()).toArray());

        Instant start = Instant.now();
        int listSize = stringList.size();
        while (listSize > 0) {
            int index = random.nextInt(listSize);
            stringList.remove(index);
            listSize = stringList.size();
        }

        logger.log(Level.INFO, "-------------------------------- Completed emptying the {0}: {1} Time: {2}", List.of(stringList.getClass().getName(), stringList.size(), Duration.between(start, Instant.now())).toArray());
    }

    private static void sequantiallyEmptyTheList(List<String> stringList) {
        logger.log(Level.INFO, "Started to empty the {0} : {1}", List.of(stringList.getClass().getName(), stringList.size()).toArray());

        Instant start = Instant.now();
        int listSize = stringList.size();
        while (listSize > 0) {
            stringList.remove(0);
            listSize = stringList.size();
        }

        logger.log(Level.INFO, "-------------------------------- Completed emptying the {0}: {1} Time: {2}", List.of(stringList.getClass().getName(), stringList.size(), Duration.between(start, Instant.now())).toArray());

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
