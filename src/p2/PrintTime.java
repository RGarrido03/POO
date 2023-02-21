package p2;
import java.util.Scanner;
import utils.UserInput;

public class PrintTime {
    public static void main(String[] args) {
        int totalTime, h, m, s;
        Scanner sc = new Scanner(System.in);

        totalTime = UserInput.inputIntPositive(sc, "Input the time in seconds:");
        sc.close();

        h = totalTime / 3600;
        m = (totalTime % 3600) / 60;
        s = (totalTime % 3600) % 60;

        System.out.printf("%d seconds is %d hour(s), %d minute(s) and %d second(s).\n", totalTime, h, m, s);
    }
}
