package customers;

import extrole.ExternalRoleList;
import orders.IncomingOrder;

public class Customers extends ExternalRoleList<Customer> {
    public void sendReceipts(IncomingOrder[] orders) {
        boolean first = true;
        for (IncomingOrder order : orders) {
            Customer customer = getById(order.customerId());
            if (!first) {
                System.out.println("----------------------------");
            } else {
                first = false;
            }
            customer.sendReceipt(order.item(), order.price());
        }
    }
}
