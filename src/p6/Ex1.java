package p6;

import p5.DateYMD;

public class Ex1 {
    public static void main(String[] args) {
        Student s1 = new Student("Andreia Melo", 9855678, new DateYMD(18, 7, 1990), new DateYMD(1, 9, 2018));
        Teacher t1 = new Teacher("Jorge Almeida", 3467225, new DateYMD(13, 3, 1967), "Associado", "Informática");
        ScholarshipHolder sh1 = new ScholarshipHolder("Igor Santos", 8976543, new DateYMD(11, 5, 1985), t1, 900);
        sh1.setScholarship(1050);

        System.out.println("Student: " + s1.getName());
        System.out.println(s1);

        System.out.println("Scholarship holder: " + sh1.getName() +
            ", NMec: " + sh1.getNMec() +
            ", Scholarship: " + sh1.getScholarship() +
            ", Supervisor: " + sh1.getSupervisor().getName()
        );
        System.out.println(sh1);
    }
}
