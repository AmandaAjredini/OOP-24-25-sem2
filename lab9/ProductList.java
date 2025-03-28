import java.io.*;
import java.nio.file.*;
import java.util.stream.*;
import java.util.List;


public class ProductList {
    private List<Product> products;

    public ProductList(String file) {
        Path csv = Path.of(file);

        try (Stream<String> lines = Files.lines(csv)) {
            products = lines
                        // Skip header line
                        .skip(1)
                        // Use map to transform each line into a Product
                        .map(line -> {
                            // Split the line into an array using commas
                            String[] parts = line.split(",");

                            // Validate that the line has exactly 5 elements (ID, Name, Category, Subcategory, Price)
                            if (parts.length != 5) {
                                System.err.println("Invalid Object, ID: " + parts[0]);
                                return null; // Return null for invalid lines
                            }

                            int id;
                            try {
                                // Try parsing the ID from string to integer
                                id = Integer.parseInt(parts[0]);
                            } catch (NumberFormatException e) {
                                System.err.println("Invalid ID, setting to -1: " + parts[0]);
                                id = -1; // Assign -1 to invalid IDs
                            }

                            // Extract name, category, and subcategory fields
                            String name = parts[1];
                            String category = parts[2];
                            String subCat = parts[3];


                            double price = 0.0;

                            try {
                                // Try parsing the price from string to double
                                price = Double.parseDouble(parts[4]);

                            } catch (NumberFormatException e) {
                                System.err.println("Invalid object price: " + parts[4]);
                                return null; // Return null for invalid prices
                            }

                            // Return a new Product object with parsed data
                            return new Product(id, name, category, subCat, price);
                        })
                        // Remove null entries from the list (invalid products)
                        .filter(p -> p != null) 
                        // Collect the results into a list
                        .collect(Collectors.toList());
        } catch (IOException e) {
            System.err.println("Error reading file: " + file);
        }
    }

    // Method to return a copy of the product list
    public List<Product> getProducts() {
        return products;
    }
}