package p8.ex2;

public class Meat extends Food {
    private final MeatProtein type;

    Meat(MeatProtein type, double proteins, double calories, double weight) {
        super(proteins, calories, weight);
        this.type = type;
    }

    @Override
    public String toString() {
        return this.type + " meat: " + super.toString();
    }
}
