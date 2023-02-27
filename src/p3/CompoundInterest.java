package p3;

import java.util.Scanner;
import utils.UserInput;

public class CompoundInterest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double balance = UserInput.inputDoublePositiveMultiple(sc, "Input the initial amount of money:", 1000);
        double tax = UserInput.inputDoubleRange(sc, "Input the monthly interest rate, between 0% and 5%:", 0, 5, true, false);

        for (int i = 0; i < 12; i++) {
            balance *= (1 + tax/100);
            System.out.printf("Balance in month %2d: %.2f€\n", i+1, balance);
        }
    }
}
