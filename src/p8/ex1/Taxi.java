package p8.ex1;

public class Taxi extends Car {
    private final int licenseNumber;

    Taxi(String licensePlate, String brand, String model, int power, int kms, String vin, int trunkCapacity, int licenseNumber) {
        super(licensePlate, brand, model, power, kms, vin, trunkCapacity);
        this.licenseNumber = licenseNumber;
    }

    @Override
    public String toString() {
        return "Taxi: " + super.toString() + ", license number: " + this.licenseNumber;
    }
}
