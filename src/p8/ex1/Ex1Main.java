package p8.ex1;

public class Ex1Main {
    public static void main(String[] args) {
        Company company = new Company("Company", "whatever@a.com", "1234-123");

        // Add vehicles
        // Disclaimer: values are not realistic
        company.addVehicle(new Car("11-AA-11", "Ford", "Fiesta", 68, 50, "12345678901234567", 250));
        company.addVehicle(new Motocycle("22-BB-22", "Honda", "CBR", 100, 70, MotocycleType.SPORT));
        company.addVehicle(new Taxi("33-CC-33", "Ford", "Fiesta", 120, 30, "12345678901234567", 200, 1234));
        company.addVehicle(new Bus("44-DD-44", "Mercedes", "Sprinter", 500, 60, "12345678901234567", 3000, 50));
        company.addVehicle(new Truck("55-EE-55", "Mercedes", "Actros", 1000, 40, "12345678901234567", 5000, 10000));
        company.addVehicle(new ElectricCar("66-FF-66", "Tesla", "Model S", 400, 20, "12345678901234567", 300));
        company.addVehicle(new ElectricBus("77-GG-77", "Tesla", "Model B", 700, 10, "12345678901234567", 2500, 75));

        // Make some trips
        company.getVehicle("11-AA-11").trip(50);
        company.getVehicle("22-BB-22").trip(100);

        // Get the last trip of a vehicle
        System.out.println(company.getVehicle("11-AA-11").getLastTrip());

        // See if two vehicles are equal (must return false!)
        System.out.println(company.getVehicle("11-AA-11").equals(company.getVehicle("22-BB-22")));

        // Charge an electric vehicle
        ((ElectricVehicle) company.getVehicle("66-FF-66")).charge(50);

        // Print all vehicles, and the vehicle with more kms
        Vehicle temp = null;

        for (Vehicle vehicle : company.getVehicleArrayList()) {
            System.out.println(vehicle);
            if (temp == null || vehicle.totalDistance() > temp.totalDistance()) {
                temp = vehicle;
            }
        }

        if (temp != null) {
            System.out.println("\nVehicle with biggest distance is " + temp);
        }
    }
}
