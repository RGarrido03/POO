package p2;
import java.util.Scanner;

public class KmsToMiles {
    public static void main(String[] args) {
        double kms, miles;
        Scanner sc = new Scanner(System.in);

        System.out.print("Input the distance (in kilometers): ");
        kms = sc.nextDouble();
        miles = kms / 1.609;

        System.out.printf("%f kilometers = %f miles.\n", kms, miles);
        sc.close();
    }
}
