package suppliers;

import extrole.ExternalRole;

public interface Supplier extends ExternalRole {
    void sendOrder(String item, int quantity); 
}
