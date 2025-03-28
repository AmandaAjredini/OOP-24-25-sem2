import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.util.stream.*;


public class Main {
    public static void main(String[] args) {
        String file = "lab9_products.csv";
        String outputFile = "products_in_dollars.csv";

        // Create ProductList instance
        ProductList pl = new ProductList(file);

        // Conversion rate from Euro to USD
        double conversionRate = 1.1;

        // Convert prices to dollars and write to new CSV file
        try (BufferedWriter writer = Files.newBufferedWriter(Path.of(outputFile))) {
            writer.write("id,name,category,subcategory,price(USD)\n"); // Header of file
            pl.getProducts().stream()
                            // Convert prices from Euro to USD
                            .map(p -> new Product(p.id(), p.name(), p.category(), p.subCat(), p.price() * conversionRate))
                            // Convert product objects to CSV formatted strings
                            .map(p -> p.id() + "," + p.name() + "," + p.category() + "," + p.subCat() + "," + String.format("%.2f", p.price()))
                            // Write each line to the file
                            .forEach(line -> {
                                try {
                                    writer.write(line + "\n");
                                } catch (IOException e) {
                                    System.err.println("Error writing to file: " + e.getMessage());
                                }
                            });
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }


        // Compute average price per category
        Map<String, Double> avgCatPrice = pl.getProducts()
                                            .stream()
                                            .collect(Collectors.groupingBy(
                                                Product::category, // Group by category
                                                Collectors.averagingDouble(Product::price) // Calculate average price
                                            ));

        // Sort and print category averages in descending order
        avgCatPrice.entrySet().stream()
                              .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) // Sort by highest to lowest price
                              .forEach(entry -> System.out.println(entry.getKey() + ": " + String.format("%.2f", entry.getValue()))); // Print each category and its average price
                            
    }
}