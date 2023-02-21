package p2;
import java.util.Scanner;
import utils.UserInput;

public class EnergyToHeatWater {
    public static void main(String[] args) {
        double weight, initialTemp, finalTemp, energy;
        Scanner sc = new Scanner(System.in);

        weight = UserInput.inputDoublePositive(sc, "Input the weight of the water:");
        initialTemp = UserInput.inputDoublePositive(sc, "Input the initial temperature:");
        finalTemp = UserInput.inputDoublePositive(sc, "Input the final temperature:");
        sc.close();

        energy = weight * (finalTemp - initialTemp) * 4184;
        System.out.printf("You'll need %f Joules of energy to heat %f liters/kgs of water, from %fºC to %fºC.\n", energy, weight, initialTemp, finalTemp);
    }
}
