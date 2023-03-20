package p6;

import p5.DateYMD;

public class Person {
    private String name;
    private final int cc;
    private final DateYMD dateOfBirth;

    Person(String name, int cc, DateYMD dateOfBirth) {
        this.setName(name);

        if (cc > 0) {
            this.cc = cc;
        } else {
            throw new IllegalArgumentException("Invalid CC");
        }

        this.dateOfBirth = dateOfBirth; // Validation is made inside DateYMD
    }

    public void setName(String name) { // A person can change their name
        if (name != null && name.length() > 0) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Invalid name");
        }
    }

    public String getName() {
        return name;
    }

    public int getCc() {
        return cc;
    }

    public DateYMD getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public String toString() {
        return this.name + "; CC: " + this.cc + "; Date of birth: " + this.dateOfBirth.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Person p)) {
            return false;
        }
        return this.cc == ((Person) o).getCc();
    }
}
