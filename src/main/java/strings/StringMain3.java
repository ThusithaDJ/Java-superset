package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringMain3 {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("code");
        words.add("odec");
        words.add("dec");
        words.add("dec");

        List<String> result = new ArrayList<>();
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            byte []txts = word.getBytes();
            Arrays.sort(txts);
            for (int j = i; j < words.size() -1; j++) {
                String word2 = words.get(j);
                byte []txt2 = word2.getBytes();
                Arrays.sort(txts);
                if (String.valueOf(txts).equals(String.valueOf(txt2))) {
                    result.add(word);
                    break;
                }
            }
        }

        for (String t : result) {
            System.out.println(t);
        }
    }
}
