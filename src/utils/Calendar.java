package utils;

public class Calendar {
    public static String printMonth(int[] date, int start) {
        String[] months_names = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        StringBuilder month_printString = new StringBuilder();
        
        // Print header
        String header = months_names[date[1] - 1] + " " + Integer.toString(date[2]);
        StringBuilder centered_header = Strings.centerString(header, 21);
        month_printString.append(centered_header.toString() + "\n");

        // Print subheader containing the days of the week
        month_printString.append("Su Mo Tu We Th Fr Sa\n");
        
        // Print inital white space gap until day 1
        StringBuilder initial_gap = new StringBuilder();
        for (int i = 0; i < start; i++) {
            initial_gap.append("   ");
        }
        month_printString.append(initial_gap.toString());
        
        // Print calendar
        int day_of_week = start;
        int days_in_month = getNumberOfDaysInMonth(date[1], date[2]);
        for (int day = 1; day <= days_in_month; day++) {
            if (day_of_week % 7 == 6 || day == days_in_month) {
                month_printString.append(String.format("%2d\n", day));
            } else {
                month_printString.append(String.format("%2d ", day));
            }
            day_of_week++;
        }

        return month_printString.toString();
    }

    public static String printYear(int year, int first_weekday_year) {
        StringBuilder calendar = new StringBuilder();
        int[] date = new int[3];
        date[0] = 1;
        date[2] = year;

        for (int i = 1; i <= 12; i++) {
            date[1] = i;
            calendar.append(Calendar.printMonth(date, firstWeekdayOfMonth(i, year, first_weekday_year)));
            calendar.append("\n");
        }

        return calendar.toString();
    }

    public static int firstWeekdayOfMonth(int month, int year, int first_weekday_year) {
        int[] add = {0, 3, 0, 3, 2, 3, 2, 3, 3, 2, 3, 2};
        int sum = first_weekday_year;

        if (isLeapYear(year)) {
            add[2]++;
        }

        for (int i = 0; i < month; i++) {
            sum += add[i];
        }

        return sum % 7;
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
