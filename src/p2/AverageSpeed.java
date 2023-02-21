package p2;
import java.util.Scanner;
import utils.UserInput;

public class AverageSpeed {
    public static void main(String[] args) {
        double d1, t1, s1; // 1st part
        double d2, t2, s2; // 2nd part
        double dt, tt, st; // Total
        Scanner sc = new Scanner(System.in);

        // Get 1st part data
        d1 = UserInput.inputDoublePositive(sc, "Input the distance in the 1st part (in km): ");
        s1 = UserInput.inputDoublePositive(sc, "Input the speed in the 1st part (in km/h): ");
        t1 = d1 / s1;

        // Get 2nd part data
        d2 = UserInput.inputDoublePositive(sc, "Input the distance in the 2nd part (in km): ");
        s2 = UserInput.inputDoublePositive(sc, "Input the speed in the 2nd part (in km/h): ");
        t2 = d2 / s2;

        // Calculate data regarding the total trip
        dt = d1 + d2;
        tt = t1 + t2;
        st = dt / tt;

        System.out.printf("\nThe average speed is %f km/h.\n", st);
        sc.close();
    }
}
