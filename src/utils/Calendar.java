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
        
        if (month == 2 && year % 4 == 0) {
            return days_array[month - 1] + 1;
        } else {
            return days_array[month - 1];
        }
    }
}
