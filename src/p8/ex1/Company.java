package p8.ex1;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private String name, email, postalCode;
    private final List<Vehicle> vehicleArrayList = new ArrayList<>();

    Company(String name, String email, String postalCode) {
        this.name = name;
        this.setEmail(email);

        if (!postalCode.matches("[0-9]{4}-[0-9]{3}")) {
            throw new IllegalArgumentException("Invalid postal code. Be sure to follow the xxxx-xxx format.");
        }
        this.postalCode = postalCode;
    }

    public void setEmail(String email) {
        if (!email.matches("^([\\w\\-]+)@([\\w\\-]+)((\\.(\\w){2,3})+)$")) {
            throw new IllegalArgumentException("Invalid e-mail. Be sure to follow the name@domain format.");
        }
        this.email = email;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicleArrayList.add(vehicle);
    }

    public List<Vehicle> getVehicleArrayList() {
        return this.vehicleArrayList;
    }

    public Vehicle getVehicle(String licensePlate) {
        for (Vehicle vehicle : vehicleArrayList) {
            if (vehicle.getLicensePlate().equals(licensePlate)) {
                return vehicle;
            }
        }
        return null;
    }
}
