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
    private ReceiptView receiptView;

    public OrderMenu(Scanner input, FoodService foodService, OrderService orderService) {
        this.input = input;
        this.foodService = foodService;
        this.orderService = orderService;
        this.receiptView = new ReceiptView();
    }

    //display orer menu
    public void displayOrderMenu() {
        int choice;

        do {
            ConsoleHelper.clearScreen();

            System.out.println("\n===================================");
            System.out.println("             ORDER MENU");
            System.out.println("===================================");
            System.out.println("1. Place Order");
            System.out.println("2. Back");
            System.out.println("===================================");
            System.out.print("Enter your choice: ");

            choice = readInt();

            // Clear screen after entering a choice.
            ConsoleHelper.clearScreen();

            switch (choice) {
                case 1:
                    placeOrder();
                    break;
                case 2:
                    System.out.println("\nReturning to Main Menu...");
                    break;
                default:
                    System.out.println("\nInvalid choice! Please select 1 or 2.");
            }

            if (choice != 2) {
                ConsoleHelper.pause(input);
            }

        } while (choice != 2);
    }

    
    //Place order
    private void placeOrder() {
        if (foodService.getAllFoods().isEmpty()) {
            System.out.println("\nNo food items available!");
            return;
        }

        int orderID = generateOrderID();
        Order order = new Order(orderID);
        String addMore = "Y";

        do {
            ConsoleHelper.clearScreen();

            System.out.println("\n==================== AVAILABLE FOODS ====================");

            System.out.printf("%-8s %-25s %12s%n",
                      "ID", "FOOD NAME", "PRICE");

            System.out.println("---------------------------------------------------------");

            for (FoodItem food : foodService.getAllFoods()) {

                String name = food.getFoodName();

                if (name.length() > 25) {
                    name = name.substring(0, 22) + "...";
                }

                System.out.printf("%-8d %-25s PHP %8.2f%n",
                    food.getFoodID(),
                name,
                food.getPrice());
            }
            System.out.println("=========================================================");


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

           System.out.print("\nAdd another food? (Yes/No): ");
           addMore = readYesNo() ? "Y" : "N";  

        } while (addMore.equalsIgnoreCase("Y"));

        if (orderService.createOrder(order)) {

           ConsoleHelper.clearScreen();
           System.out.println("\nOrder placed successfully!");
           receiptView.displayReceipt(order);
          
           
        } else {
            System.out.println("\nFailed to place order!");
        }
    }


    // Reads Yes or No input.
    private boolean readYesNo() {
        while (true) {
            String answer = input.nextLine().trim();

            if (answer.equalsIgnoreCase("Y")
                    || answer.equalsIgnoreCase("Yes")) {
                return true;
            }

            if (answer.equalsIgnoreCase("N")
                    || answer.equalsIgnoreCase("No")) {
                return false;
            }

            System.out.println("\nInvalid input! Please enter Yes or No.");
            System.out.print("Try again : ");
        }
    }


    //Order ID
    private int generateOrderID() {
        int orderID = 1;

        for (Order order : orderService.getAllOrders()) {
            if (order.getOrderID() >= orderID) {
                orderID = order.getOrderID() + 1;
            }
        }

        return orderID;
    }


    // Reads a valid whole number.
    private int readInt() {
        while (true) {
            try {
                return Integer.parseInt(input.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("\nInvalid input! Please enter numbers only.");
                System.out.print("\nEnter Food ID again : ");
            }
        }
    }
}
