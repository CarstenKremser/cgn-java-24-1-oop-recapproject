package de.carstenkremser.neuefische.ooprecap;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShopCli {

    ShopService shopService = null;

    public ShopCli(ShopService shopService) {
        this.shopService = shopService;
    }

    public void run() {
        placeOrder();
    }

    private void placeOrder() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Place Order");
        System.out.println("Your ClientID:");
        // Read ClientId
        String clientId = scanner.nextLine(); // read Input
        List<OrderPosition> orderPositions = new ArrayList<>();

        boolean createNewPosition = true;
        while(createNewPosition) {
            String gtin = "";
            boolean validGtin = false;

            while(createNewPosition && !validGtin) {

                System.out.println("New Position: GTIN of Product:");

                // Read GTIN
                gtin = scanner.nextLine(); // read Input

                if(gtin.equalsIgnoreCase("exit")) {
                    return;
                }
                validGtin = shopService.productExists(gtin); // check validity of gtin
                if (!validGtin) {
                    System.out.println("Produkt with GTIN " + gtin + " is unknown, please enter new GTIN or 'exit'");
                    System.out.println("New Position: GTIN of Product:");
                }

            }

            System.out.println("Number of products: ");
            int amount = scanner.nextInt();
            scanner.nextLine();

            orderPositions.add(new OrderPosition(amount, shopService.getProduct(gtin)));

            System.out.println("add another position? [y]/[n]");
            String answer = scanner.nextLine();
            createNewPosition = (answer.equalsIgnoreCase("y"));
        }

        System.out.println("created order positions for client " + clientId);
        System.out.println(orderPositions);
        System.out.println("place this order? [y]/[n]");
        if (scanner.nextLine().equalsIgnoreCase("y")) {
            Order order = shopService.placeNewOrder(clientId,orderPositions);
            System.out.println("placed order: " + order);
        };
        scanner.close();
    }

}
