package p8.ex1;

public class ElectricCar extends Car implements ElectricVehicle {
    private int battery; // Battery percentage

    ElectricCar(String licensePlate, String brand, String model, int power, int kms, String vin, int trunkCapacity) {
        super(licensePlate, brand, model, power, kms, vin, trunkCapacity);
    }

    @Override
    public int getBatteryCapacity() {
        return this.battery;
    }

    @Override
    public void charge(int percentage) {
        if (this.battery + percentage > 100) {
            throw new IllegalArgumentException("Battery percentage can't be higher than 100%.");
        }
        this.battery += percentage;
    }

    @Override
    public String toString() {
        return super.toString() + ", battery: " + this.battery;
    }
}
