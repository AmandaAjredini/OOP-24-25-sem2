package company;


// 2.b) A class representing a person, which is a type of involved party
public class Person extends InvolvedParty{
    // 3.c) A person has a date of birth
    // The 'dob' field is protected so it can be accessed by this class and subclasses
    protected String dob;

    // 4.a) Constructors that initialise all fields
    // This constructor is used to create a new Person instance, initialising the name, email, and dob
    public Person(String name, String email, String dob) {
        // Calls the superclass constructor (InvolvedParty) to initialise the name, email, and id
        super(name, email);
        this.dob = dob;
    }
}