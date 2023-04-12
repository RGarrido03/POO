package p8.ex1;

public class Car extends Vehicle {
    private final String vin;
    private final int trunkCapacity;

    Car(String licensePlate, String brand, String model, int power, int kms, String vin, int trunkCapacity) {
        super(licensePlate, brand, model, power, kms);

        if (!vin.matches("[0-9A-Z]{17}")) {
            throw new IllegalArgumentException("Incorrect VIN format.");
        }
        this.vin = vin;

        if (trunkCapacity <= 0) {
            throw new IllegalArgumentException("Trunk capacity must be positive.");
        }
        this.trunkCapacity = trunkCapacity;
    }

    @Override
    public String toString() {
        return "Car: " + super.toString() + ", VIN: " + this.vin + ", trunk capacity: " + this.trunkCapacity;
    }
}
