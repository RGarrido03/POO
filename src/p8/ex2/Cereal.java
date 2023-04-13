package p8.ex2;

public class Cereal extends VegetarianFood {
    Cereal(String name, double proteins, double calories, double weight) {
        super(name, proteins, calories, weight);
    }

    @Override
    public String toString() {
        return "Cereal " + super.getName() + ": " + super.toString();
    }
}
