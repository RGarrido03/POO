package p4;
import java.util.ArrayList;
import java.util.Scanner;

import utils.UserInput;

class Car {
    private String make;
    private String model;
    private int year;
    private int kms;

    public Car(String make, String model, int year, int kms) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.kms = kms;
    }

    public void drive(int distance) {
        this.kms += distance;
    }

    public String getMake() { return make; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    public int getKms() { return kms; }
}

public class CarDemo {

    static Scanner sc = new Scanner(System.in);

    static Boolean verifyRegister(String input) {
        /*
         * \\p{L} verifies all Unicode letter characters.
         * \\p{Space} represents the space character, aka " ".
         * \\d verifies numbers. This is also included in the car model's part, because of cars like "Peugeot 3008".
         */
        return input.matches("^[\\p{L}]+([\\p{Space}][\\p{L}\\d]+)*[\\p{Space}]\\d{4}[\\p{Space}]\\d+$");
    }

    static int registerCars(ArrayList<Car> cars) {
        String input, make;
        String[] tmp;
        int year, kms;

        System.out.print("Insira dados do carro (marca modelo ano quilómetros): ");
        do {
            input = UserInput.inputString(sc, null);
            
            if (input == "") {
                break;
            }
            else if (verifyRegister(input)) {
                tmp = input.split(" ");
    
                make = tmp[0];
                year = Integer.parseInt(tmp[tmp.length - 2]);
                kms = Integer.parseInt(tmp[tmp.length - 1]);
    
                StringBuilder model = new StringBuilder();
                for (int j = 1; j < tmp.length - 3; j++) {
                    model.append(tmp[j] + " ");
                }
                model.append(tmp[tmp.length - 3]);
                
                cars.add(new Car(make, model.toString(), year, kms));
            } else {
                System.out.println("Dados mal formatados. Tente novamente.");
            }
        } while (input != "");
        
        return cars.size();
    }

    static void registerTrips(ArrayList<Car> cars, int numCars) {
        String input;
        System.out.print("Registe uma viagem no formato \"carro:distância\": ");

        do {
            input = UserInput.inputString(sc, null);
            
            if (input == "") {
                break;
            } else if (input.matches("\\d+:\\d+")) {
                String[] temp = input.split(":");
                int idx = Integer.parseInt(temp[0]);
                if (idx >= 0 && idx < numCars) {
                    cars.get(idx)
                        .drive(Integer.parseInt(temp[1]));
                } else {
                    System.out.println("Índice incorreto.");
                }
            } else {
                System.out.println("Dados mal formatados. Tente novamente.");
            }
        } while (input != "");
    }


    static void listCars(ArrayList<Car> cars) {
        System.out.println("\nCarros registados: ");
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            System.out.printf("%s %s, %d, kms: %d\n", car.getMake(), car.getModel(), car.getYear(), car.getKms());
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {

        ArrayList<Car> cars = new ArrayList<>();
        int numCars = registerCars(cars);

        if (numCars > 0) {
            listCars(cars);
            registerTrips(cars, numCars);
            listCars(cars);
        }

        sc.close();

    }
}