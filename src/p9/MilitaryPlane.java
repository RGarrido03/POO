package p9;

public class MilitaryPlane extends Plane {
    private int numMissiles;

    public MilitaryPlane(String id, String manufacturer, String model, int year, int maxPassengers, double maxSpeed, int numMissiles) {
        super(id, manufacturer, model, year, maxPassengers, maxSpeed);
        this.numMissiles = numMissiles;
    }

    @Override
    public String getPlaneType() {
        return "Military";
    }

    @Override
    public String toString() {
        return String.format("Military {%s, numMissiles: %d}", super.toString(), this.numMissiles);
    }
}