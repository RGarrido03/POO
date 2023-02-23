package tp2;
import java.util.Scanner;
import utils.UserInput;

public class Words {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = UserInput.inputString(sc, "Input the word you wanna exchange the first and last characters:");
        sc.close();

        int len = word.length();
        String new_word = word.substring(len - 1, len) + word.substring(1, len - 1) + word.substring(0, 1);
        System.out.println(new_word);
    }
}