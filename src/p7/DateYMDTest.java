package p7;

import utils.UserInput;
import java.util.Scanner;

public class DateYMDTest {
    private static int mainMenu(Scanner sc) {
        System.out.println("Choose an option:");
        System.out.println("1. Create new date");
        System.out.println("2. Show current date");
        System.out.println("3. Increment date");
        System.out.println("4. Decrement date");
        System.out.println("0. Exit");
        System.out.print(">> ");

        return UserInput.inputInt(sc, null);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateYMD date = new DateYMD(1, 1, 1970);
    
        System.out.print("\033\143");
        while (true) {
            int opt = mainMenu(sc);

            switch(opt) {
                case 0 -> {return;}

                case 1 -> {
                    int day = UserInput.inputInt(sc, "Input the day:");
                    int month = UserInput.inputInt(sc, "Input the month:");
                    int year = UserInput.inputInt(sc, "Input the year:");

                    try {
                        date.setDate(day, month, year);
                        System.out.print("\033\143");
                        System.out.printf("Date set to %s.\n\n", date);
                    } catch (Exception e) {
                        System.out.print("\033\143");
                        System.out.println("Date is not valid.");
                        System.out.printf("Current date is still %s.\n\n", date);
                    }
                }

                case 2 -> {
                    System.out.print("\033\143");
                    System.out.println(date + "\n");
                }

                case 3 -> {
                    date.incrementDate();
                    System.out.print("\033\143");
                    System.out.println("Date increased to " + date + ".\n");
                }

                case 4 -> {
                    date.decrementDate();
                    System.out.print("\033\143");
                    System.out.println("Date decreased to " + date + ".\n");
                }

                default -> {
                    System.out.print("\033\143");
                    System.out.println("No selection made.\n");
                }
            }
        }
    }
}
