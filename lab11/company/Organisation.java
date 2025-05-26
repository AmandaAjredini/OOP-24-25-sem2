package company;


// 2.c) A class representing an organisation, which is a type of involved party 
public class Organisation extends InvolvedParty {
    // 3.d) An organisation has a contact name
    // The 'contactName' field is protected so it can be accessed by this class and subclasses
    protected String contactName;

    // 4.a) Constructors that initialise all fields
    // This constructor is used to create a new Organisation instance, initialising the name, email, and contactName.
    public Organisation(String name, String email, String contactName) {
        // Calls the superclass constructor (InvolvedParty) to initialize the name, email, and id
        super(name, email);
        this.contactName = contactName;
    }
}