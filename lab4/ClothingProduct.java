public class ClothingProduct extends Product {
    public int washTemperature;

    public ClothingProduct( String name,
                            String desc,
                            String RRP,
                            String temp) {
        super(name, desc, RRP);
        this.washTemperature = Integer.parseInt(temp);
    }

    public String toString() {
        return super.toString() + ",\nWash Temperature: " + washTemperature + "°C";
    }
}