/* Java program that mimics the following Python script:
 *
 * tempC = float(input("Celsius? "))
 * tempF = 1.8 * tempC + 32
 * print(tempC, "C", "=", tempF, "F")
 * print("THE END")
 */

package Homework; // Ignore this, folder structure related
import java.util.Scanner;

public class Temperature {
    // Create a Scanner to parse standard input
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Get the temperature in Celsius
        System.out.print("Celsius? ");
        float tempC = Float.parseFloat(sc.nextLine());
        
        double tempF = 1.8 * tempC + 32;
        
        System.out.printf("%.2f C = %.2f F\n", tempC, tempF);
        System.out.println("THE END");
    }
}