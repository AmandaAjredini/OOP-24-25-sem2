package suppliers;

import extrole.ExternalRoleList;
import orders.OutgoingOrder;

public class Suppliers extends ExternalRoleList<Supplier> {
    public void sendOrders(OutgoingOrder[] orders) {
        boolean first = true;
        for (OutgoingOrder order : orders) {
            Supplier supplier = getById(order.supplierId());
            if (!first) {
                System.out.println("----------------------------");
            } else {
                first = false;
            }
            supplier.sendOrder(order.item(), order.quantity());
        }
    }
}

