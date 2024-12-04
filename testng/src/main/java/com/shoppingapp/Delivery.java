package com.shoppingapp;

import java.time.LocalDateTime;

public class Delivery {
    private Address deliveryAddress;
    private LocalDateTime deliveryDate;

    public void setDeliveryAddress(Address address) {
        this.deliveryAddress = address;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryDate(LocalDateTime date) {
        this.deliveryDate = date;
    }

    public LocalDateTime getDeliveryDate() {
        return deliveryDate;
    }

    public String getDeliveryDetails() {
        return "Delivery to: " + deliveryAddress.getFullAddress() + " on " + deliveryDate;
    }
}

