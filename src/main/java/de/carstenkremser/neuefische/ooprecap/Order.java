package de.carstenkremser.neuefische.ooprecap;

public record Order(
        String orderId,
        String customerId,
        OrderPosition[] orderPositions
) {
}
