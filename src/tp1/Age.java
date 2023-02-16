package tp1;

import java.util.Scanner;
import java.time.Year;

public class Age {
    final static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        // Find last year
        int lastyear = Year.now().getValue() - 1;

        System.out.print("Em que ano nasceste? ");
        int birth = Integer.parseInt(in.nextLine());

        System.out.print("Como te chamas? ");
        String name = in.nextLine();

        int diff = lastyear - birth;
        System.out.printf("Olá, %s! Em 2022, fizeste %d anos.\n", name, diff);
    }
}
