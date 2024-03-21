package de.carstenkremser.neuefische.ooprecap;

import java.math.BigDecimal;

public record Product(
        String gtin,
        String name,
        BigDecimal price
) {
}
