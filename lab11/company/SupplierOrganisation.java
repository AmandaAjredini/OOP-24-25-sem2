package company;

import email.EmailSystem;
import suppliers.Supplier;


// 2.d) A class representing a type of organisation that is also a supplier
// This class extends Organisation and implements the Supplier interface, meaning it inherits the properties of Organisation 
// and must implement the methods declared in the Supplier interface
public class SupplierOrganisation extends Organisation implements Supplier {
    
    // 4.a) Constructors that initialise all fields
    // This constructor initialises the name, email, and contactName, and then passes them to the Organisation constructor.
    public SupplierOrganisation(String name, String email, String contactName) {
        super(name, email, contactName);
    }

    // 4.b) Classes implementing an interface must implement all methods of the interface
    // 4.b.i) Sending orders should be done via EmailSystem.sendEmail()
    // 4.b.iv) An order sent should include the contact name, item and quantity
    @Override
    public void sendOrder(String item, int quantity) {
        // Using StringBuilder for string concatenation to build the order message
        StringBuilder order = new StringBuilder();

        // Append contact name, item, and quantity to the order details
        order.append("Contact Name:\t").append(contactName).append("\n");
        order.append("Item:\t\t").append(item).append("\n");   
        order.append("Quantity:\t").append(quantity).append(" units\n");

        // Subject of the email for the order
        String emailSubject = "Order Details";

        // Send the constructed order details via email using the EmailSystem class
        EmailSystem.sendEmail(email, emailSubject, order.toString());
    }

    // 4.b) Classes implementing an interface must implement all methods of the interface
    // Getter to retrieve the ID
    @Override
    public int getId() {
        // Return the unique id for the supplier organisation (inherited from InvolvedParty)
        return this.id;
    }
}
