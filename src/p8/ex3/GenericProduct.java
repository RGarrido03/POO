package p8.ex3;

public class GenericProduct implements Product {
    private final String name;
    private final double price;
    private int quantity;

    GenericProduct(String name, double price, int quantity) {
        this.name = name;

        if (price < 0) throw new IllegalArgumentException("Price must be non-negative.");
        this.price = price;

        if (quantity < 0) throw new IllegalArgumentException("Quantity must be non-negative.");
        this.quantity = quantity;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public int getQuantity() {
        return this.quantity;
    }

    @Override
    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }

    @Override
    public void removeQuantity(int quantity) {
        if (this.quantity - quantity < 0) throw new IllegalArgumentException("Quantity won't be non-negative.");
        this.quantity -= quantity;
    }

    @Override
    public String toString() {
        return this.name + ": price " + this.price + ", quantity " + this.quantity;
    }
}
