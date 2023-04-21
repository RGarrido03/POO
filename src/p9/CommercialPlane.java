package p9;

public class CommercialPlane extends Plane {
    private int numOfCrewMembers;

    public CommercialPlane(String id, String manufacturer, String model, int year, int maxNumOfPassengers, double maxSpeed, int numOfCrewMembers) {
        super(id, manufacturer, model, year, maxNumOfPassengers, maxSpeed);
        this.numOfCrewMembers = numOfCrewMembers;
    }

    @Override
    public String getPlaneType() {
        return "Commercial";
    }

    @Override
    public String toString() {
        return String.format("Commercial {%s, numOfCrewMembers: %d}", super.toString(), this.numOfCrewMembers);
    }
}
