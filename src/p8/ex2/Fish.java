package p8.ex2;

public class Fish extends Food {
    private final FishType type;

    Fish(FishType type, double proteins, double calories, double weight) {
        super(proteins, calories, weight);
        this.type = type;
    }

    @Override
    public String toString() {
        return this.type + " fish: " + super.toString();
    }
}
