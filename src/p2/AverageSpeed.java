package p2;
import java.util.Scanner;

public class AverageSpeed {
    public static void main(String[] args) {
        double d1, t1, s1; // 1st part
        double d2, t2, s2; // 2nd part
        double dt, tt, st; // Total
        Scanner sc = new Scanner(System.in);

        // Get 1st part data
        System.out.print("Input the distance in the 1st part (in km): ");
        d1 = Double.parseDouble(sc.nextLine());

        System.out.print("Input the speed in the 1st part (in km/h): ");
        s1 = Double.parseDouble(sc.nextLine());

        t1 = d1 / s1;

        // Get 2nd part data
        System.out.print("Input the distance in the 2nd part (in km): ");
        d2 = Double.parseDouble(sc.nextLine());

        System.out.print("Input the speed in the 2nd part (in km/h): ");
        s2 = Double.parseDouble(sc.nextLine());

        t2 = d2 / s2;

        // Calculate data regarding the total trip
        dt = d1 + d2;
        tt = t1 + t2;
        st = dt / tt;

        System.out.printf("\nThe average speed is %f km/h.\n", st);
        sc.close();
    }
}
