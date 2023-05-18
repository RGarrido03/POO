package p12;

import java.io.File;
import java.util.*;

public class Ex2 {
    public static void main(String[] args) {
        Map<Character, Map<String, Integer>> wordsMap = new TreeMap<>();
        Scanner input = null;

        try {
            input = new Scanner(new File("resources/A_cidade_e_as_serras.txt"));
        } catch (Exception e) {
            System.out.println("File not found");
            System.exit(1);
        }

        input.useDelimiter("[ \\r\\t\\n.,:'‘’;?!_«»^#0-9\\-*{}=+&/()\\[\\]”“\"]+");

        while(input.hasNext()) {
            String word = input.next().toLowerCase();

            if (word.length() > 3) {
                char wordInitial = word.charAt(0);

                if (wordsMap.containsKey(wordInitial)) {
                    if (wordsMap.get(wordInitial).containsKey(word)) {
                        int i = wordsMap.get(wordInitial).get(word);
                        wordsMap.get(wordInitial).put(word, ++i);
                    } else {
                        wordsMap.get(wordInitial).put(word, 1);
                    }
                } else {
                    wordsMap.put(wordInitial, new TreeMap<>());
                    wordsMap.get(wordInitial).put(word, 1);
                }
            }
        }

        for (Map.Entry<Character, Map<String, Integer>> entry : wordsMap.entrySet()) {
            System.out.println(entry);
        }
    }
}
