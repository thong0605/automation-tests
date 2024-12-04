package com.shoppingapp;

import java.util.HashMap;
import java.util.Map;

public class ProductService {
    private Map<String, Product> productCatalog = new HashMap<>();

    public void addProduct(Product product) {
        productCatalog.put(product.getName(), product);
    }

    public Product getProductById(String productId) {
        return productCatalog.get(productId);
    }

    public void updateProduct(Product product) {
        productCatalog.put(product.getName(), product);
    }
}

