package p2;
import java.util.Scanner;
import utils.UserInput;

public class KmsToMiles {
    public static void main(String[] args) {
        double kms, miles;
        Scanner sc = new Scanner(System.in);

        kms = UserInput.inputDoublePositive(sc, "Input the distance (in kilometers):");
        miles = kms / 1.609;

        System.out.printf("%f kilometers = %f miles.\n", kms, miles);
        sc.close();
    }
}
