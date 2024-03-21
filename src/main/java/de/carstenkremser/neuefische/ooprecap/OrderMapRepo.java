package de.carstenkremser.neuefische.ooprecap;

import java.util.HashMap;
import java.util.Map;

public class OrderMapRepo implements OrderRepo {

    private Map<String,Order> orders = new HashMap<>();

    @Override
    public void add(Order order) {
        orders.put(order.orderId(),order);
    }

    @Override
    public void remove(Order order) {
        orders.remove(order.orderId());
    }

    @Override
    public Order get(String orderId) {
        return orders.get(orderId);
    }

    @Override
    public Order[] getAll() {
        return orders.values().toArray(new Order[0]);
    }

    @Override
    public String toString() {
        return "OrderMapRepo{" + "\n" +
                "orders=" + orders + "\n" +
                '}';
    }
}
