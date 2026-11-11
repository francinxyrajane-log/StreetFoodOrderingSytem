
package StreetFoodOrdering.src.presentation;

import StreetFoodOrdering.src.business.OrderService;
import StreetFoodOrdering.src.model.Order;
import StreetFoodOrdering.src.model.OrderItem;

public class OrderHistory {

    private OrderService orderService;

    public OrderHistory(OrderService orderService) {
        this.orderService = orderService;
    }

    public void displayOrderHistory() {
        System.out.println("\n===================================");
        System.out.println("           ORDER HISTORY");
        System.out.println("===================================");

        if (orderService.getAllOrders().isEmpty()) {
            System.out.println("No orders available.");
            return;
        }

        for (Order order : orderService.getAllOrders()) {

            System.out.println("\nOrder ID: " + order.getOrderID());
            System.out.println("-----------------------------------");

            for (OrderItem item : order.getOrderItems()) {
                System.out.printf("%-20s x%-5d ₱%.2f%n",
                        item.getFoodItem().getFoodName(),
                        item.getQuantity(),
                        item.getSubtotal());
            }

            System.out.println("-----------------------------------");
            System.out.printf("Total Amount: ₱%.2f%n",
                    order.getTotalAmount());
        }

        System.out.println("===================================");
        System.out.println("Total Orders: " + orderService.getOrderCount());
    }
}

