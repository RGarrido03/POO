package p4;
import java.util.Scanner;

class SimpleCar {
    private String make;
    private String model;
    private int year;
    private int kms;

    public SimpleCar(String make, String model, int year, int kms) {
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

public class SimpleCarDemo {

    static Scanner sc = new Scanner(System.in);

    static void listCars(Car[] cars) {
        // Exemplo de resultado
        // Carros registados: 
        // Renault Megane Sport Tourer, 2015, kms: 35356
        // Toyota Camry, 2010, kms: 32456
        // Mercedes Vito, 2008, kms: 273891

        System.out.println("Carros registados:");
        for (int i = 0; i < cars.length; i++) {
            System.out.println(cars[i].getMake() +
                " " + cars[i].getModel() +
                ", " + cars[i].getYear() +
                ", kms: " + cars[i].getKms()
            );
        }
    }

    public static void main(String[] args) {

        Car[] cars = new Car[3];
        cars[0] = new Car("Renault", "Mégane Sport Tourer", 2015, 35356);
        cars[1] = new Car("Toyota", "Camry", 2010, 32456);
        cars[2] = new Car("Mercedes", "Vito", 2008, 273891);

        listCars(cars);

        // Adicionar 10 viagens geradas aleatoriamente
        for (int i=0; i<10; i++) {
            int j = (int)Math.round(Math.random()*2); // escolhe um dos 3 carros
            int kms = (int)Math.round(Math.random()*1000); // viagem até 1000 kms
            System.out.printf("Carro %d viajou %d quilómetros.\n", j, kms);
            
            cars[j].drive(kms);
        }

        listCars(cars);

        sc.close();

    }
}