package StreetFoodOrdering.src.presentation;

import StreetFoodOrdering.src.model.Order;
import StreetFoodOrdering.src.model.OrderItem;

public class ReceiptView {

    public void displayReceipt(Order order) {

        if (order == null) {
            System.out.println("\nNo receipt available.");
            return;
        }

        System.out.println("\n================================================");
        System.out.println("                 STREET FOOD");
        System.out.println("                    RECEIPT");
        System.out.println("================================================");

        System.out.println("Order ID: " + order.getOrderID());

        System.out.println("------------------------------------------------");
        System.out.printf("%-22s %-5s %12s%n",
                "FOOD NAME", "QTY", "SUBTOTAL");
        System.out.println("------------------------------------------------");

        for (OrderItem item : order.getOrderItems()) {
            System.out.printf("%-22s %-5d PHP %8.2f%n",
                    item.getFoodItem().getFoodName(),
                    item.getQuantity(),
                    item.getSubtotal());
        }

        System.out.println("------------------------------------------------");
        System.out.printf("%-27s PHP %8.2f%n",
                "TOTAL AMOUNT:", order.getTotalAmount());

        System.out.println("================================================");
        System.out.println("             THANK YOU FOR ORDERING!");
        System.out.println("================================================");

        //ConsoleHelper.clearScreen();
    }
}