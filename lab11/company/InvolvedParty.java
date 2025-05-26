package company;


// 2.a) A class representing an involved party
public class InvolvedParty {
    // 3.a) An involved party has a unique id (allocated automatically)
    // The 'id' field is protected, meaning it can be accessed by subclasses
    // Unique id for each involved party, cannot be changed once assigned
    protected final int id; 

    // Static variable 'nextId' is used to ensure each new InvolvedParty gets a unique id.
    // It starts at 1 and is incremented each time a new InvolvedParty is created.
    // It keeps track of the next id to be assigned.
    protected static int nextId = 1;

    // 3.b) An involved party has a name and an email address
    // The name and email are protected so they can be accessed by subclasses
    protected String name;
    protected String email;

    // 4.a) Constructors that initialise all fields
    // This constructor is used to create a new InvolvedParty with a given name and email.
    // The constructor automatically assigns a unique id to each new instance.
    public InvolvedParty(String name, String email) {
        this.id = nextId++; // Assign the current nextId to id and then increment nextId for the next instance
        this.name = name;
        this.email = email;
    }
}