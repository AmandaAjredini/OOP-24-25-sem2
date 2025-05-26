package company;

import customers.Customer;
import email.EmailSystem;


// 2.e) A class representing a type of organisation that is also a customer
// This class extends Organisation and implements the Customer interface, meaning it inherits the properties of Organisation 
// and must implement the methods declared in the Customer interface
public class CustomerOrganisation extends Organisation implements Customer {
    // 3.e) A customer organisation has a VAT number
    // The VAT number specific to the customer organisation
    private String VAT_num;

    // 4.a) Constructors that initialise all fields
    // This constructor initialises the name, email, contactName, and VAT number, and passes the first three to the Organisation constructor.
    public CustomerOrganisation(String name, String email, String contactName, String VAT_num) {
        super(name, email, contactName);
        this.VAT_num = VAT_num;
    }

    // 4.b) Classes implementing an interface must implement all methods of the interface
    // 4.b.i) Sending receipts should be done via EmailSystem.sendEmail()
    // 4.b.ii) The receipt should include the VAT number, item, price excluding VAT and VAT price
    @Override
    public void sendReceipt(String item, int price) {
        // Price excluding VAT is 80% of the total price
        double excl_vat = price * 0.8;

        // VAT price is 20% of the total price
        double vat_price = price * 0.2; 

        // StringBuilder is used for string concatenation to build the receipt details
        StringBuilder vat_receipt = new StringBuilder();

        // Append the VAT number, item name, price excluding VAT, and VAT price to the receipt
        vat_receipt.append("VAT Number:\t").append(VAT_num).append("\n");
        vat_receipt.append("Item:\t\t").append(item).append("\n");
        vat_receipt.append("Price excl. VAT:").append(excl_vat).append(" euros\n");
        vat_receipt.append("VAT:\t\t").append(vat_price).append(" euros\n");

        // Subject of the receipt email
        String emailSubject = "VAT Reciept Details";

        // Send the constructed VAT receipt details via email using the EmailSystem class
        EmailSystem.sendEmail(email, emailSubject, vat_receipt.toString());
    }

    // 4.b) Classes implementing an interface must implement all methods of the interface
    // Getter to retrieve the ID
    @Override
    public int getId() {
        // Return the unique id for the customer organisation (inherited from InvolvedParty)
        return this.id;
    }
}