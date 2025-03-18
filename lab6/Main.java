public class Main {
    public static void main(String[] args) {
        // Prompt user to enter IDs, each on a new line, and indicate end of input with "[END]"
        System.out.println("Enter IDs with each on a new line (end your input with [END]):");
        IDStorage storage = new IDStorage(ConsoleReader.readString());

        // Display raw IDs before conversion
        System.out.println("\nRaw IDs:");
        for (String id : storage.getIDs()) {
            System.out.println(id);
        }

        // Display converted IDs with location names and numbers
        System.out.println("\nLocations and Numbers:");
        for (String id : storage.convertIDs()) {
            System.out.println(id);
        }

        // Display IDs that are filtered by the location "city"
        System.out.println("\nIDs filtered by location 'city':");
        for (String id : storage.filterByLocation("city")) {
            System.out.println(id);
        }
    }
}
