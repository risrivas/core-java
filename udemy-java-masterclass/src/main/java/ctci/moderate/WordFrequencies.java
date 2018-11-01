package ctci.moderate;

import java.util.HashMap;
import java.util.Map;

public class WordFrequencies {

    private static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        String book = "There was a nice story about Mowgli and Sher Khan. Both use to blah blah blah.\n" +
                "Then there came a twist to the story. Blah Blah Blah";

        System.out.println(frequencyCount("a", book));
        System.out.println(frequencyCount("a", book));
        System.out.println(frequencyCount("Blah", book));
    }

    private static int frequencyCount(String word, String book) {
//        String temp = word.trim().toLowerCase();
        if (!map.containsKey(word)) {
            for (String words :
                    book.split("\\s+")) {
                map.merge(words, 1, Integer::sum);
            }
        }

        return map.get(word);
    }
}