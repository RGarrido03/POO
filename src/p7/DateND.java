package p7;

public class DateND extends Date {
    private int days; // Days since 2000-01-01

    public DateND(int days) {
        this.setDate(days);
    }

    private static int convertYMDtoDays(int day, int month, int year) {
        int days = 0;

        for (int i = year - 1; i >= 2000; i--) {
            if (Date.leapYear(i)) {
                days += 366;
            } else {
                days += 365;
            }
        }

        for (int i = month - 1; i >= 1; i--) {
            days += Date.monthDays(i, year);
        }

        days += day;
        return days;
    }

    private static int[] convertDaysToYMD(int days) {
        if (days < 0) throw new IllegalArgumentException("Days must be positive.");

        int temp = days;
        int[] ymd = {2000, 1, 1};

        while ((Date.leapYear(ymd[0]) && temp > 366) || (!Date.leapYear(ymd[0]) && temp > 365)) {
            if (Date.leapYear(ymd[0])) {
                temp -= 366;
            } else {
                temp -= 365;
            }
            ymd[0]++;
        }

        while (temp > Date.monthDays(ymd[1], ymd[0])) {
            temp -= Date.monthDays(ymd[1], ymd[0]);
            ymd[1]++;
        }

        ymd[2] = temp;
        return ymd;
    }

    int getDay() {
        return convertDaysToYMD(this.days)[2];
    }

    int getMonth() {
        return convertDaysToYMD(this.days)[1];
    }

    int getYear() {
        return convertDaysToYMD(this.days)[0];
    }

    void setDate(int day, int month, int year) {
        this.days = convertYMDtoDays(day, month, year);
    }

    void setDate(int days) {
        if (days < 0) {
            throw new IllegalArgumentException("Days must be positive.");
        } else {
            this.days = days;
        }
    }

    void incrementDate() {
        this.days++;
    }

    void decrementDate() {
        this.days--;
    }

    @Override
    public String toString() {
        int[] temp = convertDaysToYMD(this.days);
        return temp[0] + "-" + temp[1] + "-" + temp[2];
    }
}
