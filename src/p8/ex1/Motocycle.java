package p8.ex1;

public class Motocycle extends Vehicle {
    private final MotocycleType type;

    Motocycle(String licensePlate, String brand, String model, int power, int kms, MotocycleType type) {
        super(licensePlate, brand, model, power, kms);
        this.type = type;
    }

    @Override
    public String toString() {
        return "Motocycle: " + super.toString() + ", type: " + this.type;
    }
}
