/*
 *    n   |     Hn |  log n |  Hn - log n
 *    1   |  1,000 |  0,000 | 1,000000000
 *    2   |  1,500 |  0,693 | 0,806852819
 *    4   |  2,083 |  1,386 | 0,697038972
 *    8   |  2,718 |  2,079 | 0,638415601
 *   16   |  3,381 |  2,773 | 0,608140271
 *    .        .        .          .
 *    .        .        .          .
 *    .        .        .          .
 * 524288 | 13,747 | 13,170 | 0,577216619
 */

package Homework; // Ignore this, folder structure related

public class Table {
    public static void main(String[] args) {
        System.out.printf("%6s | %6s | %6s | %11s\n", "n", "Hn", "log n", "Hn - log n");
        int n = 1;

        while (n <= 1000000) {
            double f1 = harmonic(n);
            double f2 = Math.log((double)n);
            double f3 = f1 - f2;
            System.out.printf("%6d | %6.3f | %6.3f | %11.9f\n", n, f1, f2, f3);
            n *= 2;
        }
    }
 
    // Computes the Harmonic number Hn = 1 + 1/2 + 1/3 + ... + 1/n.
    public static double harmonic(int n) {
        double sum = 0;
        
        for (int i = 1; i <= n; i++) {
            sum += (double)1/i;
        }
        
        return sum;
    }
} 