package p9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlaneManager {
    Map<String, Plane> planes = new HashMap<>();

    public void addPlane(Plane plane) {
        planes.put(plane.getId(), plane);
    }

    public void removePlane(String id) {
        planes.remove(id);
    }

    public Plane searchPlane(String id) {
        return planes.get(id);
    }

    public List<Plane> getCommercialPlanes() {
        List<Plane> commercialPlanes = new ArrayList<>();

        for (Plane plane : planes.values()) {
            if (plane instanceof CommercialPlane) { // Check if the plane is a CommercialPlane
                commercialPlanes.add(plane);
            }
        }
        return commercialPlanes;
    }

    public List<Plane> getMilitaryPlanes() {
        List<Plane> militaryPlanes = new ArrayList<>();

        for (Plane plane : planes.values()) {
            if (plane instanceof MilitaryPlane) { // Check if the plane is a MilitaryPlane
                militaryPlanes.add(plane);
            }
        }
        return militaryPlanes;
    }

    public void printAllPlanes() {
        for (Plane plane : planes.values()) {
            System.out.println(plane);
        }
    }

    public Plane getFastestPlane() {
        Plane fastestPlane = null;
        double maxSpeed = 0;

        // Check each plane's max speed and update the fastest plane if necessary
        for (Plane plane : planes.values()) {
            if (plane.getMaxSpeed() > maxSpeed) {
                maxSpeed = plane.getMaxSpeed();
                fastestPlane = plane;
            }
        }
        return fastestPlane;
    }
}
