package p8.ex2;

public class DietDish extends Dish {
    private double calories = 0;
    private final double maxCalories;

    DietDish(String name, double maxCalories) {
        super(name);

        if (maxCalories <= 0) throw new IllegalArgumentException("Maximum calories must be positive.");
        this.maxCalories = maxCalories;
    }

    @Override
    public boolean addIngredient(Food food) {
        if (food.getCalories() + this.calories <= this.maxCalories) {
            super.addIngredient(food);
            this.calories += food.getCalories();
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + " - Diet (" + Math.round(this.calories * 100) / 100.0 + " kcal)";
    }
}
