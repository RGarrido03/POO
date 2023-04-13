package p8.ex3;

public class ShoppingCartTester {
    public static void main(String[] args) {
        Product p1 = new GenericProduct("Camisolas", 10, 3);
        Product p2 = new GenericProduct("Calças", 30, 1);
        Product p3 = new ProductWithDiscount("Sapatilhas", 50, 2, 50);
        Product p4 = new ProductWithDiscount("Casacos", 100, 1, 10);

        ShoppingCart carrinho = new ShoppingCart();
        carrinho.addProduct(p1, 1);
        carrinho.addProduct(p2, 5);
        carrinho.addProduct(p3, 2);
        carrinho.addProduct(p4, 1);

        carrinho.listPorducts();
        System.out.printf("Preço total da compra %.2f\n", carrinho.calcTotal());
    }
}