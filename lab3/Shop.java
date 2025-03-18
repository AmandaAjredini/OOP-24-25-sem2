public class Shop {
    private Product[] products;
    private int productCount; // Keep track of number of products

    // Constructor initialises the array with fixed size of 10
    public Shop(int maxProducts) {
        this.products = new Product[maxProducts];
        this.productCount = 0;
    }

    // Add a product
    public void addProduct(String name, String description, int stock) {
        if (productCount < products.length) {
            products[productCount++] = new Product(name, description, stock);
            System.out.println(name + " added.");
        } else {
            System.out.println("Shop is full.");
        }
    }

    // Remove a product
    public void removeProduct(String name) {
        for (int i = 0; i < productCount; i++) {
            if (products[i].getName() == name) {
                products[i] = products[productCount - 1]; // Replace with last product
                products[--productCount] = null; // Reduce count and clear last slot
                System.out.println(name + " removed.");
                return;
            }
        }
        System.out.println(name + " not found.");
    }

    // Restock a product
    public void restockProduct(String name, int quantity) {
        for (int i = 0; i < productCount; i++) {
            if (products[i].getName() == name) {
                products[i].setStock(products[i].getStock() + quantity);
                System.out.println(name + " restocked. New stock: " + products[i].getStock());
                return;
            }
        }
        System.out.println(name + " not found.");
    }

    // Sell a product
    public void sellProduct(String name, int quantity) {
        for (int i = 0; i < productCount; i++) {
            if (products[i].getName() == name) {
                if (products[i].getStock() < quantity) {
                    System.out.println("Not enough stock for " + name + ". Available: " + products[i].getStock());
                    return;
                }

                products[i].setStock(products[i].getStock() - quantity);
                System.out.println(quantity + " " + name + "(s) sold. Remaining stock: " + products[i].getStock());
                return;
            }
        }
        System.out.println(name + " not found.");
    }

    // Print all products
    public void printProductList() {
        System.out.println("\nProduct List:");
        for (int i = 0; i < productCount; i++) {
            System.out.println(products[i]);
        }
        
        System.out.println();
    }
}
