package p7;

import utils.Calendar;

public abstract class Date {
    public static boolean validMonth(int month) {
        return Calendar.isValidMonth(month);
    }

    public static boolean leapYear(int year) {
        return Calendar.isLeapYear(year);
    }

    public static boolean valid(int day, int month, int year) {
        return Calendar.isValidDate(day, month, year);
    }

    public static int monthDays(int month, int year) {
        return Calendar.getNumberOfDaysInMonth(month, year);
    }

    abstract int getDay();
    abstract int getMonth();
    abstract int getYear();
    abstract void setDate(int day, int month, int year);
    abstract void incrementDate();
    abstract void decrementDate();
}
