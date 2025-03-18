import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Part 1
        ArrayList<ObjectContainer<Integer>> intNums = new ArrayList<>();
        int[] wholeNums = {1, 2, 2, 1, 1, 3, 3, 3};

        // Populate ArrayList with given list
        for (int num : wholeNums) {
            intNums.add(new ObjectContainer<Integer>(num));
        }

        // Print the list
        System.out.println("ObjectContainer List:");
        for (ObjectContainer<Integer> obj : intNums) {
            System.out.print(obj.get() + " "); // Use .get() to retrieve values
        }
        System.out.println();

        // Create set from list
        Set<ObjectContainer<Integer>> numSet = new HashSet<>();
        for (ObjectContainer<Integer> obj : intNums) {
            numSet.add(obj);
        }

        // Print the set
        System.out.println("\nObjectContainer Set:");
        for (ObjectContainer<Integer> obj : numSet) {
            System.out.print(obj.get() + " ");
        }

        System.out.println("\n");

        // Part 2
        String[][] entries = {
            { "apple", "A popular fruit" },
            { "applet", "A type of Java program that runs in a browser, now obsolete" },
            { "app", "An application, usually for a mobile device" },
            { "ball", "A round object used in sports" },
            { "cat", "A popular low-maintenance pet" }
        };

        Dictionary dict = new Dictionary();

        // Add entries to dictonary using 2D array
        for (String[] entry : entries) {
            dict.add(entry[0], entry[1], true);
        }

        // Lookup exact words
        System.out.println("Lookup for 'apple' in dictionary:");
        System.out.println(dict.lookup("apple", false));
        
        System.out.println("\nLookup for 'appl' with similar words in dictionary:");
        System.out.println(dict.lookup("appl", true));

        System.out.println("\nLookup for 'banana' in dictionary:");
        System.out.println(dict.lookup("banana", false));

        System.out.println("\nLookup for 'zebra' with similar words in dictionary:");
        System.out.println(dict.lookup("zebra", true));
        
        // List all entries
        System.out.println("\nList of all entries in dictionary:");
        dict.listAllEntries();
    }
}
