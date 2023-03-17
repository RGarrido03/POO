package p5;

import java.util.Scanner;
import utils.UserInput;

public class CalendarP5Test {
    private static int mainMenu(Scanner sc) {
        System.out.print("""
            Choose an option:
            1. Create new calendar
            2. Print calendar (month)
            3. Print calendar (year)
            4. Add event
            5. Remove event
            0. Exit
            >>\s"""
        );
        return UserInput.inputInt(sc, null);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = 1970;
        int first_weekday = 4;
        CalendarP5 calendar = new CalendarP5(year, first_weekday);

        System.out.print("\033\143");
        System.out.println("Current year is 1970.\n");
        while(true) {
            int opt = mainMenu(sc);

            switch(opt) {
                case 0 -> {return;}

                case 1 -> {
                    year = UserInput.inputInt(sc, "Input the year:");
                    first_weekday = UserInput.inputInt(sc, "Input the first weekday of the year (0 = Sunday):");
                    calendar = new CalendarP5(year, first_weekday);
                    
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
                    System.out.print(calendar);
                }

                case 4 -> {
                    int month_event = UserInput.inputInt(sc, "Input the month:");
                    int day_event = UserInput.inputInt(sc, "Input the day:");

                    System.out.print("\033\143");
                    try {
                        calendar.addEvent(new DateYMD(day_event, month_event, year));
                        System.out.println("Event added.\n");
                    } catch (Exception e) {
                        System.out.printf("%s. No event was added.\n\n", e.getMessage());
                    }
                }

                case 5 -> {
                    int month_event = UserInput.inputInt(sc, "Input the month:");
                    int day_event = UserInput.inputInt(sc, "Input the day:");

                    System.out.print("\033\143");
                    try {
                        calendar.removeEvent(new DateYMD(day_event, month_event, year));
                        System.out.println("Event deleted.\n");
                    } catch (Exception e) {
                        System.out.printf("%s. No event was deleted.\n\n", e.getMessage());
                    }
                }

                default -> {
                    System.out.print("\033\143");
                    System.out.println("No/Invalid option selected.\n");
                }
            }
        }
    }
}
