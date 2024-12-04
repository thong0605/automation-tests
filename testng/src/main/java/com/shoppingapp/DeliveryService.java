package com.shoppingapp;

import java.util.ArrayList;
import java.util.List;

public class DeliveryService {
    private List<DeliveryOption> deliveryOptions = new ArrayList<>();

    public void addDeliveryOption(DeliveryOption option) {
        deliveryOptions.add(option);
    }

    public List<DeliveryOption> getAvailableOptions() {
        return deliveryOptions;
    }
}

