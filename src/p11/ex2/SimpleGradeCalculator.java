package p11.ex2;

import java.util.List;

public class SimpleGradeCalculator implements IGradeCalculator {

    @Override
    public double calculate(List<Double> grades) {
        double sum = 0;
        for (double value : grades) {
            sum += value;
        }
        return sum / grades.size();
    }
}
