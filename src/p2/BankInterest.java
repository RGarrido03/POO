package p2;
import java.util.Scanner;
import utils.UserInput;

public class BankInterest {
    public static void main(String[] args) {
        double balance, taxRate;
        Scanner sc = new Scanner(System.in);

        balance = UserInput.inputDoubleRangeMin(sc, "Input the initial amount of money:", 0, false);
        taxRate = UserInput.inputDoubleRange(sc, "Input the interest rate, in %:", 0, 100, true, false);
        sc.close();

        balance = balanceCalc(balance, taxRate, 3);

        System.out.printf("After 3 months, you'll have %.2f€.\n", balance);
    }

    public static double balanceCalc(double balance, double taxRate, int months) {
        for (int i = 0; i < months; i++) {
            balance = balance * (1 + taxRate/100);
        }
        return balance;
    }
}
