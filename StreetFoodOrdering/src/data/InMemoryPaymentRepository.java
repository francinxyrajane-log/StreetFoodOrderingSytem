package StreetFoodOrdering.src.data;

import java.util.ArrayList;
import java.util.List;
import StreetFoodOrdering.src.model.Payment;

public class InMemoryPaymentRepository implements PaymentRepository {

    private List<Payment> paymentList = new ArrayList<>();

    @Override
    public void addPayment(Payment payment) {
        paymentList.add(payment);
    }

    @Override
    public List<Payment> getAllPayments() {
        return new ArrayList<>(paymentList);
    }

    @Override
    public Payment findPaymentByID(int paymentID) {
        for (Payment payment : paymentList) {
            if (payment.getPaymentID() == paymentID) {
                return payment;
            }
        }
        return null;
    }

    @Override
    public Payment findPaymentByOrderID(int orderID) {
        for (Payment payment : paymentList) {
            if (payment.getOrderID() == orderID) {
                return payment;
            }
        }
        return null;
    }

    @Override
    public int getPaymentCount() {
        return paymentList.size();
    }
}


