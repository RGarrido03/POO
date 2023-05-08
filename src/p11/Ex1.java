package p11;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Ex1 {
    public static void main(String[] args) throws FileNotFoundException {
        Map<String, Map<String, Integer>> wordsMap = new TreeMap<>();

        Scanner input = new Scanner(new FileReader("resources/major.txt"));
        input.useDelimiter("[ \\r\\t\\n.,:'‘’;?!\\-*{}=+&/()\\[\\]”“\"]+");

        String previous = input.hasNext() ? input.next().toLowerCase() : "";

        while (input.hasNext()) {
            String word = input.next().toLowerCase();

            if (word.length() >= 3) {
                if (wordsMap.containsKey(previous)) {
                    if (wordsMap.get(previous).containsKey(word)) {
                        int i = wordsMap.get(previous).get(word);
                        wordsMap.get(previous).put(word, ++i);
                    } else {
                        wordsMap.get(previous).put(word, 1);
                    }
                } else {
                    wordsMap.put(previous, new TreeMap<>());
                    wordsMap.get(previous).put(word, 1);
                }
                previous = word;
            }
        }

        for (Map.Entry<String, Map<String, Integer>> entry : wordsMap.entrySet()) {
            System.out.println(entry);
        }
    }
}
