import java.nio.file.*;
import java.util.*;
import java.io.*;
import java.util.regex.Pattern;
import java.util.function.Predicate;

// TextProcessor class to process text files in a specified directory
public class TextProcessor {
    private String directoryName;
    private List<String> fileNames;
    private Map<String, Integer> predicateCounts; // Map to store the count of words matching predicates

    public TextProcessor(String directory) {
        this.directoryName = directory;
        this.fileNames = new ArrayList<>();
        this.predicateCounts = new HashMap<>();
    }

    // Getter for the directory name
    public String getDirName() {
        return directoryName;
    }

    // Getter for the list of file names
    public List<String> getFileNames() {
        return fileNames;
    }

    // Getter for the predicate count map
    public Map<String, Integer> getMap() {
        return predicateCounts;
    }

    // Method to find files in the given directory matching a specific regex pattern
    public void findFiles(String directory, String regex) {
        File dir = new File(directory);
        try {
            Pattern pattern = Pattern.compile(regex); // Compile given regex pattern
            File[] files = dir.listFiles(); // List all files in the directory and store in an array

            // If the array isn't empty
            if (files != null) {
                // Loop over each file in array of Files
                for (File file : files) {
                    // If file is a file and matches the pattern
                    if (file.isFile() && pattern.matcher(file.getName()).matches()) {
                        fileNames.add(file.getName()); // Add matching file to the list
                    }
                }
            }
        } catch (IllegalArgumentException e) { // If directory doesn't exist, throw an exception
            System.out.println("Directory doesn't exist or not in current directory.");
        }
    }

    // Method to run specific predicate on each word in each file & counts the matches
    public void run(Predicate<String> predicate, String predicateName) {
        int count = 0;

        // Loop through each file in list of files
        for (String file : fileNames) {
            try {
                // Read all lines from the file and store in a list
                List<String> lines = Files.readAllLines(Path.of(directoryName, file));

                // Loop through each line in the list of lines
                for (String line : lines) {
                    // Split line into words using non-word characters as delimiters
                    String[] words = line.split("\\W+");

                    // Loop through each word in array of words
                    for (String word : words) {
                        // Check if the word satisfies the predicate and if it does, count it
                        if (predicate.test(word)) {
                            count++;
                        }
                    }
                }

            } catch (IOException e) { // If there's an error reading the file, throw an exception
                System.out.println("Error reading file: " + file);
            }  
        }

        // Store the count of matching words with the given predicate name in a Map
        predicateCounts.put(predicateName, count);
    }

    // Method to save the predicate results to a specific file
    public void saveResults(String file) {
        try {
            // Loop through each entry in the predicateCounts Map
            for (Map.Entry<String, Integer> entry : predicateCounts.entrySet()) {
                
                // Format result as "predicateName: count"
                String line = entry.getKey() + ": " + entry.getValue() + "\n";
                // Write line to file; creating the file if it doesn't exist, and appending to it if it does
                Files.write(Path.of(file), line.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            }
        } catch (IOException e) { // If there's an error writing to the file, throw an exception
            System.out.println("Error writing to file: " + file);
        }
    }
}