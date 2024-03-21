package de.carstenkremser.neuefische.ooprecap;

import java.util.ArrayList;
import java.util.List;

public class ProductRepo {
    private List<Product> products = new ArrayList<>();

    void add(Product product) {
        products.add(product);
    }

    void remove(String gtin) {
        Product product = get(gtin);
        if (product != null) {
            products.remove(product);
        }
    }

    Product get(String gtin) {
        for(Product product:products) {
            if(product.gtin().equals(gtin)) {
                return product;
            }
        }
        return null;
    }

    Product[] getAll() {
        return products.toArray(new Product[0]);
    }
}
