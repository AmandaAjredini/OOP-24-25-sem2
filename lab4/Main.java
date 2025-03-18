public class Main {
    public static void main(String[] args) {
        // Creating food and clothing products
        String[][] foodProds = {
            {"Apple", "Fresh red apple", "1.50", "25/02/2025"},
            {"Bread", "Whole grain bread", "2.00", "23/02/2025"},
            {"Milk", "1L semi-skimmed milk", "1.20", "28/02/2025"}
        };

        String[][] clothingProds = {
            {"T-Shirt", "Cotton white t-shirt", "15.00", "30"},
            {"Jeans", "Blue denim jeans", "40.00", "40"},
            {"Jacket", "Winter waterproof jacket", "60.00", "30"}
        };

        // Creating catalogue
        Catalogue myCatalogue = new Catalogue(foodProds, clothingProds);

        // Creating shop
        Shop myShop = new Shop();

        // Searching for two food and two clothing products
        Product p1 = myCatalogue.getProductByName("Apple");
        Product p2 = myCatalogue.getProductByName("Milk");
        Product p3 = myCatalogue.getProductByName("T-Shirt");
        Product p4 = myCatalogue.getProductByName("Jeans");

        // Adding found products to the shop with specified amounts
        myShop.addProduct(p1, 8);
        myShop.addProduct(p2, 6);
        myShop.addProduct(p3, 3);
        myShop.addProduct(p4, 7);

        // Testing all methods of Shop
        System.out.println("\nFood Products in my Shop:");
        myShop.printProducts("food");

        System.out.println("\nClothing Products in my Shop:");
        myShop.printProducts("clothing");

        System.out.println("\nTotal Price of my Shop: " + String.format("%.2f", myShop.currentValue()));
    }
}
