package p7;

import p6.Person;
import utils.Calendar;

import java.util.Objects;

public abstract class Date implements Comparable<Date> {
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

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Date d)) {
            return false;
        }

        return this.getDay() == d.getDay() &&
            this.getMonth() == d.getMonth() &&
            this.getYear() == d.getYear();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getDay(), this.getMonth(), this.getYear());
    }

    @Override
    public int compareTo(Date that) {
        if (this.getYear() != that.getYear()) {
            return Integer.compare(this.getYear(), that.getYear());
        }
        if (this.getMonth() != that.getMonth()) {
            return Integer.compare(this.getMonth(), that.getMonth());
        }
        return Integer.compare(this.getDay(), that.getDay());
    }
}
