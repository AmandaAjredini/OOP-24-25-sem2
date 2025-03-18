import java.util.*;
import java.util.regex.*;
import java.util.function.*;


public class IDStorage {
    // List to store the IDs found in the input string
    private List<String> ids = new ArrayList<>();

    // Regular expression for the ID format
    private static final Pattern ID_Pattern = Pattern.compile("[XBD]00\\d{6}"); // ? can be X, B, or D, followed by 00 and 6 digits
    // Map to associate each ID prefix (D, B, X) with a specific location
    private static final Map<Character, String> locations = Map.of( 'D', "City",
                                                                    'B', "Blanchardstown",
                                                                    'X', "Tallaght");

    public IDStorage(String input) {
        Matcher matcher = ID_Pattern.matcher(input);

        // Loop through all matches and add each found ID to the list
        while (matcher.find()) {
            ids.add(matcher.group());
            System.out.println("Found ID: " + matcher.group());
        }
    }

    // Method to return the list of extracted IDs
    public List<String> getIDs() {
        return ids;
    }

    // Method to convert IDs into a readable format with the location and numerical part of ID
    public List<String> convertIDs() {
        // Function defined that maps an ID to its corresponding location and number
        Function<String, String> converter = id -> locations.get(id.charAt(0)) + " " + id.substring(3);
        
        // Apply the function to each ID and collect results in a list
        return ids.stream()
                  .map(converter)
                  .toList();
    }

    // Method to filter IDs by a specified location
    public List<String> filterByLocation(String location) {
        // Define a predicate to check if the ID's location matches the given location (case-insensitive)
        BiPredicate<String, String> locationPredicate = (id, loc) -> loc.equalsIgnoreCase(locations.get(id.charAt(0)));
        
        // Filter the IDs and collect the results in a list
        return ids.stream()
                  .filter(id -> locationPredicate.test(id, location))
                  .toList();
    }
}