package utils;

public class Maths {
    public static boolean isPrime(int n) {
        int divisors = 2;
        int i = 2;
        
        do {
            if (n % i == 0 && i != n) {
                divisors++;
            }
            i++;
        } while (i < n && divisors == 2);

        return (divisors == 2) ? true : false;
    }
}
