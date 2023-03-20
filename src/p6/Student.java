package p6;

import p5.DateYMD;
import java.time.LocalDateTime;

public class Student extends Person {
    private static int NMecCounter = 100;
    private final DateYMD registrationDate;
    private final int NMec;

    Student(String name, int cc, DateYMD dateOfBirth, DateYMD registrationDate) {
        super(name, cc, dateOfBirth);
        this.registrationDate = registrationDate;
        this.NMec = NMecCounter++;
    }

    Student(String name, int cc, DateYMD dateOfBirth) {
        super(name, cc, dateOfBirth);
        LocalDateTime today = java.time.LocalDateTime.now();
        this.registrationDate = new DateYMD(today.getDayOfMonth(), today.getMonthValue(), today.getYear());
        this.NMec = NMecCounter++;
    }

    int getNMec() {
        return this.NMec;
    }

    public DateYMD getRegistrationDate() {
        return registrationDate;
    }

    @Override
    public String toString() {
        return super.toString() + "; Registration date: " + this.registrationDate.toString() + "; NMec: " + this.NMec;
    }
}
