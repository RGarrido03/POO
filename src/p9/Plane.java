package p9;

public abstract class Plane {
    private String id, manufacturer, model;
    private int year, maxPassengers;
    private double maxSpeed;

    Plane(String id, String manufacturer, String model, int year, int maxNumOfPassengers, double maxSpeed) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.model = model;
        this.year = year;
        this.maxPassengers = maxNumOfPassengers;
        this.maxSpeed = maxSpeed;
    }

    public String getId() {
        return this.id;
    }

    public double getMaxSpeed() {
        return this.maxSpeed;
    }

    abstract String getPlaneType();

    @Override
    public String toString() {
        return String.format("id: %s, manufacturer: %s, model: %s, year: %d, maxPassengers: %d, maxSpeed: %.2f",
            this.id, this.manufacturer, this.model, this.year, this.maxPassengers, this.maxSpeed);
    }
}
