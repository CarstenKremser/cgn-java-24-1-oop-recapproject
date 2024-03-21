package de.carstenkremser.neuefische.ooprecap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderListRepoTest {

    @Test
    void add_shouldContain1Order_when1OrderWasAdded() {
        OrderRepo repo = new OrderListRepo();
        List<OrderPosition> emptyOrderPositions = new ArrayList<>();
        String orderId1 = "order-00001";
        Order order1 = new Order(orderId1,"cust1", emptyOrderPositions);
        Order expected = order1;

        repo.add(order1);
        Order[] result = repo.getAll();

        Assertions.assertTrue(result.length==1);
        Assertions.assertEquals(expected , result[0]);
    }


    @Test
    void remove_shouldContainNoOrders_when1OrderWasAddedAndRemoved() {
        OrderRepo repo = new OrderListRepo();
        List<OrderPosition> emptyOrderPositions = new ArrayList<>();
        String orderId1 = "order-00001";
        Order order1 = new Order(orderId1,"cust1", emptyOrderPositions);

        Order expected = order1;

        repo.add(order1);
        repo.remove(order1);
        Order[] actual = repo.getAll();

        Assertions.assertTrue(actual.length==0);
    }

    @Test
    void get_shouldReturnSecondOrder_whenSecondOrderIdWasPassed() {
        OrderRepo repo = new OrderListRepo();
        List<OrderPosition> emptyOrderPositions = new ArrayList<>();
        String orderId1 = "order-00001";
        String orderId2 = "order-00002";
        String orderId3 = "order-00003";
        Order order1 = new Order(orderId1,"cust1", emptyOrderPositions);
        Order order2 = new Order(orderId2,"cust1", emptyOrderPositions);
        Order order3 = new Order(orderId3,"cust2", emptyOrderPositions);
        Order expected = order2;

        repo.add(order1);
        repo.add(order2);
        repo.add(order3);
        Order actual = repo.get(orderId2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getAll_shouldReturn3Products_when3ProductsWereAdded() {
        OrderRepo repo = new OrderListRepo();
        List<OrderPosition> emptyOrderPositions = new ArrayList<>();
        String orderId1 = "order-00001";
        String orderId2 = "order-00002";
        String orderId3 = "order-00003";
        Order order1 = new Order(orderId1,"cust1", emptyOrderPositions);
        Order order2 = new Order(orderId2,"cust1", emptyOrderPositions);
        Order order3 = new Order(orderId3,"cust2", emptyOrderPositions);
        Order[] expected = new Order[]{order1,order2,order3};

        repo.add(order1);
        repo.add(order2);
        repo.add(order3);
        Order[] actual = repo.getAll();

        Assertions.assertEquals(expected[0], actual[0]);
        Assertions.assertEquals(expected[1], actual[1]);
        Assertions.assertEquals(expected[2], actual[2]);
    }
}