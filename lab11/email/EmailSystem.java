package email;

public class EmailSystem {
    static public void sendEmail(String address, String subject, String body) {
        System.out.println("To:\t\t" + address);
        System.out.println("Subject:\t" + subject);
        System.out.println("\n" + body);
    }
}
