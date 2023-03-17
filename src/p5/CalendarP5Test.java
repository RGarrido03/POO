package p5;
import java.util.Scanner;
import utils.UserInput;

public class CalendarP5Test {
    private static int mainMenu(Scanner sc) {
        System.out.println("Choose an option:");
        System.out.println("1. Create new calendar");
        System.out.println("2. Print calendar (month)");
        System.out.println("3. Print calendar (year)");
        System.out.println("0. Exit");
        System.out.print(">> ");

        return UserInput.inputInt(sc, null);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CalendarP5 calendar = new CalendarP5(1970, 4);

        System.out.print("\033\143");
        System.out.println("Current year is 1970.\n");
        while(true) {
            int opt = mainMenu(sc);

            switch(opt) {
                case 0 -> {return;}

                case 1 -> {
                    int year = UserInput.inputInt(sc, "Input the year:");
                    calendar.setYear(year);
                    calendar.setFirstWeekdayOfYear(UserInput.inputInt(sc, "Input the first weekday of the year (0 = Sunday):"));
                    
                    System.out.print("\033\143");
                    System.out.printf("%d calendar created.\n\n", year);
                }

                case 2 -> {
                    int month = UserInput.inputInt(sc, "Input the month:");
                    System.out.print("\033\143");
                    System.out.println(calendar.toString(month));
                }

                case 3 -> {
                    System.out.print("\033\143");
                    System.out.print(calendar.toString());
                }
            }
        }
    }
}
