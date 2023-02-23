package tp2;

public class ReverseArray {
    public static void main(String[] args) {
        final int LENGTH = 100;
        int[] a = new int[LENGTH];

        for (int i = LENGTH - 1; i <= 0; i--) {
            System.out.print(a[i]);
            if (i > 0) {
                System.out.print(", ");
            }
        }
    }
}
