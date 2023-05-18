package p11.ex2;

import java.util.List;
import java.util.Objects;

public class Student implements Comparable<Student> {

    private String name;
    private final List<Double> grades;

    public Student(String name, List<Double> grades) {
        this.name = name;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public List<Double> getGrades() {
        return grades;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Student student) {
        return this.name.compareToIgnoreCase(student.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name);
    }

    @Override
    public String toString() {
        return "Student{" + "name='" + name + '\'' + ", grades=" + grades + '}';
    }

    public boolean equals(String name) {
        return this.name.equals(name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
