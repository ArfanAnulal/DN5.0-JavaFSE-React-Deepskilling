package com.algorithms.inventory;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private final Map<String, Product> products = new HashMap<>();

    public void addProduct(Product product) {
        if (products.containsKey(product.getProductId())) {
            throw new IllegalArgumentException("Product already exists with ID: " + product.getProductId());
        }
        products.put(product.getProductId(), product);
    }

    public void updateProduct(String productId, Product updatedProduct) {
        if (!products.containsKey(productId)) {
            throw new IllegalArgumentException("Product not found with ID: " + productId);
        }
        products.put(productId, updatedProduct);
    }

    public void deleteProduct(String productId) {
        if (!products.containsKey(productId)) {
            throw new IllegalArgumentException("Product not found with ID: " + productId);
        }
        products.remove(productId);
    }

    public Product getProduct(String productId) {
        return products.get(productId);
    }
}
