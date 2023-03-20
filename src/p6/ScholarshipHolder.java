package p6;

import p5.DateYMD;

public class ScholarshipHolder extends Student {
    private final Teacher supervisor;
    private int scholarship;

    ScholarshipHolder(String name, int cc, DateYMD dateOfBirth, Teacher supervisor, int scholarship) {
        super(name, cc, dateOfBirth);
        this.supervisor = supervisor;
        this.setScholarship(scholarship);
    }

    ScholarshipHolder(String name, int cc, DateYMD dateOfBirth, DateYMD registrationDate, Teacher supervisor, int scholarship) {
        super(name, cc, dateOfBirth, registrationDate);
        this.supervisor = supervisor;
        this.setScholarship(scholarship);
    }

    public void setScholarship (int scholarship) {
        if (scholarship > 0) {
            this.scholarship = scholarship;
        } else {
            throw new IllegalArgumentException("Invalid scholarship");
        }
    }

    public int getScholarship() {
        return this.scholarship;
    }

    public Teacher getSupervisor() {
        return this.supervisor;
    }

    @Override
    public String toString() {
        return super.toString() + "; Supervisor: " + this.supervisor.getName() + "; Scholarship: " + this.scholarship;
    }
}
