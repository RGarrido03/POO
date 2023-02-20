package p2;

import java.util.Scanner;

public class InputNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double input, first, min, max, avg;
        int count = 0;

        System.out.println("Input the numbers, one per line:");
        first = min = max = avg = Double.parseDouble(sc.nextLine());
        count++;

        do {
            input = Double.parseDouble(sc.nextLine());
            count++;

            if (input < min) {
                min = input;
            } else if (input > max) {
                max = input;
            }
            avg = (avg * (count - 1) + input) / count;
        } while (input != first);

        sc.close();
        System.out.printf("Numbers: %d\nMin = %f\nMax = %f\nAvg = %f\n", count, min, max, avg);
    }
}
