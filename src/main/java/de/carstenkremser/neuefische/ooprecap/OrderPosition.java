package de.carstenkremser.neuefische.ooprecap;

public record OrderPosition(
        int amount,
        Product product
) {
    @Override
    public String toString() {
        return "OrderPosition{" +
                "amount=" + amount +
                ", product=" + product +
                '}';
    }
}
