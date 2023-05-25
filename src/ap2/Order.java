package ap2;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private static int idCount = 0;
    private final int id;
    private final List<Item> itemList;
    private final String storeId;
    private final String clientId;
    private final LocalDateTime orderDateTime;
    private final boolean isExpress;

    public int getId() {
        return id;
    }

    public Order(String clientId, String storeId, List<Item> itemList, LocalDateTime orderDateTime, boolean isExpress) {
        this.id = idCount++;
        this.itemList = itemList;
        this.storeId = storeId;
        this.clientId = clientId;
        this.orderDateTime = orderDateTime;
        this.isExpress = isExpress;
    }

    public LocalDateTime getOrderDateTime() {
        return orderDateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String itemListString = this.itemList.toString().replace(", ", "|");

        sb.append(this.clientId)
            .append(";")
            .append(this.storeId)
            .append(";")
            .append(itemListString, 1, itemListString.length() - 1)
            .append(";")
            .append(this.orderDateTime.toString().replace('T', ' '))
            .append(";")
            .append(this.isExpress ? "expresso" : "normal");

        return sb.toString();
    }

    public double getTotalValue() {
        double sum = 0;

        for (Item item : this.itemList) {
            sum += item.getPrice();
        }

        if (this.isExpress) {
            sum *= 1.3;
        }

        return sum;
    }
}
