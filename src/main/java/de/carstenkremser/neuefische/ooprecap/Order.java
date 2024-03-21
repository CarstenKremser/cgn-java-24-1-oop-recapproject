package de.carstenkremser.neuefische.ooprecap;

import java.util.List;

public record Order(
        String orderId,
        String customerId,
        List<OrderPosition> orderpositions
) {
}
