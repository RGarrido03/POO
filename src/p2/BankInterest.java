package p2;
import java.util.Scanner;

public class BankInterest {
    public static void main(String[] args) {
        double balance, taxRate;
        Scanner sc = new Scanner(System.in);

        System.out.print("Input the initial amount of money: ");
        balance = Double.parseDouble(sc.nextLine());

        System.out.print("Input the interest rate, in %: ");
        taxRate = Double.parseDouble(sc.nextLine());

        sc.close();

        balance = balanceCalc(balance, taxRate, 3);

        System.out.printf("After 3 months, you'll have %f€.\n", balance);
    }

    public static double balanceCalc(double balance, double taxRate, int months) {
        for (int i = 0; i < months; i++) {
            balance = balance * (1 + taxRate/100);
        }
        return balance;
    }
}
