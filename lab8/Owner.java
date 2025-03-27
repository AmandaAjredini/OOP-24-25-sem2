import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.io.*;

// Owner class managing pets
public class Owner {
    private List<Pet> animals;
    private String name;
    private int age;

    // Constructor for Owner class
    public Owner(String name, int age) {
        this.name = name;
        this.age = age;
        this.animals = new ArrayList<>();
    }

    // Method to feed all owned pets
    public void feedPet(String food) {
        animals.forEach(pet -> pet.eat(food));
    } // End feedPet()

    // Method to count the number of pets
    public int countPets() {
        return animals.size();
    } // End countPets()

    // Method to adopt a pet
    public void adopt(Pet pet, String home) {
        if (animals.contains(pet)) {
            System.out.println("Error: " + name + " already owns " + pet.getName());
            return;
        }

        if (animals.size() >= 2) {
            System.out.println("Error: " + name + " cannot own more than 2 pets.");
            return;
        }

        animals.add(pet);
        pet.adoption(home);
        System.out.println(name + " adopted " + pet.getName());
    } // End adopt()

    // Method to abandon a pet
    public void abandon(Pet pet) {
        if (!animals.contains(pet)) {
            System.out.println("Error: " + name + " does not own " + pet.getName());
            return;
        }

        animals.remove(pet);
        pet.abandonment();
        System.out.println(name + " abandoned " + pet.getName());
    } // End abandon()

    // Method to find a pet by name
    public Pet findPet(String petName) {
        return animals.stream()
                .filter(pet -> pet.getName().equalsIgnoreCase(petName))
                .findFirst()
                .orElse(null);
    } // End findPet()

    // Method to find pets using a regex pattern
    public List<Pet> findPetsByPattern(String regex) {
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        return animals.stream()
                .filter(pet -> pattern.matcher(pet.getName()).find())
                .collect(Collectors.toList());
    } // End findPetsByPattern()

    // Method to apply a transformation to all pets using a lambda function
    public void transformPets(Function<Pet, Pet> transformation) {
        animals = animals.stream().map(transformation).collect(Collectors.toList());
    } // End transformPets()

    // Method to load pets from a file
    public void loadPetsFromFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length < 4) continue;
                String type = data[0].trim();
                String name = data[1].trim();
                double weight = Double.parseDouble(data[2].trim());
                String habitat = data[3].trim();

                if (type.equalsIgnoreCase("dog")) {
                    adopt(new Dog(name, weight, habitat, "Brown", true), habitat);
                } else if (type.equalsIgnoreCase("cat")) {
                    adopt(new Cat(name, weight, habitat, "Short", 16), habitat);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    } // End loadPetsFromFile()
    
} // End class Owner
