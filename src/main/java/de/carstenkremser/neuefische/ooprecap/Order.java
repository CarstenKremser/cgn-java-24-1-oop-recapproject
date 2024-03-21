package de.carstenkremser.neuefische.ooprecap;

import java.util.Arrays;

public record Order(
        String orderId,
        String customerId,
        OrderPosition[] orderPositions
) {
    @Override
    public String toString() {
        String result = "Order{" +
                "orderId='" + orderId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", orderPositions=\n";
        for (OrderPosition orderPosition:orderPositions) {
            result += "    " + orderPosition + "\n";
        }
        result += "}";
        return result;
    }
}
