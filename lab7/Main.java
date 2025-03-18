import java.util.function.Predicate;


public class Main {
    // Helper method to create a predicate that matches words with a given regex pattern
    private static Predicate<String> getRegExPredicate(String regex) {
        return word -> word.matches(regex); // Returns a predicate that checks if a word matches the regex
    }

    public static void main(String[] args) {
        String dirName = "lab7_text_files";

        // Create a TextProcessor object for the specific directory
        TextProcessor tp = new TextProcessor(dirName);

        // Find files that start with 'science' and have a .txt extension
        tp.findFiles(dirName, "^science.*\\.txt$");

        // Define predicates to check if words start with 'h' or 'x'
        Predicate<String> startsWithH = getRegExPredicate("^h.*");
        Predicate<String> startsWithX = getRegExPredicate("^x.*");

        // Run the predicates on the found files
        tp.run(startsWithH, "starts_with_h");
        tp.run(startsWithX, "starts_with_x");

        // Save the results to a file named 'results.txt'
        tp.saveResults("results.txt");
    }
}