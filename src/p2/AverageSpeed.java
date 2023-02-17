package p2;
import java.util.Scanner;

public class AverageSpeed {
    public static double inputDouble(Scanner sc) {
        double val;
        
        do {
            val = Double.parseDouble(sc.nextLine());
            if (val <= 0) {
                System.out.print("The value you inputted is not positive. Input a new one: ");
            }
        } while (val <= 0);

        return val;
    }

    public static void main(String[] args) {
        double d1, t1, s1; // 1st part
        double d2, t2, s2; // 2nd part
        double dt, tt, st; // Total
        Scanner sc = new Scanner(System.in);

        // Get 1st part data
        System.out.print("Input the distance in the 1st part (in km): ");
        d1 = inputDouble(sc);

        System.out.print("Input the speed in the 1st part (in km/h): ");
        s1 = inputDouble(sc);

        t1 = d1 / s1;

        // Get 2nd part data
        System.out.print("Input the distance in the 2nd part (in km): ");
        d2 = inputDouble(sc);

        System.out.print("Input the speed in the 2nd part (in km/h): ");
        s2 = inputDouble(sc);

        t2 = d2 / s2;

        // Calculate data regarding the total trip
        dt = d1 + d2;
        tt = t1 + t2;
        st = dt / tt;

        System.out.printf("\nThe average speed is %f km/h.\n", st);
        sc.close();
    }
}
