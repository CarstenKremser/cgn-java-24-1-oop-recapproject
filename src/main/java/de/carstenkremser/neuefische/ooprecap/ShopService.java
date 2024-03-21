package de.carstenkremser.neuefische.ooprecap;

import java.util.Arrays;
import java.util.List;

public class ShopService {

    final ProductRepo productRepo;
    final OrderRepo orderRepo;

    int orderIdCounter = 0;

    public ShopService(ProductRepo productRepo, OrderRepo orderRepo) {
        this.productRepo = productRepo;
        this.orderRepo = orderRepo;
    }

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
        OrderPosition[] orderPositionsArray = orderPositions.toArray(new OrderPosition[0]);
        String newOrderId = Arrays.hashCode(orderPositionsArray) +"-"+customerId+"-"+(++orderIdCounter);
        return new Order(newOrderId,customerId,orderPositionsArray);
    }

    boolean productExists(String gtin) {
        return (productRepo.get(gtin) != null);
    }

    @Override
    public String toString() {
        return "ShopService{" + "\n" +
                "productRepo=" + productRepo + "\n" +
                ", orderRepo=" + orderRepo + "\n" +
                '}';
    }
}
