package p3;

import java.util.Random;
import java.util.Scanner;
import utils.UserInput;

public class HighLow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int num = rand.nextInt(101);
        int chosen;
        System.out.println("Random: " + num);
        System.out.print("Start by inputting a number between 0 and 100: ");

        do {
            chosen = UserInput.inputIntRange(sc, null, 0, 100, false, false);
            if (chosen == num) {break;}
            else if (chosen > num) {
                System.out.printf("%d is higher than the guess number.", chosen);
            } else {
                System.out.printf("%d is lower than the guess number.", chosen);
            }

            System.out.print(" Input a new one: ");
        } while(chosen != num);

        String prompt = UserInput.inputString(sc, "You did it! The randomized number was " + num + ". Do you wanna continue? [Yes/no]");
        if (prompt.equalsIgnoreCase("y") || prompt.equalsIgnoreCase("yes")) {
            main(null);
        }
    }
}
