package p7;
import utils.Calendar;

public class DateYMD extends Date {
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

    @Override
    public String toString() {
        return year + "-" + month + "-" + day;
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
