
package StreetFoodOrdering.src.business;

import java.util.ArrayList;
import java.util.List;

import StreetFoodOrdering.src.model.Payment;

public class PaymentService {

    private List<Payment> paymentList = new ArrayList<>();

    // Processes a payment.
    public boolean processPayment(Payment payment) {

        if (!isValidPayment(payment)) {
            return false;
        }

        // Prevent duplicate Payment IDs.
        if (findPaymentByID(payment.getPaymentID()) != null) {
            return false;
        }

        paymentList.add(payment);
        return true;
    }

    // Returns all payments.
    public List<Payment> getAllPayments() {
        return new ArrayList<>(paymentList);
    }

    // Finds a payment using its ID.
    public Payment findPaymentByID(int paymentID) {
        for (Payment payment : paymentList) {
            if (payment.getPaymentID() == paymentID) {
                return payment;
            }
        }
        return null;
    }

    // Finds a payment using its Order ID.
    public Payment findPaymentByOrderID(int orderID) {
        for (Payment payment : paymentList) {
            if (payment.getOrderID() == orderID) {
                return payment;
            }
        }
        return null;
    }

    // Returns the number of payments.
    public int getPaymentCount() {
        return paymentList.size();
    }

    // Validates payment information.
    private boolean isValidPayment(Payment payment) {

        return payment != null
                && payment.getPaymentID() > 0
                && payment.getOrderID() > 0
                && payment.getPaymentMethod() != null
                && !payment.getPaymentMethod().trim().isEmpty()
                && payment.getAmountPaid() > 0
                && payment.getTotalAmount() > 0
                && payment.getAmountPaid() >= payment.getTotalAmount()
                && findPaymentByOrderID(payment.getOrderID()) == null;
    }
}

