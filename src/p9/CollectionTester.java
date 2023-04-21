package p9;

import java.util.*;

public class CollectionTester {
    public static void main(String[] args) {
        ArrayList<Collection<Integer>> collectionArray = new ArrayList<>();
        collectionArray.add(new ArrayList<>());
        collectionArray.add(new LinkedList<>());
        collectionArray.add(new HashSet<>());
        collectionArray.add(new TreeSet<>());

        int[] dimArray = {1000, 5000, 10000, 20000, 40000, 100000};
        double[][] times = new double[dimArray.length][3];
        String[] methods = {"add", "search", "remove"};

        // Print header
        System.out.print("Collection");
        for (int dim : dimArray) System.out.printf("    %6d", dim);
        System.out.println();

        for (Collection<Integer> col : collectionArray) {
            // Get times
            for (int i = 0; i < dimArray.length; i++) {
                times[i] = checkPerformance(col, dimArray[i]);
            }

            // Print data structure name
            System.out.println(col.getClass().getName());

            // Print values
            for (int i = 0; i < 3; i++) {
                System.out.printf("%-10s", methods[i]); // print method name
                for (int j = 0; j < dimArray.length; j++) {
                    System.out.printf("    %6.1f", times[j][i]); // print time
                }
                System.out.println();
            }
        }
    }

    private static double[] checkPerformance(Collection<Integer> col, int DIM) {
        double start, stop, delta;
        double[] ret = new double[3];

        // Add
        start = System.nanoTime(); // clock snapshot before
        for (int i = 0; i < DIM; i++)
            col.add(i);
        stop = System.nanoTime(); // clock snapshot after
        delta = (stop - start) / 1e6; // convert to milliseconds
        ret[0] = delta;

        // Search
        start = System.nanoTime(); // clock snapshot before
        for(int i=0; i<DIM; i++ ) {
            int n = (int) (Math.random()*DIM);
            if (!col.contains(n))
                System.out.println("Not found???"+n);
        }
        stop = System.nanoTime(); // clock snapshot after
        delta = (stop - start) / 1e6; // convert nanoseconds to milliseconds
        ret[1] = delta;

        // Remove
        start = System.nanoTime(); // clock snapshot before
        Iterator<Integer> iterator = col.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        stop = System.nanoTime(); // clock snapshot after
        delta = (stop - start) / 1e6; // convert nanoseconds to milliseconds
        ret[2] = delta;

        return ret;
    }
}