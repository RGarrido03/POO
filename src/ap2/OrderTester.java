package ap2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderTester {
    public static void main(String[] args) {
        OrderManager orderManager = new OrderManager();
        Scanner input = null;

        //
        // Add order
        //

        orderManager.addOrder(
            new Order(
                "2",
                "3",
                List.of(
                    new Item("Torrada", 2),
                    new Item("Meia de leite", 3),
                    new Item("Água com gás", 2.5)
                ),
                LocalDateTime.of(2023, 5, 25, 15, 7),
                true
            )
        );

        //
        // Read data from file
        //

        try {
            input = new Scanner(new File("resources/pedidos.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Exiting...");
            System.exit(1);
        }

        input.useDelimiter("[\\r\\n;]+");
        input.nextLine(); // Discard header

        while (input.hasNext()) {
            String clientId = input.next();
            String storeId = input.next();

            List<Item> itemList = new ArrayList<>();
            String[] itemListStringArray = input.next().split("\\|");

            for (String itemString: itemListStringArray) {
                String[] itemStringArray = itemString.split(":");
                itemList.add(
                    new Item(
                        itemStringArray[0],
                        Double.parseDouble(itemStringArray[1])
                    )
                );
            }

            String[] orderDateString = input.next().split("[ \\-:]+");
            LocalDateTime orderDateTime = LocalDateTime.of(
                Integer.parseInt(orderDateString[0]),
                Integer.parseInt(orderDateString[1]),
                Integer.parseInt(orderDateString[2]),
                Integer.parseInt(orderDateString[3]),
                Integer.parseInt(orderDateString[4])
            );
            boolean isExpress = input.next().equalsIgnoreCase("expresso");

            orderManager.addOrder(
                new Order(
                    clientId,
                    storeId,
                    itemList,
                    orderDateTime,
                    isExpress
                )
            );
        }

        //
        // Other tests
        //

        // Remove order
        orderManager.removeOrder(0);

        // Search order
        System.out.println(orderManager.searchOrder(1));

        // Print all orders
        orderManager.printAllOrders();

        // Calculate the cost for order with ID 1
        System.out.println(orderManager.calculateOrderCost(1));

        // Test -1 when order doesn't exist
        System.out.println(orderManager.calculateOrderCost(5000));

        // Calculate cost of all orders for a month
        double costSum = 0;
        for (Order order : orderManager.getOrders()) {
            if (order.getOrderDateTime().isAfter(LocalDateTime.of(2023, 5, 1, 0, 0))
                && order.getOrderDateTime().isBefore(LocalDateTime.of(2023, 6, 1, 0, 0))
            ) {
                costSum += order.getTotalValue();
            }
        }
        System.out.println(costSum);

        // Print the list of existing orders to a file
        try (PrintWriter out = new PrintWriter("resources/ordersWrite.txt")) {
            out.println(orderManager);
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Exiting...");
            System.exit(1);
        }
    }
}
