package p4;
import java.util.ArrayList;

class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double getTotalValue() {
        return price * quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int  getQuantity() {
        return quantity;
    }
}


class CashRegister {
    private ArrayList<Product> products = new ArrayList<Product>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public int getSize() {
        return products.size();
    }

    public ArrayList<Product> getProductsArrayList() {
        return products;
    }
}

public class CashRegisterDemo {

    public static void main(String[] args) {

        // Cria e adiciona 5 produtos
        CashRegister cr = new CashRegister();
        cr.addProduct(new Product("Book", 9.99, 3));
        cr.addProduct(new Product("Pen", 1.99, 10));
        cr.addProduct(new Product("Headphones", 29.99, 2));
        cr.addProduct(new Product("Notebook", 19.99, 5));
        cr.addProduct(new Product("Phone case", 5.99, 1));
        
        // Listar o conteúdo e valor total
        ArrayList<Product> productsArrayList = cr.getProductsArrayList();

        System.out.printf("%-15s  %s  %s  %s\n", "Product", "Price", "Quantity", "Total");
        for(int i = 0; i < cr.getSize(); i++) {
            System.out.printf("%-15s  %5.2f  %8d  %5.2f\n",
                productsArrayList.get(i).getName(),
                productsArrayList.get(i).getPrice(),
                productsArrayList.get(i).getQuantity(),
                productsArrayList.get(i).getQuantity() * productsArrayList.get(i).getPrice()
            );
        }
    }
}