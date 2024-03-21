package de.carstenkremser.neuefische.ooprecap;

public interface OrderRepo {
    void add(Order order);

    void remove(Order order);

    Order get(String orderId);

    Order[] getAll();
}
