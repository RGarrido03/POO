package p4;
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
        return true;
    }

    static int registerCars(Car[] cars) {
        String input, make;
        String[] tmp;
        int year, kms;
        int i = 0;

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
    
                System.out.println(make + model.toString() + year + kms);
                cars[i] = new Car(make, model.toString(), year, kms);
            } else {
                System.out.println("Dados mal formatados. Tente novamente.");
            }

            i++;
        } while (input != "");
        
        return cars.length;
    }

    static void registerTrips(Car[] cars, int numCars) {
        // TODO: pede dados das viagens ao utilizador e atualiza informação do carro
        // registo de viagens termina quando o utilizador inserir uma linha vazia 
        System.out.print("Registe uma viagem no formato \"carro:distância\": ");
    }


    static void listCars(Car[] cars) {
        System.out.println("\nCarros registados: ");
        // TODO: lista todos os carros registados
        // Exemplo de resultado
        // Carros registados: 
        // Toyota Camry, 2010, kms: 234346
        // Renault Megane Sport Tourer, 2015, kms: 32536
        
        System.out.println("\n");
    }

    public static void main(String[] args) {

        Car[] cars = new Car[10];

        int numCars = registerCars(cars);

        if (numCars>0) {
            listCars(cars);
            registerTrips(cars, numCars);
            listCars(cars);
        }

        sc.close();

    }
}