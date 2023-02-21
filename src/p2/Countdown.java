package p2;
import java.util.Scanner;
import utils.UserInput;

public class Countdown {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N;

        N = UserInput.inputIntPositive(sc, "Input N:");
        sc.close();

        for (int i = N; i >= 0; i--) {
            if (i % 10 == 0) {
                System.out.printf("\n%d,", i);
            } else if (i % 10 == 1) {
                System.out.printf("%d", i);
            } else {
                System.out.printf("%d,", i);
            }
        }
    }
}
