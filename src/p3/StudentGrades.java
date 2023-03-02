package p3;

import java.util.Random;
import java.util.Scanner;

import utils.UserInput;

public class StudentGrades {
    private static double finalGrade(double t, double p) {
        double fng = 0.4 * t + 0.6 * p;
        if (fng < 7) {
            return 66;
        }
        return Math.round(fng);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int std_num = UserInput.inputIntPositive(sc, "Input the number of students:");
        double[][] std_grades = new double[std_num][3];
        System.out.printf("NotaT NotaP Pauta\n");

        for (int i = 0; i < std_num; i++) {
            // Randomize grades
            for (int j = 0; j < 2; j++) {
                std_grades[i][j] = rand.nextDouble() * 20;
            }

            // Calculate the final grade
            std_grades[i][2] = finalGrade(std_grades[i][0], std_grades[i][1]);
            System.out.printf(" %4.1f  %4.1f    %2.0f\n", std_grades[i][0], std_grades[i][1], std_grades[i][2]);
        }
    }
}
