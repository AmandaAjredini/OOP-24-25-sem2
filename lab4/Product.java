public class Product {
    public String name;
    public String description;
    public double RRP;
    public int catalogueID;

    private static int count = 1;

    public Product(String name, String desc, String RRP) {
        this.name = name;
        this.description = desc;
        this.RRP = Double.parseDouble(RRP);
        this.catalogueID = catIdGen();
    }

    public static int catIdGen() {
        return count++;
    }

    public String toString() {
        return "\nProduct: " + name + "\nCatalogue ID: " + catalogueID + "\nDescription: " + description;
    }
}


