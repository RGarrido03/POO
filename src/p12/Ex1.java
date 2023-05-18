package p12;

import java.io.File;
import java.util.*;

public class Ex1 {
    public static void main(String[] args) {
        Scanner input = null;
        Set<String> wordSet = new TreeSet<>();
        List<String> wordList = new ArrayList<>();

        try {
            input = new Scanner(new File("resources/lyrics.txt"));
        } catch (Exception e) {
            System.out.println("File not found");
            System.exit(1);
        }

        input.useDelimiter("[ \\r\\t\\n.,:'‘’;?!\\-*{}=+&/()\\[\\]”“\"]+");

        while(input.hasNext()) {
            String temp = input.next();
            wordSet.add(temp);
            wordList.add(temp);
        }

        System.out.printf("""
            Número total de palavras: %d
            Número de diferentes palavras: %d
            """, wordList.size(), wordSet.size());
    }
}
