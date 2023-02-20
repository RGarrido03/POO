package p2;
import java.util.Scanner;

public class Distance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x1, y1, x2, y2;
        double distance;
        
        System.out.print("x1? ");
        x1 = Double.parseDouble(sc.nextLine());

        System.out.print("y1? ");
        y1 = Double.parseDouble(sc.nextLine());

        System.out.print("x2? ");
        x2 = Double.parseDouble(sc.nextLine());

        System.out.print("y2? ");
        y2 = Double.parseDouble(sc.nextLine());

        sc.close();
        distance = Math.sqrt((x1 + x2)*(x1 + x2) + (y1 + y2)*(y1 + y2));
        System.out.printf("Distance is %f.\n", distance);
    }
}
