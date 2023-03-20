package p5;
import utils.Calendar;

public class DateYMD {
    private int year;
    private int month;
    private int day;

    public DateYMD(int day, int month, int year) {
        this.setDate(day, month, year);
    }

    // Getters

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    // Setters

    public void setDate(int day, int month, int year) {
        if (valid(day, month, year)) {
            this.day = day;
            this.month = month;
            this.year = year;
        } else {
            throw new IllegalArgumentException("Date is not valid");
        }
    }

    // Override methods

    @Override
    public String toString() {
        return year + "-" + month + "-" + day;
    }

    // Validating methods
    
    public boolean validMonth(int month) {
        return Calendar.isValidMonth(month);
    }

    public boolean leapYear(int year) {
        return Calendar.isLeapYear(year);
    }

    public boolean valid(int day, int month, int year) {
        return Calendar.isValidDate(day, month, year);
    }

    // Other methods

    public int monthDays(int month, int year) {
        return Calendar.getNumberOfDaysInMonth(month, year);
    }

    public void incrementDate() {
        int[] tempDate = Calendar.incrementDate(this.day, this.month, this.year);
        this.setDate(tempDate[0], tempDate[1], tempDate[2]);
    }

    public void decrementDate() {
        int[] tempDate = Calendar.decrementDate(this.day, this.month, this.year);
        this.setDate(tempDate[0], tempDate[1], tempDate[2]);
    }
}
