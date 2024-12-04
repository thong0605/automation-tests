package com.shoppingapp;

public class Billing {
    private double totalAmount;
    private double discount;

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
    

    public void applyDiscount(double discount) {
        this.discount = discount;
    }

    public double calculateFinalAmount() {
        return totalAmount - (totalAmount * discount / 100);
    }

    public boolean validatePayment(String cardNumber) {
        return cardNumber.matches("\\d{16}"); // Simplified validation
    }
}

