package p8.ex2;

public class VegetarianDish extends Dish {
    VegetarianDish(String name) {
        super(name);
    }

    @Override
    public boolean addIngredient(Food food) {
        if (food instanceof VegetarianFood) {
            super.addIngredient(food);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + " - Vegetarian dish";
    }
}
