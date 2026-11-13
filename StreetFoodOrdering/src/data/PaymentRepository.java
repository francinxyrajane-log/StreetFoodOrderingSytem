
package StreetFoodOrdering.src.data;

import java.util.List;
import StreetFoodOrdering.src.model.Payment;

public interface PaymentRepository {

    void addPayment(Payment payment);

    List<Payment> getAllPayments();

    Payment findPaymentByID(int paymentID);

    Payment findPaymentByOrderID(int orderID);

    int getPaymentCount();
}

