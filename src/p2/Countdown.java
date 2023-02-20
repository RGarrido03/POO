package p2;
import java.util.Scanner;

public class Countdown {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N;

        System.out.print("Input N: ");
        do {
            N = Integer.parseInt(sc.nextLine());
            if (N <= 0) {
                System.out.print("The number you provided isn't positive. Input a new one: ");
            }
        } while (N <= 0);
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
