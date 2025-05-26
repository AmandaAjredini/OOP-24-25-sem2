package company;

import customers.Customers;
import orders.IncomingOrder;
import orders.OutgoingOrder;
import suppliers.Suppliers;


// 2.g) A class representing a company, which has customers and suppliers
public class Company {
    // 3.g) A company has a VAT number (which is a constant value)
    // The VAT number of the company, which cannot be changed once assigned as it is final
    private final String VAT_num;

    // 3.h) All fields should be protected or private
    // Customers and suppliers are stored as collections of customer and supplier objects
    private Customers customers = new Customers();
    private Suppliers suppliers = new Suppliers();

    // 4.a) Constructors that initialise all fields
    // The constructor initialises the VAT number for the company when an instance is created
    public Company (String VAT_num) {
        this.VAT_num = VAT_num;
    }

    // 4.c) Method that allows the addition of customer organisations (taking necessary information as separate arguments)
    public void addCustomerOrganisation(String name, String email, String contactName, String VAT_num) {
        // Creates a new CustomerOrganisation instance using the provided information
        // and adds it to the customers list using generic add() method of ExternalRoleList
        customers.add(new CustomerOrganisation(name, email, contactName, VAT_num));
    }

    // 4.c) Method that allows the addition of customer persons (taking necessary information as separate arguments)
    public void addCustomerPerson(String name, String email) {
        // Creates a new CustomerPerson instance using the provided information
        // and adds it to the customers list using generic add() method of ExternalRoleList
        customers.add(new CustomerPerson(name, email));
    }

    // 4.c) Method that allows the addition of supplier organisations (taking necessary information as separate arguments)
    public void addSupplierOrganisation(String name, String email, String contactName) {
        // Creates a new SupplierOrganisation instance using the provided information
        // and adds it to the suppliers list using generic add() method of ExternalRoleList
        suppliers.add(new SupplierOrganisation(name, email, contactName));
    }

    // Getter method to retrieve list of customers
    public Customers getCustomers() {
        return customers;
    }

    // Getter method to retrieve list of suppliers
    public Suppliers getSuppliers() {
        return suppliers;
    }

    // Getter method to retrieve VAT number
    public String getVAT_num() {
        return VAT_num;
    }

    // Main method for testing the functionality
    public static void main(String[] args) {
        // 5.a) Creating a company object
        Company company = new Company("IE12345678");

        // 5.b) Adding customers to company
        company.addCustomerPerson("Joe Bloggs", "jb@gm.com");
        company.addCustomerPerson("Jane Cloggs", "jc@hy.ie");
        company.addCustomerOrganisation("Cards", "mm@cards.com", "Minnie Moggs", "IE22334455");
        
        // 5.c) Adding suppliers to company
        company.addSupplierOrganisation("WoodCo", "bb@wood.com", "Bobby Briggs");
        company.addSupplierOrganisation("Glue", "info@glue.com", "Maxie Maggs");

        // 5.d) Sending receipts to customers
        System.out.println("\n\tRECEIPTS:\n\n");
       
        // Creating an array of incoming orders to be sent as receipts
        IncomingOrder[] incomingOrders = {
            new IncomingOrder(1, "Card 100 10x15", 7),
            new IncomingOrder(2, "Card 100 10x15", 7),
            new IncomingOrder(3, "Card 1000 10x15", 50)
        };

        // Send receipts to customers for the incoming orders
        company.getCustomers().sendReceipts(incomingOrders);

        // 5.e) Sending order to suppliers
        System.out.println("\n\tORDERS:\n\n");

        // Creating an array of outgoing orders to be sent to suppliers
        OutgoingOrder[] outgoingOrders = {
            new OutgoingOrder(4, "Wood 1x3", 10),
            new OutgoingOrder(5, "Glue 5l", 2),
        };

        // Send orders to suppliers for the outgoing orders
        company.getSuppliers().sendOrders(outgoingOrders);
    }
}
