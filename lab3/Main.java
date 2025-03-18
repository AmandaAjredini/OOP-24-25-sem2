public class Main {
    public static void main(String[] args) {
        // Create shop with a max of 10 products (can be adjusted)
        Shop shop = new Shop(10);

        // Add products using shop.addProduct()
        shop.addProduct("milk", "Fresh from the farm", 10);
        shop.addProduct("bread", "Fresh from the baker", 4);
        shop.addProduct("tea", "Box of 100 teabags", 1);
        shop.addProduct("eggs", "A dozen per box", 33);
        shop.addProduct("ice cream", "1l box, vanilla", 2);

        // Print initial products
        shop.printProductList();

        // Test shop functionality
        shop.sellProduct("milk", 2);
        shop.sellProduct("tea", 1);
        shop.sellProduct("bread", 5); // Not enough stock

        shop.restockProduct("bread", 10);
        shop.removeProduct("ice cream");

        // Print updated products
        shop.printProductList();
    } 
}
