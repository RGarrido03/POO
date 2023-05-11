package p11.ex3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.*;

public class EnergyUsageReport {

    Map<Integer, Customer> customerMap = new TreeMap<>();

    public void load(String path) throws FileNotFoundException {
        Scanner input = new Scanner(new FileReader(path));
        input.useDelimiter("[|\\n]");
        int id;

        while (input.hasNext()) {
            id = Integer.parseInt(input.next());

            customerMap.put(
                id,
                new Customer(
                    id,
                    Arrays.asList(
                        Double.parseDouble(input.next()),
                        Double.parseDouble(input.next()),
                        Double.parseDouble(input.next()),
                        Double.parseDouble(input.next())
                    )
                )
            );
        }
    }

    public void addCustomer(Customer customer) {
        customerMap.put(customer.getCustomerId(), customer);
    }

    public void removeCustomer(int id) {
        customerMap.remove(id);
    }

    public Customer getCustomer(int id) {
        return customerMap.get(id);
    }

    public double calculateTotalUsage(int id) {
        double sum = 0;

        for (double reading : customerMap.get(id).getMeterReadings()) {
            sum += reading;
        }

        return sum;
    }

    public void generateReport(String path) throws FileNotFoundException {
        try (PrintWriter out = new PrintWriter(path)) {
            int id;

            for (Customer customer : customerMap.values()) {
                id = customer.getCustomerId();
                out.printf("%4d | %.2f\n", id, calculateTotalUsage(id));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Exiting...");
            System.exit(1);
        }
    }
}
