interface Asset {
    double currentValue();
}

class StoredProduct {
    public Product product;
    public int stock;
    public double price;

    public StoredProduct(Product product, int stock, double price) {
        this.product = product;
        this.stock = stock;
        this.price = price;
    }

    public String toString() {
        return product + "\nStock: " + stock + "\nPrice: " + String.format("%.2f", price);
    }
}

public class Shop implements Asset{
    public StoredProduct[] products;
    public int count; // Tracks number of products added

    public Shop() {
        this.products = new StoredProduct[5];
        this.count = 0;
    }

    public void addProduct(Product p, int amount) {
        if (count < products.length) {
            products[count++] = new StoredProduct(p, amount, p.RRP);
        } else {
            System.out.println("Shop is full. Cannot add more products.");
        }
    }

    public void printProducts(String type) {
        for (StoredProduct sp : products) {
            if (sp != null) {
                switch (type) {
                    case "food":
                        if (sp.product instanceof FoodProduct) {
                            System.out.println(sp);
                        }
                        break;
                    case "clothing":
                        if (sp.product instanceof ClothingProduct) {
                            System.out.println(sp);
                        }
                        break;
                    default:
                        System.out.println("Product type is invalid.");
                        return;  
                }
            }
        }
    }

    public double currentValue() {
        double total = 0;

        for (StoredProduct sp : products) {
            if (sp != null) {
                total += sp.stock * sp.price;  
            }
        }

        return total;
    }

}