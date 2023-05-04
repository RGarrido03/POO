package p10;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Ex4 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new FileReader("resources/lyrics.txt"));
        Set<String> twoCharWords = new HashSet<>();

        while (input.hasNext()) {
            String word = input.next();
            if (word.length() > 2 && word.matches("\\w*")) {
                twoCharWords.add(word);
            }
        }

        System.out.println(twoCharWords);

        for (String word : twoCharWords) {
            if (word.endsWith("s")) {
                System.out.println(word);
            }
        }
    }
}
