public class FoodProduct extends Product {
    public String timeToExpiry;

    public FoodProduct( String name,
                        String desc,
                        String RRP,
                        String expiry) {
        super(name, desc, RRP);
        this.timeToExpiry = expiry;
    }

    public String toString() {
        return super.toString() + "\nExpiry: " + timeToExpiry;
    }
}
