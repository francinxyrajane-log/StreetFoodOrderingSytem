package StreetFoodOrdering.src.presentation;

import java.util.Scanner;
import StreetFoodOrdering.src.business.FoodService;
import StreetFoodOrdering.src.business.OrderService;
import StreetFoodOrdering.src.model.FoodItem;
import StreetFoodOrdering.src.model.Order;
import StreetFoodOrdering.src.model.OrderItem;

public class OrderMenu {

    private Scanner input;
    private FoodService foodService;
    private OrderService orderService;

    public OrderMenu(Scanner input, FoodService foodService,
                     OrderService orderService) {
        this.input = input;
        this.foodService = foodService;
        this.orderService = orderService;
    }

    public void displayOrderMenu() {
        int choice;

        do {
            System.out.println("\n===================================");
            System.out.println("           ORDER MENU");
            System.out.println("===================================");
            System.out.println("1. Place Order");
            System.out.println("2. Back");
            System.out.println("===================================");
            System.out.print("Enter your choice: ");

            choice = readInt();

            switch (choice) {
                case 1:
                    placeOrder();
                    break;
                case 2:
                    System.out.println("\nReturning to Main Menu...");
                    break;
                default:
                    System.out.println("\nInvalid choice!");
            }

        } while (choice != 2);
    }

    private void placeOrder() {
        if (foodService.getAllFoods().isEmpty()) {
            System.out.println("\nNo food items available!");
            return;
        }

        int orderID = generateOrderID();
        Order order = new Order(orderID);
        String addMore = "Y";

        do {
            System.out.println("\n--- AVAILABLE FOODS ---");

            for (FoodItem food : foodService.getAllFoods()) {
                System.out.printf("ID: %d | %s | ₱%.2f%n",
                        food.getFoodID(),
                        food.getFoodName(),
                        food.getPrice());
            }

            System.out.print("\nEnter Food ID: ");
            int foodID = readInt();

            FoodItem food = foodService.findFoodByID(foodID);

            if (food == null) {
                System.out.println("\nFood not found!");
                continue;
            }

            System.out.print("Enter Quantity: ");
            int quantity = readInt();

            if (quantity <= 0) {
                System.out.println("\nInvalid quantity!");
                continue;
            }

            order.addOrderItem(new OrderItem(food, quantity));

            System.out.println("\nFood added to order!");

            System.out.print("Add another food? (Y/N): ");
            addMore = input.nextLine();

        } while (addMore.equalsIgnoreCase("Y"));

        if (orderService.createOrder(order)) {
            System.out.println("\nOrder placed successfully!");
            System.out.println("Order ID: " + order.getOrderID());
            System.out.printf("Total Amount: ₱%.2f%n",
                    order.getTotalAmount());
        } else {
            System.out.println("\nFailed to place order!");
        }
    }

    private int generateOrderID() {
        int orderID = 1;

        for (Order order : orderService.getAllOrders()) {
            if (order.getOrderID() >= orderID) {
                orderID = order.getOrderID() + 1;
            }
        }

        return orderID;
    }

    private int readInt() {
        while (true) {
            try {
                return Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Enter a number: ");
            }
        }
    }
}
