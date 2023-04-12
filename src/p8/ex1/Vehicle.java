package p8.ex1;

abstract public class Vehicle implements KmPercorridosInterface {
    private final int power;
    private int kms = 0, lastKms = 0;
    private final String brand, model, licensePlate;

    Vehicle(String licensePlate, String brand, String model, int power, int kms) {
        if (!licensePlate.matches("[0-9A-Z]{2}-[0-9A-Z]{2}-[0-9A-Z]{2}")) {
            throw new IllegalArgumentException("Invalid license plate");
        }
        this.licensePlate = licensePlate;

        if (power <= 0) throw new IllegalArgumentException("Power must be positive");
        this.power = power;

        if (kms <= 0) throw new IllegalArgumentException("Number of kilometers must be positive.");
        this.kms = kms;

        this.brand = brand;
        this.model = model;
    }

    public String getLicensePlate() {
        return this.licensePlate;
    }

    public void trip(int quilometros) {
        this.lastKms = quilometros;
        this.kms += this.lastKms;
    };

    public int getLastTrip() {
        return this.lastKms;
    }

    public int totalDistance() {
        return this.kms;
    }

    @Override
    public String toString() {
        return this.brand + " " + this.model + ", " + this.licensePlate + ". Current kms: " + this.totalDistance() + ". Power: " + this.power;
    }

    public boolean equals(Vehicle v) {
        return this.licensePlate.equals(v.licensePlate);
    }
}
