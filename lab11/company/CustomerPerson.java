package company;

import customers.Customer;
import email.EmailSystem;


// 2.f) A class representing a type of person that is also a customer
// This class extends Person and implements the Customer interface, so it inherits Person's properties and
// must implement the methods of the Customer interface
public class CustomerPerson extends Person implements Customer {

    // 4.a) Constructors that initialise all fields
    // This constructor initialises the name and email, and ensures the date of birth is set to an empty string.
    public CustomerPerson(String name, String email) {
        // 3.f) A customer person always has its date of birth set to an empty string
        // This empty string is passed directly to the Person constructor
        super(name, email, "");
    }

    // 4.b) Classes implementing an interface must implement all methods of the interface
    // 4.b.i) Sending receipts should be done via EmailSystem.sendEmail()
    // 4.b.iii) The receipt should include item name and full price
    @Override
    public void sendReceipt(String item, int price) {
        // Using StringBuilder for string concatenation to build the reciept message
        StringBuilder receipt = new StringBuilder();

        // Append the item name and price to the receipt
        receipt.append("Item:\t\t").append(item).append("\n");
        receipt.append("Price:\t\t").append(price).append(" euros\n");

        // Subject of the receipt email
        String emailSubject = "Receipt Details";

        // Send the constructed receipt via email using the EmailSystem class
        EmailSystem.sendEmail(email, emailSubject, receipt.toString()); 
    }

    // 4.b) Classes implementing an interface must implement all methods of the interface
    // Getter to retrieve the ID
    @Override
    public int getId() {
        // Return the unique id for the customer person (inherited from InvolvedParty)
        return this.id;
    }
}
