package StreetFoodOrdering.src.business;

import java.util.List;

import StreetFoodOrdering.src.data.PaymentRepository;
import StreetFoodOrdering.src.model.Payment;

public class PaymentService {

    private PaymentRepository paymentRepository;

    // Constructor
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    // Processes a payment.
    public boolean processPayment(Payment payment) {
        if (!isValidPayment(payment)) {
            return false;
        }

        if (paymentRepository.findPaymentByID(payment.getPaymentID()) != null) {
            return false;
        }

        paymentRepository.addPayment(payment);
        return true;
    }

    // Returns all payments.
    public List<Payment> getAllPayments() {
        return paymentRepository.getAllPayments();
    }

    // Finds payment by ID.
    public Payment findPaymentByID(int paymentID) {
        return paymentRepository.findPaymentByID(paymentID);
    }

    // Finds payment by Order ID.
    public Payment findPaymentByOrderID(int orderID) {
        return paymentRepository.findPaymentByOrderID(orderID);
    }

    // Returns the total number of payments.
    public int getPaymentCount() {
        return paymentRepository.getPaymentCount();
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
                && paymentRepository.findPaymentByOrderID(payment.getOrderID()) == null;
    }
}


