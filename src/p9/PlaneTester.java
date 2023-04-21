package p9;
import utils.UserInput;

import java.util.Scanner;

public class PlaneTester {
    public static void main(String[] args) {
        PlaneManager planeManager = new PlaneManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("""

                Plane Fleet Menu:
                1. Add a plane to the fleet
                2. Remove a plane from the fleet
                3. Search for a plane
                4. Print summary of all planes in the fleet
                5. Print list of all commercial planes in the fleet
                6. Print list of all military planes in the fleet
                7. Print the fastest plane in the fleet
                0. Exit""");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addPlane(planeManager, scanner);
                case 2 -> removePlane(planeManager, scanner);
                case 3 -> searchPlane(planeManager, scanner);
                case 4 -> printAllPlanes(planeManager);
                case 5 -> printCommercialPlanes(planeManager);
                case 6 -> printMilitaryPlanes(planeManager);
                case 7 -> printFastestPlane(planeManager);
                case 0 -> System.out.println("Exiting program...");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void addPlane(PlaneManager planeManager, Scanner scanner) {
        String id = UserInput.inputString(scanner, "Enter the plane's ID: ");
        if (planeManager.searchPlane(id) != null) {
            System.out.println("A plane with that ID already exists.");
            return;
        }

        String manufacturer = UserInput.inputString(scanner, "Enter the plane's manufacturer: ");
        String model = UserInput.inputString(scanner, "Enter the plane's model: ");
        int year = UserInput.inputInt(scanner, "Enter the plane's year of manufacture: ");
        int maxPassengers = UserInput.inputInt(scanner, "Enter the plane's maximum number of passengers: ");
        double maxSpeed = UserInput.inputDouble(scanner, "Enter the plane's maximum speed: ");
        String type = UserInput.inputString(scanner, "Enter the type of plane, (C)ommercial or (M)ilitary: ");

        switch (type) {
            case "C", "c" -> {
                int numCrew = UserInput.inputInt(scanner, "Enter the plane's number of crew: ");
                planeManager.addPlane(new CommercialPlane(id, manufacturer, model, year, maxPassengers, maxSpeed, numCrew));
            }
            case "M", "m" -> {
                int numMissiles = UserInput.inputInt(scanner, "Enter the plane's number of missiles: ");
                planeManager.addPlane(new MilitaryPlane(id, manufacturer, model, year, maxPassengers, maxSpeed, numMissiles));
            }
            default -> System.out.println("Invalid plane type. Please try again.");
        }
    }

    private static void removePlane(PlaneManager planeManager, Scanner scanner) {
        printAllPlanes(planeManager); // Print all planes first so the user can see the IDs

        String id = UserInput.inputString(scanner, "Enter the plane's ID: ");
        planeManager.removePlane(id);
    }

    private static void searchPlane(PlaneManager planeManager, Scanner scanner) {
        String id = UserInput.inputString(scanner, "Enter the plane's ID: ");
        Plane plane = planeManager.searchPlane(id);

        if (plane != null) {
            System.out.println(plane);
        } else {
            System.out.println("Plane not found.");
        }
    }

    private static void printAllPlanes(PlaneManager planeManager) {
        planeManager.printAllPlanes();
    }

    private static void printCommercialPlanes(PlaneManager planeManager) {
        planeManager.getCommercialPlanes().forEach(System.out::println);
    }

    private static void printMilitaryPlanes(PlaneManager planeManager) {
        planeManager.getMilitaryPlanes().forEach(System.out::println);
    }

    private static void printFastestPlane(PlaneManager planeManager) {
        System.out.println(planeManager.getFastestPlane());
    }
}
