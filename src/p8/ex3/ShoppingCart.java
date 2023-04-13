package p8.ex3;

import java.util.HashMap;

public class ShoppingCart implements Purchase {
    HashMap<Product, Integer> productHashMap = new HashMap<>();

    @Override
    public void addProduct(Product product, int quantity) {
        if (!productHashMap.containsKey(product)) {
            productHashMap.put(product, quantity);
        } else {
            productHashMap.put(product, productHashMap.get(product) + quantity);
        }
    }

    @Override
    public void listPorducts() {
        for (Product product : productHashMap.keySet()) {
            System.out.println(product);
        }
    }

    @Override
    public double calcTotal() {
        double sum = 0;
        for (Product product : productHashMap.keySet()) {
            sum += product.getPrice() * productHashMap.get(product);
        }
        return sum;
    }
}
