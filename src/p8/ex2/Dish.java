package p8.ex2;

import java.util.ArrayList;
import java.util.List;

public class Dish {
    private final String name;
    private final List<Food> foodArrayList = new ArrayList<>();

    Dish(String name) {
        this.name = name;
    }

    public boolean addIngredient(Food food) {
        foodArrayList.add(food);
        return true;
    }

    @Override
    public String toString() {
        return "Dish '" + this.name + "', with " + this.foodArrayList.size() + " ingredients";
    }
}
