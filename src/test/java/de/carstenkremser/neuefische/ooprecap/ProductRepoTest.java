package de.carstenkremser.neuefische.ooprecap;

import org.junit.jupiter.api.Assertions;

import java.math.BigDecimal;

class ProductRepoTest {

    @org.junit.jupiter.api.Test
    void add_shouldContain1Product_when1ProductWasAdded() {
        ProductRepo repo = new ProductRepo();
        String gtin1 = "1-23456-789012-1";
        Product product1 = new Product(gtin1,"Product1", BigDecimal.ONE);
        Product expected = product1;

        repo.add(product1);
        Product[] result = repo.getAll();

        Assertions.assertTrue(result.length==1);
        Assertions.assertEquals(expected, result[0]);
   }

    @org.junit.jupiter.api.Test
    void remove_shouldContainNoProduct_whenProductWasAddedAndRemoved() {
        ProductRepo repo = new ProductRepo();
        String gtin1 = "1-23456-789012-1";
        Product product1 = new Product(gtin1,"Product1", BigDecimal.ONE);
        Product expected = product1;

        repo.add(product1);
        repo.remove(gtin1);
        Product[] actual = repo.getAll();

        Assertions.assertTrue(actual.length==0);

    }

    @org.junit.jupiter.api.Test
    void get_shouldReturnSecondProduct_whenGtinOfSecondProductWasPassed() {
        ProductRepo repo = new ProductRepo();
        String gtin1 = "1-23456-789012-1";
        String gtin2 = "1-23456-789012-2";
        String gtin3 = "1-23456-789012-3";
        Product product1 = new Product(gtin1,"Product1", BigDecimal.ONE);
        Product product2 = new Product(gtin2,"Product2", BigDecimal.TWO);
        Product product3 = new Product(gtin3,"Product3", BigDecimal.TEN);
        Product expected = product2;

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        Product actual = repo.get(gtin2);

        Assertions.assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void getAll_shouldReturn3Products_when3ProductsWereAdded() {
        ProductRepo repo = new ProductRepo();
        String gtin1 = "1-23456-789012-1";
        String gtin2 = "1-23456-789012-2";
        String gtin3 = "1-23456-789012-3";
        Product product1 = new Product(gtin1,"Product1", BigDecimal.ONE);
        Product product2 = new Product(gtin2,"Product2", BigDecimal.TWO);
        Product product3 = new Product(gtin3,"Product3", BigDecimal.TEN);
        Product[] expected = new Product[]{product1, product2, product3};

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Product[] actual = repo.getAll();
        Assertions.assertEquals(expected[0], actual[0]);
        Assertions.assertEquals(expected[1], actual[1]);
        Assertions.assertEquals(expected[2], actual[2]);
    }
}