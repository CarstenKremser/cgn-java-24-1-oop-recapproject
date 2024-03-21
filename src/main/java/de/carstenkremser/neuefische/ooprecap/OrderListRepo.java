package de.carstenkremser.neuefische.ooprecap;

import java.util.ArrayList;
import java.util.List;

public class OrderListRepo implements OrderRepo{

    private final List<Order> orders = new ArrayList<>();


    @Override
    public void add(Order order) {
        orders.add(order);
    }

    @Override
    public void remove(Order order) {
        orders.remove(order);
    }

    @Override
    public Order get(String orderId) {
        for (Order order:orders) {
            if (order.orderId().equals(orderId)) {
                return order;
            }
        }
        return null;
    }

    @Override
    public Order[] getAll() {
        return orders.toArray(new Order[0]);
    }
}
