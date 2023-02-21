package p2;
import java.util.Scanner;
import utils.UserInput;

public class Hypotenuse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double c1, c2, h, angle;

        c1 = UserInput.inputDoublePositive(sc, "Cathetus A:");
        c2 = UserInput.inputDoublePositive(sc, "Cathetus B:");
        sc.close();

        h = Math.sqrt(c1*c1 + c2*c2);
        angle = Math.asin(c2/h); // Radians
        angle = angle * 360 / (2 * Math.PI); // Degrees

        System.out.printf("\nHypotenuse = %f\nAngle between A and the hypotenuse = %fº\n", h, angle);
    }
}