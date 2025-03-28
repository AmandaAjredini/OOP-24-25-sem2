
public record Product(int id, String name, String category, String subCat, double price) {
    public Product {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative.\nProduct ID: " + id + "\nPrice: " + price);
        }
    }
}
