
package StreetFoodOrdering.src.model;

public class Payment {

    // Attributes
    private int paymentID;
    private int orderID;
    private String paymentMethod;
    private double amountPaid;
    private double totalAmount;

    // Constructor
    public Payment(int paymentID, int orderID, String paymentMethod,
                   double amountPaid, double totalAmount) {
        this.paymentID = paymentID;
        this.orderID = orderID;
        this.paymentMethod = paymentMethod;
        this.amountPaid = amountPaid;
        this.totalAmount = totalAmount;
    }

    // Getters
    public int getPaymentID() {
        return paymentID;
    }

    public int getOrderID() {
        return orderID;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    // Calculates change
    public double getChange() {
        return amountPaid - totalAmount;
    }
}

