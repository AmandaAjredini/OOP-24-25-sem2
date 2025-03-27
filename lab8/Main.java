import java.util.List;

// Main class to test functionality
public class Main {
    public static void main(String[] args) {
        // Create an owner
        Owner owner = new Owner("Alice", 30);

        // Create pets
        Dog dog = new Dog("Buddy", 12.0, "Shelter", "Brown", true);
        Cat cat = new Cat("Whiskers", 5.0, "Street", "Long", 16);

        // Adopt pets
        owner.adopt(dog, "Alice's Home");
        owner.adopt(cat, "Alice's Home");

        // Feed pets
        owner.feedPet("Meat");

        // Pet actions
        System.out.println(dog.makeNoise());
        System.out.println(cat.makeNoise());

        // Find pets by regex
        List<Pet> foundPets = owner.findPetsByPattern("B.*");
        foundPets.forEach(pet -> System.out.println("Found: " + pet.getName()));

        // Lambda: Modify pets to gain weight and print new weight
        owner.transformPets(pet -> {
            pet.eat("Extra food");
            return pet;
        });

        // Lambda: Make all pets make noise
        owner.transformPets(pet -> {
            System.out.println(pet.makeNoise());
            return pet;
        });

        // Abandon pet
        owner.abandon(cat);

        // Load pets from file (Assumes file exists)
        owner.loadPetsFromFile("pets.txt");
    } // End main()
    
} // End class Main
