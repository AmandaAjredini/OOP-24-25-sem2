// Main class to test the functionality
public class Main {
        
    public static void main(String[] args) {
        // Create a new Company instance
        Company company = new Company();

        // Add employees directly from csv file
        System.out.println("Adding employees from file...\n");
        company.addEmployeeFromFile("lab12_data.csv");

        System.out.println();

        // Look up employees with IDs 000003, 000017, and 000100
        System.out.println("Looking up employees...\n");
        company.employeeLookUp("000003"); 
        company.employeeLookUp("000017"); 
        company.employeeLookUp("000100");

        System.out.println();

        // Print all employees in alphabetical order
        System.out.println("Employees in alphabetical order (by name):\n");
        company.alphabeticalOrder();
    }
}
