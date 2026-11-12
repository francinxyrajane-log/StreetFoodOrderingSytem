package StreetFoodOrdering.src.presentation;

import java.util.Scanner;
import StreetFoodOrdering.src.business.FoodService;
import StreetFoodOrdering.src.model.FoodItem;

public class FoodMenu {

    private Scanner input;
    private FoodService foodService;

    // Receives the Scanner and FoodService from the Main class.
    public FoodMenu(Scanner input, FoodService foodService) {
        this.input = input;
        this.foodService = foodService;
    }

    // Displays the food management menu.
    public void displayFoodManagement() {
        int choice;

        do {
            ConsoleHelper.clearScreen();

            System.out.println("\n===================================");
            System.out.println("       FOOD MANAGEMENT");
            System.out.println("===================================");
            System.out.println("1. Add Food");
            System.out.println("2. View All Foods");
            System.out.println("3. Update Food");
            System.out.println("4. Delete Food");
            System.out.println("5. Back");
            System.out.println("===================================");
            System.out.print("Enter your choice: ");

            choice = readInt();

            switch (choice) {
                case 1:
                    addFood();
                    break;
                case 2:
                    viewAllFoods();
                    break;
                case 3:
                    updateFood();
                    break;
                case 4:
                    deleteFood();
                    break;
                case 5:
                    System.out.println("\nReturning to Main Menu...");
                    break;
                default:
                    System.out.println("\nInvalid choice! Please try again.");
            }

            if (choice != 5) {
                ConsoleHelper.pause(input);
            }

        } while (choice != 5);
    }

    // Adds a new food item.
    private void addFood() {
        System.out.println("\n--- ADD FOOD ---");

        int id;

        // Check if the Food ID already exists.
        while (true) {
            System.out.print("Enter Food ID: ");
            id = readInt();

            if (id <= 0) {
                System.out.println("\nFood ID must be greater than 0!");
            } else if (foodService.findFoodByID(id) != null) {
                System.out.println("\nFood ID already exists!");
                System.out.println("Please enter another ID.");
            } else {
                break;
            }
        }

        System.out.print("Enter Food Name: ");
        String name = input.nextLine();

        System.out.print("Enter Price: ");
        double price = readDouble();

        FoodItem food = new FoodItem(id, name, price);

        if (foodService.addFood(food)) {
            System.out.println("\nFood added successfully!");
        } else {
            System.out.println("\nFailed to add food. Check the entered details.");
        }
    }

    // Displays all available food items.
    private void viewAllFoods() {
        System.out.println("\n--- ALL FOODS ---");

        if (foodService.getAllFoods().isEmpty()) {
            System.out.println("No food items available.");
            return;
        }

        for (FoodItem food : foodService.getAllFoods()) {
            System.out.printf("ID: %d | Name: %s | Price: ₱%.2f%n",
                    food.getFoodID(),
                    food.getFoodName(),
                    food.getPrice());
        }
    }

    // Updates the name and price of an existing food item.
    private void updateFood() {
        System.out.println("\n--- UPDATE FOOD ---");

        System.out.print("Enter Food ID: ");
        int id = readInt();

        FoodItem existingFood = foodService.findFoodByID(id);

        if (existingFood == null) {
            System.out.println("\nFood not found!");
            return;
        }

        System.out.print("Enter New Food Name: ");
        String name = input.nextLine();

        System.out.print("Enter New Price: ");
        double price = readDouble();

        FoodItem updatedFood = new FoodItem(id, name, price);

        if (foodService.updateFood(updatedFood)) {
            System.out.println("\nFood updated successfully!");
        } else {
            System.out.println("\nFailed to update food.");
        }
    }

    // Deletes a food item using its ID.
    private void deleteFood() {
        System.out.println("\n--- DELETE FOOD ---");

        System.out.print("Enter Food ID: ");
        int id = readInt();

        if (foodService.deleteFood(id)) {
            System.out.println("\nFood deleted successfully!");
        } else {
            System.out.println("\nFood not found!");
        }
    }

    // Reads an integer and prevents invalid number input.
    private int readInt() {
        while (true) {
            try {
                return Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Enter a number: ");
            }
        }
    }

    // Reads a decimal number for the food price.
    private double readDouble() {
        while (true) {
            try {
                return Double.parseDouble(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid price. Enter a number: ");
            }
        }
    }
}


