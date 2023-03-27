package p7;

import utils.UserInput;
import java.util.ArrayList;
import java.util.Scanner;

// TODO: There are a few exceptions that need to be handled.

public class Ex01 {
    private static int mainMenu(Scanner sc) {
        System.out.print("""
            Choose an option:
            1. Create a circle
            2. Create a rectangle
            3. Create a triangle
            4. List current figures
            5. Get the area of a figure
            6. Get the perimeter of a figure
            7. Compare figures
            0. Exit
            >>\s"""
        );
        return UserInput.inputInt(sc, null);
    }

    private static void listFigures(ArrayList<Shape> shapeArray) {
        System.out.print("\033\143");

        if (shapeArray.isEmpty()) {
            System.out.println("There are no created figures.");
        } else {
            System.out.println("Current figures are:");
            for(int i = 0; i < shapeArray.size(); i++) {
                System.out.println(i + " | " + shapeArray.get(i).toString());
            }
        }

        System.out.print("\n");
    }

    private static String askForColor(Scanner sc) {
        String color = UserInput.inputString(sc, "Input the color:").toLowerCase();
        return color.substring(0, 1).toUpperCase() + color.substring(1);
    }

    private static void addCircle(Scanner sc, ArrayList<Shape> shapeArray) {
        double radius = UserInput.inputDouble(sc, "\nInput the radius:");

        try {
            Circle circle = new Circle(radius, askForColor(sc));
            shapeArray.add(circle);

            System.out.print("\033\143");
            System.out.printf(circle.getColor() + " circle with radius %f has been added.\n\n", radius);
        } catch (Exception e) {
            System.out.print("\033\143");
            System.out.printf("Exception %s.\nThe circle wasn't added.\n\n", e.getMessage());
        }
    }

    private static void addRectangle(Scanner sc, ArrayList<Shape> shapeArray) {
        double s1r = UserInput.inputDouble(sc, "Input the length:");
        double s2r = UserInput.inputDouble(sc, "Input the height:");

        try {
            Rectangle rectangle = new Rectangle(s1r, s2r, askForColor(sc));
            shapeArray.add(rectangle);

            System.out.print("\033\143");
            System.out.printf(rectangle.getColor() + " %fx%f rectangle has been added.\n\n", s1r, s2r);
        } catch (Exception e) {
            System.out.print("\033\143");
            System.out.printf("Exception %s.\nThe rectangle wasn't added.\n\n", e.getMessage());
        }
    }

    private static void addTriangle(Scanner sc, ArrayList<Shape> shapeArray) {
        double s1t = UserInput.inputDouble(sc, "Input the 1st side:");
        double s2t = UserInput.inputDouble(sc, "Input the 2nd side:");
        double s3t = UserInput.inputDouble(sc, "Input the 3rd side:");

        try {
            Triangle triangle = new Triangle(s1t, s2t, s3t, askForColor(sc));
            shapeArray.add(triangle);

            System.out.print("\033\143");
            System.out.printf(triangle.getColor() + " triangle with sides %f, %f and %f has been added.\n\n", s1t, s2t, s3t);
        } catch (Exception e) {
            System.out.print("\033\143");
            System.out.printf("Exception %s.\nThe triangle wasn't added.\n\n", e.getMessage());
        }
    }

    private static void getArea(Scanner sc, ArrayList<Shape> shapeArray) {
        System.out.print("\033\143");
        listFigures(shapeArray);

        int idx = UserInput.inputIntPositive(sc, "Input the figure index (e.g. 0):");
        System.out.print("\033\143");

        if (idx <= shapeArray.size()) {
            System.out.println("Figure " + idx + " area: " + shapeArray.get(idx).area() + "\n");
        } else {
            System.out.println("Index out of bounds.\n");
        }
    }

    private static void getPerimeter(Scanner sc, ArrayList<Shape> shapeArray) {
        System.out.print("\033\143");
        listFigures(shapeArray);

        int idx = UserInput.inputIntPositive(sc, "Input the figure index (e.g. 0):");
        System.out.print("\033\143");

        if (idx <= shapeArray.size()) {
            System.out.println("Figure " + idx + " area: " + shapeArray.get(idx).perimeter() + "\n");
        } else {
            System.out.println("Index out of bounds.\n");
        }
    }

    private static void compareFigures(Scanner sc, ArrayList<Shape> shapeArray) {
        System.out.print("\033\143");
        listFigures(shapeArray);

        String selection = UserInput.inputString(sc, "You can only compare figures of same shape.\nInput the figure indexes, separated by commas (e.g. 0,2):");
        int idx1 = Integer.parseInt(selection.substring(0,1));
        int idx2 = Integer.parseInt(selection.substring(2,3));

        System.out.print("\033\143");
        if (idx1 <= shapeArray.size() && idx2 <= shapeArray.size()) {
            Shape shape1 = shapeArray.get(idx1);
            Shape shape2 = shapeArray.get(idx2);

            if (shape1.getClass().getName().equals(shape2.getClass().getName())) {
                System.out.println(shapeArray.get(idx1).equals(shapeArray.get(idx2)) + "\n");
            } else {
                System.out.println("Shapes are not from same type.");
            }
        } else {
            System.out.println("Indexes out of bounds.\n");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Shape> shapeArray = new ArrayList<>();

        while (true) {
            int opt = mainMenu(sc);
            switch (opt) {
                case 0 -> { return; }
                case 1 -> addCircle(sc, shapeArray);
                case 2 -> addRectangle(sc, shapeArray);
                case 3 -> addTriangle(sc, shapeArray);
                case 4 -> listFigures(shapeArray);
                case 5 -> getArea(sc, shapeArray);
                case 6 -> getPerimeter(sc, shapeArray);
                case 7 -> compareFigures(sc, shapeArray);
                default -> {
                    System.out.print("\033\143");
                    System.out.println("No selection made.\n");
                }
            }
        }
    }
}
