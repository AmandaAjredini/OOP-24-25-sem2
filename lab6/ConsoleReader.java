import java.util.Scanner;

public class ConsoleReader {
    // Method to read multi-line string from the console
    public static String readString() {
        // Create a Scanner object to read input from console
        Scanner scanner = new Scanner(System.in);
        // Use a StringBuilder object to build the input string
        StringBuilder input = new StringBuilder();

        // Continuously read lines from the console
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            // Stop reading if the line contains "[END]"
            if (line.equals("[END]")) {
                break;
            }
            // Append the line to StringBuilder with newline character
            input.append(line).append(System.lineSeparator());
        }

        scanner.close();

        // Return final multi-line string as a single text
        return input.toString();
    }
}
