package p6;

import p5.DateYMD;

import java.util.Arrays;
import java.util.List;

public class Teacher extends Person {
    private static final List<String> categoriesArray = Arrays.asList("Auxiliar", "Associado", "Catedrático");
    private String category;
    private final String department;

    Teacher(String name, int cc, DateYMD dateOfBirth, String category, String department) {
        super(name, cc, dateOfBirth);
        this.setCategory(category);
        this.department = department;
    }

    public void setCategory (String category) {
        if (categoriesArray.contains(category)) {
            this.category = category;
        } else {
            throw new IllegalArgumentException("Invalid category");
        }
    }

    @Override
    public String toString() {
        return super.toString() + "; Category: " + this.category + "; Department: " + this.department;
    }
}
