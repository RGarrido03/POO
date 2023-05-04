package p10;

import java.util.ArrayList;
import java.util.HashMap;

public class Ex3 {
    public static void main(String[] args) {
        HashMap<Character, ArrayList<Integer>> letterHashMap = new HashMap<>();
        String str = "Hello World";

        for (int i = 0; i < str.length(); i++) {
            char letter = str.charAt(i);
            if (letterHashMap.containsKey(letter)) {
                letterHashMap.get(letter).add(i);
            } else {
                letterHashMap.put(letter, new ArrayList<>());
                letterHashMap.get(letter).add(i);
            }
        }

        System.out.println(letterHashMap);
    }
}
