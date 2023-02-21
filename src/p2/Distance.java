package p2;
import java.util.Scanner;
import utils.UserInput;

public class Distance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x1, y1, x2, y2;
        double distance;
        
        x1 = UserInput.inputDoublePositive(sc, "x1?");
        y1 = UserInput.inputDoublePositive(sc, "y1?");
        x2 = UserInput.inputDoublePositive(sc, "x2?");
        y2 = UserInput.inputDoublePositive(sc, "y2?");

        sc.close();
        distance = Math.sqrt((x1 + x2)*(x1 + x2) + (y1 + y2)*(y1 + y2));
        System.out.printf("Distance is %f.\n", distance);
    }
}
