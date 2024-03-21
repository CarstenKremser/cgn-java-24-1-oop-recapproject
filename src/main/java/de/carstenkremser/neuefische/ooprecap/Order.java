package de.carstenkremser.neuefische.ooprecap;

import java.math.BigDecimal;
import java.util.Arrays;

public record Order(
        String orderId,
        String customerId,
        OrderPosition[] orderPositions
) {

    public BigDecimal totalPrice() {
        BigDecimal result = BigDecimal.ZERO.setScale(2);
        for(OrderPosition position : orderPositions) {
            result = result.add(position.totalPrice());
        }
        return result;
    }

    @Override
    public String toString() {
        String result = "Order{" +
                "orderId='" + orderId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", orderPositions=\n";
        for (OrderPosition orderPosition:orderPositions) {
            result += "    " + orderPosition + "\n";
        }

        result += ", totalPrice='" + totalPrice() +  "'}";
        return result;
    }
}
