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

        ConsoleHelper.clearScreen();

        System.out.println("\n================================================");
        System.out.println("                   ORDER HISTORY");
        System.out.println("================================================");

        if (orderService.getAllOrders().isEmpty()) {
            System.out.println("\nNo orders available.");
            System.out.println("================================================");
            return;
        }

        for (Order order : orderService.getAllOrders()) {

            System.out.println("\nOrder ID: " + order.getOrderID());

            System.out.println("------------------------------------------------");
            System.out.printf("%-22s %-5s %12s%n",
                    "FOOD NAME", "QTY", "SUBTOTAL");
            System.out.println("------------------------------------------------");

            for (OrderItem item : order.getOrderItems()) {

                String name = item.getFoodItem().getFoodName();

                if (name.length() > 22) {
                    name = name.substring(0, 19) + "...";
                }

                System.out.printf("%-22s %-5d PHP %8.2f%n",
                        name,
                        item.getQuantity(),
                        item.getSubtotal());
            }

            System.out.println("------------------------------------------------");
            System.out.printf("%-27s PHP %8.2f%n",
                    "TOTAL AMOUNT:", order.getTotalAmount());

            System.out.println("================================================");
        }

        System.out.println("\nTOTAL ORDERS: " + orderService.getOrderCount());
        System.out.println("================================================");
    }
}