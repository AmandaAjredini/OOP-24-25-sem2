// Abstract class representing a pet
public abstract class Pet {
    private String name;
    private double weight;
    private String habitat;

    // Constructor to initialize a pet
    public Pet(String name, double weight, String habitat) {
        this.name = name;
        this.weight = weight;
        this.habitat = habitat;
    }

    // Method to simulate pet eating and gaining weight
    public void eat(String food) {
        this.weight += 2.0;
        System.out.println(name + " ate " + food + " and now weighs " + weight + "kg.");
    } // End eat()

    // Method to change the habitat when a pet is adopted
    public void adoption(String home) {
        this.habitat = home;
        System.out.println(name + " has been adopted into a new home: " + home);
    } // End adoption()

    // Abstract method to be overridden by subclasses (different pet sounds)
    public abstract String makeNoise();

    // Method to remove habitat when a pet is abandoned
    public void abandonment() {
        this.habitat = null;
        System.out.println(name + " has been abandoned.");
    } // End abandonment()

    // Getters for pet attributes
    public String getName() {
        return name;
    }

    public String getHabitat() {
        return habitat;
    }

} // End class Pet


// Dog class extending Pet
class Dog extends Pet {
    private String furColour;
    private boolean isTrained;

    // Constructor for Dog class
    public Dog(String name, double weight, String habitat, String furColour, boolean isTrained) {
        super(name, weight, habitat);
        this.furColour = furColour;
        this.isTrained = isTrained;
    }

    // Overridden method for dog's unique sound
    @Override
    public String makeNoise() {
        return isTrained ? "Bark" : "Growl";
    } // End makeNoise()

} // End class Dog


// Cat class extending Pet
class Cat extends Pet {
    private String tailType;
    private int noOfWhiskers;

    // Constructor for Cat class
    public Cat(String name, double weight, String habitat, String tailType, int noOfWhiskers) {
        super(name, weight, habitat);
        this.tailType = tailType;
        this.noOfWhiskers = noOfWhiskers;
    }

    // Overridden method for cat's unique sound
    @Override
    public String makeNoise() {
        return (noOfWhiskers > 14) ? "Meow" : "";
    } // End makeNoise()
    
} // End class Cat
