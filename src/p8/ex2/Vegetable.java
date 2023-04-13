package p8.ex2;

public class Vegetable extends VegetarianFood {
    Vegetable(String name, double proteins, double calories, double weight) {
        super(name, proteins, calories, weight);
    }

    @Override
    public String toString() {
        return "Vegetable " + super.getName() + ": " + super.toString();
    }
}
