package src.presentation;

import java.util.Scanner;

import src.model.FoodMenu;

public class Customer {
    private Scanner input;
    private FoodMenu menu;

    public Customer(Scanner input, FoodMenu menu) {
        this.input = input;
        this.menu = menu;
    }

    public void customerMenu() {
        int choice;

        do {
            System.out.println("\n======== CUSTOMER MENU ========");
            System.out.println("1. View Food Menu");
            System.out.println("2. Order Food");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter choice: ");

            choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {
                menu.viewFood();
            } else if (choice == 2) {
                orderFood();
            } else if (choice == 3) {
                System.out.println("Returning to main menu...");
            } else {
                System.out.println("Invalid choice.");
            }

        } while (choice != 3);
    }

    private void orderFood() {
        menu.viewFood();

        if (menu.getCount() == 0) {
            return;
        }

        System.out.print("Choose food number: ");
        int number = input.nextInt();

        Food selectedFood = menu.getFood(number);

        if (selectedFood == null) {
            System.out.println("Invalid food number.");
            input.nextLine();
            return;
        }

        System.out.print("Enter quantity: ");
        int quantity = input.nextInt();
        input.nextLine();

        if (quantity <= 0) {
            System.out.println("Invalid quantity.");
            return;
        }

        double total = selectedFood.getPrice() * quantity;

        System.out.println("\n========== RECEIPT ==========");
        System.out.println("Food: " + selectedFood.getName());
        System.out.println("Price: ₱" + selectedFood.getPrice());
        System.out.println("Quantity: " + quantity);
        System.out.printf("Total: ₱"+ total);
        System.out.println("==============================");
        System.out.println("Thank you for ordering!");
    }
}
