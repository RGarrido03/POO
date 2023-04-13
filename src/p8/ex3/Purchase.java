package p8.ex3;

public interface Purchase {
    void addProduct(Product product, int quantity);
    void listPorducts();
    double calcTotal();
}
