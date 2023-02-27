package p3;

import java.util.Scanner;
import utils.UserInput;
import utils.Maths;

public class PrimeSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = UserInput.inputIntPositive(sc, "Input a positive integer:");
        int sum = 0;

        for (int i = 2; i <= num; i++) {
            if (Maths.isPrime(i)) {
                sum += i;
            }
        }

        System.out.printf("Sum of prime numbers until %d is %d.\n", num, sum);
    }
}
