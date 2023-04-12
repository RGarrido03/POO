package p8.ex1;

public class Truck extends Vehicle {
    private String vin;
    private int weight, maxLoad;

    Truck(String licensePlate, String brand, String model, int power, int kms, String vin, int weight, int maxLoad) {
        super(licensePlate, brand, model, power, kms);

        if (!vin.matches("[0-9A-Z]{17}")) {
            throw new IllegalArgumentException("Incorrect VIN format.");
        }
        this.vin = vin;

        if (weight <= 0) {
            throw new IllegalArgumentException("Weight must be positive.");
        }
        this.weight = weight;

        if (maxLoad <= 0) {
            throw new IllegalArgumentException("Maximum load must be positive.");
        }
        this.maxLoad = maxLoad;
    }

    @Override
    public String toString() {
        return "Truck: " + super.toString() + ", VIN: " + this.vin + ", weight: " + this.weight + ", max load: " + this.maxLoad;
    }
}
