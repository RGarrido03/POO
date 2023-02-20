package p2;
import java.util.Scanner;

public class Hypotenuse {
    private static double inputDouble(Scanner sc, String message) {
        double num;

        System.out.print(message);
        do {
            num = Double.parseDouble(sc.nextLine());
            if (!(num > 0)) {
                System.out.print("The value you inputted isn't positive. Input a new one: ");
            }
        } while (!(num > 0));
        
        return num;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double c1, c2, h, angle;

        c1 = inputDouble(sc, "Cathetus A: ");
        c2 = inputDouble(sc, "Cathetus B: ");    
        sc.close();    

        h = Math.sqrt(c1*c1 + c2*c2);
        angle = Math.asin(c2/h); // Radians
        angle = angle * 360 / (2 * Math.PI); // Degrees

        System.out.printf("\nHypotenuse = %f\nAngle between A and the hypotenuse = %fº\n", h, angle);
    }
}