public class Product {
    private String name;
    private String description;
    private int stock;

    // Constructor
    public Product(String name, String description, int stock) {
        this.name = name;
        this.description = description;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() { // Overriding Object's toString()
        return name + " - " + description + " (Stock: " + stock + ")";
    }
}
