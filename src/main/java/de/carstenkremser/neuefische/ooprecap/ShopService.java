package de.carstenkremser.neuefische.ooprecap;

import java.util.List;

public class ShopService {

    ProductRepo productRepo = new ProductRepo();
    OrderRepo orderRepo = new OrderListRepo();

    int orderIdCounter = 0;

    Order placeNewOrder(String customerId, List<OrderPosition> orderPositions) {
        boolean canPlaceOrder = true;
        for (OrderPosition orderPosition : orderPositions) {
            Product currentProduct = orderPosition.product();
            if (!productExists(currentProduct.gtin())) {
                canPlaceOrder = false;
                System.out.println("PlaceNewOrder: Product " + currentProduct + " does not exist" );
            };
        }
        Order order = null;
        if (canPlaceOrder) {
            order = createOrder(customerId, orderPositions);
            System.out.println("PlaceNewOrder: Placing order: " + order);
            orderRepo.add(order);
        } else {
            System.out.println("PlaceNewOrder: Cannot place order");
        }
        return order;
    }

    private Order createOrder(String customerId, List<OrderPosition> orderPositions) {
        OrderPosition[] orderPositionsArray = orderPositions.toArray(orderPositions.toArray(new OrderPosition[0]));
        String newOrderId = orderPositionsArray.hashCode()+"-"+customerId+"-"+(++orderIdCounter);
        return new Order(newOrderId,customerId,orderPositionsArray);
    }

    boolean productExists(String gtin) {
        return (productRepo.get(gtin) != null);
    }

}
