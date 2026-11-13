
package StreetFoodOrdering.src.presentation;

import java.util.Scanner;

public class MainMenu {

    private Scanner input;
    private FoodMenu foodMenu;
    private ViewFoodMenu viewFoodMenu;
    private OrderMenu orderMenu;
    private OrderHistory orderHistory;
    private PaymentMenu paymentMenu;

    // Receives the Scanner and FoodMenu from Main.
    public MainMenu(Scanner input, FoodMenu foodMenu, ViewFoodMenu viewFoodMenu, OrderMenu orderMenu, OrderHistory orderHistory, PaymentMenu paymentMenu) {
        this.input = input;
        this.foodMenu = foodMenu;
        this.viewFoodMenu = viewFoodMenu;
        this.orderMenu = orderMenu;
        this.orderHistory = orderHistory;
        this.paymentMenu = paymentMenu;
    }

    // Displays the main menu.
    public void displayMenu() {
        int choice = 0;

        do {
            ConsoleHelper.clearScreen();

            System.out.println("\n===================================");
            System.out.println("   STREET FOOD MANAGEMENT SYSTEM");
            System.out.println("===================================");
            System.out.println("1. Food Management");
            System.out.println("2. View Food Menu");
            System.out.println("3. Place Order");
            System.out.println("4. View Orders");
            System.out.println("5. Payment");
            System.out.println("6. Exit");
            System.out.println("===================================");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("\nInvalid input! Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    foodMenu.displayFoodManagement();
                    break;
                case 2:
                    viewFoodMenu.displayFoodMenu();
                    break;
                case 3:
                    orderMenu.displayOrderMenu();
                    break;
                case 4:
                    orderHistory.displayOrderHistory();
                    break;
                case 5:
                    paymentMenu.displayPaymentMenu();
                    break;
                case 6:
                    System.out.println("\nThank you for using the system!");
                    break;
                default:
                    System.out.println("\nInvalid choice! Please try again.");
            }

            if (choice != 6) {
                ConsoleHelper.pause(input);
            }

        } while (choice != 6);
    }
}
