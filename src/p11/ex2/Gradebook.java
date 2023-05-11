package p11.ex2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Gradebook {

    private final Map<String, Student> studentMap = new TreeMap<>();
    SimpleGradeCalculator gradeCalculator = new SimpleGradeCalculator();

    public void load(String path) throws FileNotFoundException {
        Scanner input = new Scanner(new FileReader(path));

        while (input.hasNext()) {
            String[] line = input.nextLine().strip().split("\\|");
            System.out.println(Arrays.toString(line));
            studentMap.put(
                line[0],
                new Student(
                    line[0],
                    List.of(
                        Double.parseDouble(line[1]),
                        Double.parseDouble(line[2]),
                        Double.parseDouble(line[3])
                    )
                )
            );
        }
    }

    public void addStudent(Student student) {
        studentMap.put(student.getName(), student);
    }

    public void removeStudent(String name) {
        studentMap.remove(name);
    }

    public Student getStudent(String name) {
        return studentMap.get(name);
    }

    public double calculateAverageGrade(String name) {
        return gradeCalculator.calculate(studentMap.get(name).getGrades());
    }

    public void printAllStudents() {
        System.out.println(studentMap.values());
    }
}
