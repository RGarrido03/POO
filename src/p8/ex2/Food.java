package p8.ex2;

abstract public class Food {
    private double proteins, calories, weight;

    Food(double proteins, double calories, double weight) {
        if (proteins < 0) throw new IllegalArgumentException("Proteins must be non-negative.");
        if (calories < 0) throw new IllegalArgumentException("Calories must be non-negative.");
        if (weight <= 0) throw new IllegalArgumentException("Weight must be positive.");

        this.proteins = proteins;
        this.calories = calories;
        this.weight = weight;
    }

    public double getCalories() {
        return this.calories;
    }

    @Override
    public String toString() {
        return "proteins: " + Math.round(this.proteins * 100) / 100.0 + "g, calories: " + Math.round(this.calories * 100) / 100.0 + "kcal, weight: " + Math.round(this.weight * 100) / 100.0 + "g";
    }
}
