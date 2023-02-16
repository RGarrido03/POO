package p2_lastyear;
import java.util.Scanner;

public class EnergyToHeatWater {
    public static void main(String[] args) {
        double weight, initialTemp, finalTemp, energy;
        Scanner sc = new Scanner(System.in);

        System.out.print("Input the weight of the water: ");
        weight = Double.parseDouble(sc.nextLine());

        System.out.print("Input the initial temperature: ");
        initialTemp = Double.parseDouble(sc.nextLine());
        
        System.out.print("Input the final temperature: ");
        finalTemp = Double.parseDouble(sc.nextLine());

        sc.close();

        energy = weight * (finalTemp - initialTemp) * 4184;
        System.out.printf("You'll need %f Joules of energy to heat %f liters/kgs of water, from %fºC to %fºC.\n", energy, weight, initialTemp, finalTemp);
    }
}
