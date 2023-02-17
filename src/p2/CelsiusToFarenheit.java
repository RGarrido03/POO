package p2;
import java.util.Scanner;

public class CelsiusToFarenheit {
    public static void main(String[] args) {
        double celsius, farenheit;
        Scanner sc = new Scanner(System.in);

        System.out.print("Input the temperature in Celsius: ");
        celsius = sc.nextDouble();
        sc.close();

        farenheit = 1.8 * celsius + 32;
        System.out.printf("%fºC = %fºF\n", celsius, farenheit);
    }
}
