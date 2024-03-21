package de.carstenkremser.neuefische.ooprecap;

import java.math.BigDecimal;

public class OrderPosition {
    private int amount;
    private final Product product;

    public OrderPosition(int amount, Product product) {
        this.amount = amount;
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Product getProduct() {
        return product;
    }

    public BigDecimal totalPrice() {
        return product.price().multiply(new BigDecimal(amount));
    }

    @Override
    public String toString() {
        return "OrderPosition{" +
                "amount=" + amount +
                ", product=" + product +
                ", price=" + totalPrice() +
                '}';
    }
}
