package ap2;

public class StandardOrderCostCalculator implements OrderCostCalculator {
    @Override
    public double calculateOrderCost(Order order) {
        return order.getTotalValue();
    }
}
