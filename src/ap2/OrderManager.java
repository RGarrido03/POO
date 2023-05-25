package ap2;

import java.util.Collection;
import java.util.TreeMap;

public class OrderManager {
    private final TreeMap<Integer, Order> orderTreeMap = new TreeMap<>();
    private final StandardOrderCostCalculator standardOrderCostCalculator = new StandardOrderCostCalculator();

    public void addOrder(Order order) {
        orderTreeMap.put(order.getId(), order);
    }

    public void removeOrder(int id) {
        orderTreeMap.remove(id);
    }

    public Order searchOrder(int id) {
        return orderTreeMap.getOrDefault(id, null);
    }

    public Collection<Order> getOrders() {
        return orderTreeMap.values();
    }

    public double calculateOrderCost(int id) {
        if (orderTreeMap.containsKey(id)) {
            return standardOrderCostCalculator.calculateOrderCost(orderTreeMap.get(id));
        } else {
            return -1;
        }
    }

    public void printAllOrders() {
        for (Order order : orderTreeMap.values()) {
            System.out.println(order.toString());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Order order : orderTreeMap.values()) {
            sb.append(order.toString()).append("\n");
        }

        return sb.toString();
    }
}