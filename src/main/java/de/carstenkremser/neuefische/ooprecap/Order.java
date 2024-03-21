package de.carstenkremser.neuefische.ooprecap;

import java.util.List;

public record Order(
        String orderId,
        String customerId,
        OrderPosition[] orderPositions
) {
}
