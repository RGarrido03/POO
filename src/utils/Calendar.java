package utils;

public class Calendar {
    public static void printCalendar(int[] date, int start) {
        String[] months_names = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        
        // Print header
        String header = months_names[date[0] - 1] + " " + Integer.toString(date[1]);
        StringBuilder centered_header = Strings.centerString(header, 21);
        System.out.println(centered_header);

        // Print subheader containing the days of the week
        System.out.println("Su Mo Tu We Th Fr Sa");
        
        // Print inital white space gap until day 1
        StringBuilder initial_gap = new StringBuilder();
        for (int i = 0; i < start; i++) {
            initial_gap.append("   ");
        }
        System.out.print(initial_gap);
        
        // Print calendar
        int day_of_week = start;
        int days_in_month = getNumberOfDaysInMonth(date[0], date[1]);
        for (int day = 1; day <= days_in_month; day++) {
            if (day_of_week % 7 == 6 || day == days_in_month) {
                System.out.printf("%2d\n", day);
            } else {
                System.out.printf("%2d ", day);
            }
            day_of_week++;
        }
    }

    public static int getNumberOfDaysInMonth(int month, int year) {
        int[] days_array = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        if (month == 2 && isLeapYear(year)) {
            return days_array[month - 1] + 1;
        } else {
            return days_array[month - 1];
        }
    }

    public static boolean isLeapYear(int year) {
        return year % 4 == 0;
    }

    public static boolean isValidMonth(int month) {
        return month >= 1 && month <= 12;
    }

    public static boolean isValidDate(int day, int month, int year) {
        if (!isValidMonth(month)) {
            return false;
        } else if (day < 1 || day > getNumberOfDaysInMonth(month, year)) {
            return false;
        }
        return true;
    }

    public static int[] incrementDate(int day, int month, int year) {
        int[] date = {day, month, year};
        if (month == 12 && day == 31) {
            date[2]++;
            date[1] = 1;
            date[0] = 1;
        } else if (day == getNumberOfDaysInMonth(month, year)) {
            date[1]++;
            date[0] = 1;
        } else {
            date[0]++;
        }
        return date;
    };

    public static int[] decrementDate(int day, int month, int year) {
        int[] date = {day, month, year};
        if (month == 1 && day == 1) {
            date[2]--;
            date[1] = 12;
            date[0] = 31;
        } else if (day == 1) {
            date[1]--;
            date[0] = getNumberOfDaysInMonth(month - 1, year);
        } else {
            date[0]--;
        }
        return date;
    };
}
