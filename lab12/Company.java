import java.io.BufferedReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.io.FileReader;
import java.io.IOException;

// This class represents a company that manages employee data.
public class Company {
    // Static counter to generate unique employee IDs
    private static int idCounter = 0;

    // Map to store employees by their generated ID
    private Map<String, Employee> employeeIdMap = new HashMap<>();

    // getter to allow access to the employee map
    public Map<String, Employee> getEmployees() {
        return this.employeeIdMap;
    }

    // Method to generate a unique employee ID
    private static String generateId() {
        String empId = String.format("%06d", ++idCounter); // Pads the number with zeroes

        return empId;
    }

    // Method to add an employee to the company after validating the data
    // Throws InvalidDataException if the data is invalid
    private void addEmployee(String name, String salary, String area) throws InvalidDataException {
        // Check if the salary is a positive integer using regex
        if (!salary.matches("\\d+")) {
            throw new InvalidDataException("Salary must be a positive integer!\nError: " + salary + "\n");
        }

        // Convert salary to an integer after validation
        int salaryInt = Integer.parseInt(salary);

        // Check if the area is one of the accepted values (case-insensitive)
        if (!area.equalsIgnoreCase("ADMINISTRATIVE") && 
            !area.equalsIgnoreCase("TECHNICAL") && 
            !area.equalsIgnoreCase("BUSINESS")) {

            throw new InvalidDataException("Area has to be BUSINESS, TECHNICAL or ADMINISTRATIVE!\nError: " + area + "\n");
        }
        
        // Validate that the name is not null or empty
        if (name == null || name.isEmpty()) {
            throw new InvalidDataException("Name cannot be null or empty!\n");
        }
        
        // Create a new immutable Employee record
        Employee employee = new Employee(name, salaryInt, area);
        
        // Generate a new unique ID and store the employee in the map
        String empId = generateId();
        employeeIdMap.put(empId, employee);
    }

    // Reads employee data from a CSV file and adds them to the map
    protected void addEmployeeFromFile(String filename) {
        try(BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            reader.readLine(); // Skip header line

            // Read each line of the file
            // Split the line by commas and extract the fields into an Array
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String rowId = parts[0];

                // Check if the line has enough columns
                // If not, skip the line and print an error message
                if (parts.length < 4) {
                    System.err.println("Not enough columns in Row ID: " + rowId + "\n");
                    continue;
                }
                
                // Extract the employee details from the parts array
                String name = parts[1];
                String salary = parts[2];
                String area = parts[3];

                // Attempt to add the employee, catching validation errors
                try {
                    addEmployee(name, salary, area);
                } catch (InvalidDataException e) {
                    System.err.println("Error in Row ID: "+ rowId + "\n"+ e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // Method to look up an employee by their ID and print their details
    // Print an error message if the employee is not found
    protected void employeeLookUp(String empId) {
        // Check if the employee ID exists in the map
        for (Map.Entry<String, Employee> entry : employeeIdMap.entrySet()) {
            if (entry.getKey().equals(empId)) {
                // If found, print the employee details
                // Use the entry's key (ID) and value (Employee object) to print the details
                System.out.println("Employee ID: " + empId + "\n" +
                                   "Name: " + entry.getValue().name() + "\n" +
                                   "Salary: " + entry.getValue().salary() + "\n" +
                                   "Area: " + entry.getValue().area() + "\n");
                return;
            }
        }

        // If no employee found with the given ID, print an error message
        System.out.println("Employee with ID " + empId + " not found!\n");
    }

    // Method to print all employees in alphabetical order by their names using stream
    protected void alphabeticalOrder() {
        // Create a stream from the employeeIdMap entry set
        employeeIdMap.entrySet().stream()
                    // Sort the entries by the employee name using a comparator
                    // The comparator compares the names of the Employee objects in the map
                    .sorted(Comparator.comparing(entry -> entry.getValue().name()))
                    // For each entry in the sorted stream, print the employee details
                    .forEach(entry -> System.out.println("Employee ID: " + entry.getKey() + "\n" +
                                                        "Name: " + entry.getValue().name() + "\n" +
                                                        "Salary: " + entry.getValue().salary() + "\n" +
                                                        "Area: " + entry.getValue().area() + "\n"));
    }
}