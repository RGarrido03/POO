package p3;

import java.util.Scanner;
import utils.UserInput;
import utils.Calendar;

public class PrintCalendarEx {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] date = UserInput.inputDate_mmyyyy(sc);
        int start = UserInput.inputIntRange(sc, "Input the day of the week, in numbers:", 1, 7, false, false);

        System.out.print("\n");
        Calendar.printCalendar(date, start);
    }
}