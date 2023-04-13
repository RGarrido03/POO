package p8.ex3;

public class ProductWithDiscount extends GenericProduct {
    private final int discount;

    ProductWithDiscount(String name, double price, int quantity, int discount) {
        super(name, price, quantity);
        if (discount < 0) throw new IllegalArgumentException("Discount must be non-negative.");
        this.discount = discount;
    }

    @Override
    public String toString() {
        return super.toString() + ", discount " + this.discount;
    }
}
