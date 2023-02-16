/* This program updates an account balance, according to the table below:
 *    Balance        Interest Rate    Charge
 *  > $100,000.00    2.75 %           $  0.00
 *  > $25,000.00     2.00 %           $  0.00
 *  > $10,000.00     1.00 %           $  0.00
 * >= $0.00          0.00 %           $  0.00
 *  < $0.00          0.00 %           $ 25.00
 * and prints out the new balance.
 */

package TP1.Homework;
import java.util.Scanner;

public class BankInterest
{
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {
        // Define constants
        final double HI_RATE = 2.75;
        final double MD_RATE = 2.00;
        final double LO_RATE = 1.00;
        final double ZERO_RATE = 0.00;
        final double DEB_CHG = -25.00;

        final double HI_LIMIT = 100000.00;
        final double MD_LIMIT = 25000.00;
        final double LO_LIMIT = 10000.00;
        final double ZERO_LIMIT = 0.00;

        // Print prompt to enter a current balence
        System.out.print("Enter current balance: ");

        // Read balance
        double balance = sc.nextDouble();

        // Determine interest rate (or charge) based on current balance to compute new balance
        double newBalance;
        if (balance > HI_LIMIT) {
            newBalance = balance * (1 + HI_RATE/100);
        } else if (balance > MD_LIMIT) {
            newBalance = balance * (1 + MD_RATE/100);
        } else if (balance > LO_LIMIT) {
            newBalance = balance * (1 + LO_RATE/100);
        } else if (balance >= ZERO_LIMIT) {
            newBalance = balance * (1 + ZERO_RATE/100);
        } else {
            newBalance = balance + DEB_CHG;
        }

        System.out.printf("%.2f\n", newBalance);
    }
}