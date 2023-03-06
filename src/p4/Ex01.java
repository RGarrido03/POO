package p4;

import java.util.ArrayList;
import java.util.Scanner;
import utils.UserInput;

// TO-DO: There are a few exceptions that need to be handled.

public class Ex01 {
    private static int mainMenu(Scanner sc) {
        System.out.println("Choose an option:");
        System.out.println("1. Create a circle");
        System.out.println("2. Create a rectangle");
        System.out.println("3. Create a triangle");
        System.out.println("4. List current figures");
        System.out.println("5. Get the area of a figure");
        System.out.println("6. Get the perimeter of a figure");
        System.out.println("7. Compare figures");
        System.out.println("0. Exit");
        System.out.print(">> ");

        return UserInput.inputInt(sc, null);
    }

    private static void listFigures(ArrayList<Circle> circleArray, ArrayList<Rectangle> rectangleArray, ArrayList<Triangle> triangleArray) {
        if (circleArray.isEmpty() && rectangleArray.isEmpty() && triangleArray.isEmpty()) {
            System.out.println("There are no created figures.");
        } else {
            System.out.println("Current figures are:");
            for(int i = 0; i < circleArray.size(); i++) {
                System.out.println("-> C" + i + " | " + circleArray.get(i).toString());
            }
            for(int i = 0; i < rectangleArray.size(); i++) {
                System.out.println("-> R" + i + " | " + rectangleArray.get(i).toString());
            }
            for(int i = 0; i < triangleArray.size(); i++) {
                System.out.println("-> T" + i + " | " + triangleArray.get(i).toString());
            }
        }

        System.out.print("\n");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Circle> circleArray = new ArrayList<>();
        ArrayList<Rectangle> rectangleArray = new ArrayList<>();
        ArrayList<Triangle> triangleArray = new ArrayList<>();

        System.out.print("\033\143");
        while (true) {
            int opt = mainMenu(sc);

            switch (opt) {
                case 0:
                    return;
                case 1:
                    double radius = UserInput.inputDouble(sc, "\nInput the radius:");

                    try {
                        Circle circle = new Circle(radius);
                        circleArray.add(circle);

                        System.out.print("\033\143");
                        System.out.printf("Circle with radius %f has been added.\n\n", radius);
                    } catch (Exception e) {
                        System.out.print("\033\143");
                        System.out.printf("Exception %s.\nThe circle wasn't added.\n\n", e.toString());
                    }
                    
                    break;
                
                case 2:
                    double s1r = UserInput.inputDouble(sc, "Input the length:");
                    double s2r = UserInput.inputDouble(sc, "Input the height:");

                    try {
                        Rectangle rectangle = new Rectangle(s1r, s2r);
                        rectangleArray.add(rectangle);
    
                        System.out.print("\033\143");
                        System.out.printf("Rectangle %f x %f has been added.\n\n", s1r, s2r);
                    } catch (Exception e) {
                        System.out.print("\033\143");
                        System.out.printf("Exception %s.\nThe rectangle wasn't added.\n\n", e.toString());
                    }

                    break;

                case 3:
                    double s1t = UserInput.inputDouble(sc, "Input the 1st side:");
                    double s2t = UserInput.inputDouble(sc, "Input the 2nd side:");
                    double s3t = UserInput.inputDouble(sc, "Input the 3rd side:");

                    try {
                        Triangle triangle = new Triangle(s1t, s2t, s3t);
                        triangleArray.add(triangle);
    
                        System.out.print("\033\143");
                        System.out.printf("Triangle with sides %f, %f and %f has been added.\n\n", s1t, s2t, s3t);
                    } catch (Exception e) {
                        System.out.print("\033\143");
                        System.out.printf("Exception %s.\nThe triangle wasn't added.\n\n", e.toString());
                    }

                    break;
                
                case 4:
                    System.out.print("\033\143");
                    listFigures(circleArray, rectangleArray, triangleArray);
                    break;
                
                case 5:
                    System.out.print("\033\143");
                    listFigures(circleArray, rectangleArray, triangleArray);

                    String selection5 = UserInput.inputString(sc, "Input the figure index (e.g. R0):");
                    char type5 = selection5.charAt(0);
                    int idx5 = Character.getNumericValue(selection5.charAt(1));
                    System.out.print("\033\143");
                    switch (type5){
                        case 'C':
                            System.out.println("C" + idx5 + " area: " + circleArray.get(idx5).area());
                            break;
                        case 'R':
                            System.out.println("R" + idx5 + " area: " + rectangleArray.get(idx5).area());
                            break;
                        case 'T':
                            System.out.println("T" + idx5 + " area: " + triangleArray.get(idx5).area());
                            break;
                        default:
                            System.out.println("No selection made. Going back to main menu.");
                    }
                    System.out.print("\n");
                    break;

                case 6:
                    System.out.print("\033\143");
                    listFigures(circleArray, rectangleArray, triangleArray);

                    String selection6 = UserInput.inputString(sc, "Input the figure index (e.g. R0):");
                    char type6 = selection6.charAt(0);
                    int idx6 = Character.getNumericValue(selection6.charAt(1));
                    System.out.print("\033\143");
                    switch (type6){
                        case 'C':
                            System.out.println("C" + idx6 + " perimeter: " + circleArray.get(idx6).perimeter());
                            break;
                        case 'R':
                            System.out.println("R" + idx6 + " perimeter: " + rectangleArray.get(idx6).perimeter());
                            break;
                        case 'T':
                            System.out.println("T" + idx6 + " perimeter: " + triangleArray.get(idx6).perimeter());
                            break;
                        default:
                            System.out.println("No selection made. Going back to main menu.");
                    }
                    System.out.print("\n");
                    break;
                
                case 7:
                    System.out.print("\033\143");
                    listFigures(circleArray, rectangleArray, triangleArray);

                    String selection7 = UserInput.inputString(sc, "You can only compare figures of same shape.\nInput the figure indexes, separated by commas (e.g. R0,R1):");
                    String[] selection7Array = selection7.split(",");
                    char type7 = selection7Array[0].charAt(0);
                    System.out.print("\033\143");
                    switch (type7){
                        case 'C':
                            System.out.println(
                                circleArray.get(Character.getNumericValue(selection7Array[0].charAt(1))).equals(
                                    circleArray.get(Character.getNumericValue(selection7Array[1].charAt(1)))
                                )
                            );
                            break;
                        case 'R':
                            System.out.println(
                                rectangleArray.get(Character.getNumericValue(selection7Array[0].charAt(1))).equals(
                                    rectangleArray.get(Character.getNumericValue(selection7Array[1].charAt(1)))
                                )
                            );
                            break;
                        case 'T':
                            System.out.println(
                                triangleArray.get(Character.getNumericValue(selection7Array[0].charAt(1))).equals(
                                    triangleArray.get(Character.getNumericValue(selection7Array[1].charAt(1)))
                                )
                            );
                            break;
                        default:
                            System.out.println("No selection made. Going back to main menu.");
                    }
                    System.out.print("\n");
                    break;

                default:
                    System.out.print("\033\143");
                    System.out.println("No selection made.\n");
                    break;
            }
        }
    }
}
