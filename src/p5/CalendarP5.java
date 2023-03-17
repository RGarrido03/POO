package p5;

import utils.Calendar;

public class CalendarP5 {
    private int year;
    private int first_weekday;
    private int[][] events = new int[12][31];
    
    CalendarP5(int year, int first_weekday) {
        this.setYear(year);
        this.first_weekday = first_weekday;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setFirstWeekdayOfYear(int first_weekday) {
        if (first_weekday >= 1 || first_weekday <= 7) {
            this.first_weekday = first_weekday;
        } else {
            throw new IllegalArgumentException("Invalid weekday");
        }
    }

    public int getYear() {
        return year;
    }

    public int firstWeekdayOfYear() {
        return first_weekday;
    }

    public int firstWeekdayOfMonth(int month) {
        return Calendar.firstWeekdayOfMonth(month, this.year, this.first_weekday);
    }

    public void addEvent(DateYMD date) {
        events[date.getMonth()][date.getDay()]++;
    }

    public void removeEvent(DateYMD date) {
        if (events[date.getMonth()][date.getDay()] != 0)
            events[date.getMonth()][date.getDay()]--;
    }

    public String toString(int month) {
        int[] date = new int[3];
        date[0] = 1;
        date[1] = month;
        date[2] = this.year;
        return Calendar.printMonth(date, firstWeekdayOfMonth(month));
    }

    @Override
    public String toString() {
        return Calendar.printYear(year, first_weekday);
    }
}
