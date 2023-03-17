package p5;

import utils.Calendar;

public class CalendarP5 {
    private final int year;
    private final int first_weekday;
    private final int[][] events = new int[12][31];
    
    CalendarP5(int year, int first_weekday) {
        this.year = year;
        this.first_weekday = first_weekday;
    }

    public int getYear() {
        return this.year;
    }

    public int firstWeekdayOfYear() {
        return this.first_weekday;
    }

    public int firstWeekdayOfMonth(int month) {
        return Calendar.firstWeekdayOfMonth(month, this.year, this.first_weekday);
    }

    public void addEvent(DateYMD date) {
        this.events[date.getMonth() - 1][date.getDay() - 1]++;
    }

    public void removeEvent(DateYMD date) {
        if (this.events[date.getMonth() - 1][date.getDay() - 1] > 0)
            this.events[date.getMonth() - 1][date.getDay() - 1]--;
        else
            throw new IllegalArgumentException("There are no events on this day");
    }

    public String toString(int month) {
        int[] date = new int[3];
        date[0] = 1;
        date[1] = month;
        date[2] = this.year;
        return Calendar.printMonthWithEvents(date, firstWeekdayOfMonth(month), this.events);
    }

    @Override
    public String toString() {
        return Calendar.printYearWithEvents(this.year, this.first_weekday, this.events);
    }
}
