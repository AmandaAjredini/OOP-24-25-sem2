import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dictionary {
    // The dictionary stores words as keys and their descriptions as values
    private Map<String, String> dictionary;

    public Dictionary() {
        this.dictionary = new HashMap<>();
    }
    
    // Add method with update flag and return value indicating if entry was already present
    public boolean add(String word, String description, boolean updateIfExists) {
        boolean entryExists = dictionary.containsKey(word); // Check if word already exists in dictionary

        if (entryExists && !updateIfExists) {
            return false; // If word exists and updateIfExists is false, do not add or update
        }

        dictionary.put(word, description);
        return !entryExists; // Return true if entry was not alreadt present
    }

    public List<String> lookup(String word, boolean findSimilar) {
        List<String> similarWords = new ArrayList<>();

        // Look for the exact word and print its description
        if (dictionary.containsKey(word)) {
            System.out.println(word + ": " + dictionary.get(word));
        } else {
            System.out.println("Word not found.");
        }

        if (findSimilar) {
            // If findSimilar is true, find words that start with the first 3 letters of the input word
            for (String entry : dictionary.keySet()) {
                if (entry.startsWith(word.substring(0, Math.min(3, word.length())))) {
                    similarWords.add(entry);
                }
            }

            // If no similar words were found, print a message
            if (similarWords.isEmpty()) {
                System.out.print("No similar words found: ");
                return similarWords;
            }
        }

        System.out.print("Similar words: ");

        return similarWords;
    }

    // List all entries in dictionary
    public void listAllEntries() {
        if (dictionary.isEmpty()) {
            System.out.println("Dictionary is empty.");
        } else {
            // Loop through all entries and print them
            for (Map.Entry<String, String> entry : dictionary.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }

        System.out.println();
    }
}
