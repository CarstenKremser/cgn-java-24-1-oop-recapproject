package de.carstenkremser.neuefische.ooprecap;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        OrderRepo orderRepo;
        ProductRepo productRepo = new ProductRepo();
        Product[] products = new Product[] {
                new Product("1-23456-789012-1","Product 1", new BigDecimal("1.23")),
                new Product("1-23456-789012-2","Product 2", new BigDecimal("2.23")),
                new Product("1-23456-789012-3","Product 3", new BigDecimal("3.23")),
                new Product("1-23456-789012-4","Product 4", new BigDecimal("4.23")),
                new Product("1-23456-789012-5","Product 5", new BigDecimal("5.23")),
                new Product("1-23456-789012-6","Product 6", new BigDecimal("6.23")),
                new Product("1-23456-789012-7","Product 7", new BigDecimal("7.23")),
                new Product("1-23456-789012-8","Product 8", new BigDecimal("8.23")),
                new Product("1-23456-789012-9","Product 9", new BigDecimal("9.23"))
        };
        for (Product product : products) {
            productRepo.add(product);
        }

        orderRepo = new OrderListRepo();

        ShopService shopService = new ShopService(productRepo,orderRepo);

        ShopCli cli = new ShopCli(shopService);

        cli.run();

        /*

        List<OrderPosition> orderPositionList = new ArrayList<>();
        orderPositionList.add(new OrderPosition(1, products[1]));
        orderPositionList.add(new OrderPosition(10, products[2]));
        orderPositionList.add(new OrderPosition(100, products[4]));


        System.out.println("=== Place first order ===");
        shopService.placeNewOrder("Customer-1", orderPositionList);

        orderPositionList.add(new OrderPosition(50, products[3]));


        System.out.println("=== Place second order ===");
        shopService.placeNewOrder("Customer-2", orderPositionList);
        */
        System.out.println("=== ShopService Info ===");

        System.out.println(shopService);

    }
}