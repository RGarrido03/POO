package p2;
import java.util.Scanner;
import utils.UserInput;

public class CelsiusToFarenheit {
    public static void main(String[] args) {
        double celsius, farenheit;
        Scanner sc = new Scanner(System.in);

        celsius = UserInput.inputDouble(sc, "Input the temperature in Celsius: ");
        sc.close();

        farenheit = 1.8 * celsius + 32;
        System.out.printf("%fºC = %fºF\n", celsius, farenheit);
    }
}
