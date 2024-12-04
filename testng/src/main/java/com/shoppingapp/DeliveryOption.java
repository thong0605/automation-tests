package com.shoppingapp;

public class DeliveryOption {
    private String optionName;
    private double cost;

    public DeliveryOption(String optionName, double cost) {
        this.optionName = optionName;
        this.cost = cost;
    }

    public String getOptionName() {
        return optionName;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return optionName + " - $" + cost;
    }
}

