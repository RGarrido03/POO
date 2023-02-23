package tp2;

public class Numbers {
    public static void main(String[] args) {
        int[] values = {3, 1, 4, 1, 5, 9}; // Other arrays will be substitute this one here.
        int newLength = values.length / 2;
        int[] newValues = new int[newLength];
        int i;

        for (i = 0; i < newLength; i++) {
            newValues[i] = values[2 * i];
        }

        for (i = 0; i < newLength; i++) {
            System.out.println(newValues[i]);
        }
    }
}
