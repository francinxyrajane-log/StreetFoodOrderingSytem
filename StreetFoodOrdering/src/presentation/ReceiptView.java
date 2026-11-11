
package StreetFoodOrdering.src.presentation;

import StreetFoodOrdering.src.model.Order;
import StreetFoodOrdering.src.model.OrderItem;

public class ReceiptView {

    public void displayReceipt(Order order) {

        if (order == null) {
            System.out.println("\nNo receipt available.");
            return;
        }

        System.out.println("\n===================================");
        System.out.println("          STREET FOOD");
        System.out.println("              RECEIPT");
        System.out.println("===================================");

        System.out.println("Order ID: " + order.getOrderID());

        System.out.println("-----------------------------------");
        System.out.printf("%-18s %-5s %10s%n","Food", "Qty", "Subtotal");
        System.out.println("-----------------------------------");

        for (OrderItem item : order.getOrderItems()) {
            System.out.printf("%-18s %-5d ₱%9.2f%n",
                item.getFoodItem().getFoodName(),
                item.getQuantity(),
                item.getSubtotal());
        }

        System.out.println("-----------------------------------");
        System.out.printf("TOTAL AMOUNT:       ₱%.2f%n", order.getTotalAmount());
        System.out.println("===================================");
        System.out.println("       THANK YOU FOR ORDERING!");
        System.out.println("===================================");
    }
}
