package customers;

import extrole.ExternalRole;

public interface Customer extends ExternalRole {
    void sendReceipt(String item, int price);
}
