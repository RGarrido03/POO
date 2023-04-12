package p8.ex1;

public class Bus extends Vehicle {
    private final String vin;
    private int weight, maxPassengers;

    Bus(String licensePlate, String brand, String model, int power, int kms, String vin, int weight, int maxPassengers) {
        super(licensePlate, brand, model, power, kms);

        if (!vin.matches("[0-9A-Z]{17}")) {
            throw new IllegalArgumentException("Incorrect VIN format.");
        }
        this.vin = vin;

        if (weight <= 0) {
            throw new IllegalArgumentException("Weight must be positive.");
        }
        this.weight = weight;

        if (maxPassengers <= 0) {
            throw new IllegalArgumentException("Maximum load must be positive.");
        }
        this.maxPassengers = maxPassengers;
    }

    @Override
    public String toString() {
        return "Bus: " + super.toString() + ", VIN: " + this.vin + ", weight: " + this.weight + ", max passengers: " + this.maxPassengers;
    }
}
