package com.shoppingapp;

import java.util.HashMap;
import java.util.Map;

public class CartService {
    private Map<String, Cart> carts = new HashMap<>();

    public Cart createCart(String userId) {
        Cart cart = new Cart();
        carts.put(userId, cart);
        return cart;
    }

    public Cart getCart(String userId) {
        return carts.get(userId);
    }

    public void checkoutCart(String userId) {
        // Checkout logic
        carts.remove(userId);
    }
}

