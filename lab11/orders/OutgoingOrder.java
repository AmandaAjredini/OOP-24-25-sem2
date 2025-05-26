package orders;

public record OutgoingOrder (int supplierId, String item, int quantity) {}
