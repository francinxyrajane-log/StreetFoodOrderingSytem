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

            choice = readFoodID();
            ConsoleHelper.clearScreen();

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
            id = readFoodID();

            if (id <= 0) {
                System.out.println("\nFood ID must be greater than 0!");
            } else if (foodService.findFoodByID(id) != null) {
                System.out.println("\nFood ID already exists!");
                System.out.println("\nPlease enter another ID.");
            } else {
                break;
            }
        }
        System.out.print("Enter Food Name: ");
        String name = readFoodName  ();

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
        System.out.println("\n==================== ALL FOODS ====================");

        if (foodService.getAllFoods().isEmpty()) {
            System.out.println("No food items available.");
            return;
        }
        System.out.printf("%-8s %-25s %12s%n",
            "ID", "FOOD NAME", "PRICE");
        System.out.println("---------------------------------------------------");

        for (FoodItem food : foodService.getAllFoods()) {
             String name = food.getFoodName();

            // Limit the food name to 25 characters.
            if (name.length() > 25) {
                name = name.substring(0, 22) + "...";
            }

            System.out.printf("%-8d %-25s PHP %8.2f%n",
                food.getFoodID(),
                name,
                food.getPrice());
        }
        System.out.println("==================================================="); 
    }


    // Updates the name and price of an existing food item.
    private void updateFood() {
            System.out.println("\n--- UPDATE FOOD ---");

            System.out.print("Enter Food ID: ");
            int id = readFoodID();

            FoodItem existingFood = foodService.findFoodByID(id);

        if (existingFood == null) {
            System.out.println("\nFood not found!");
            return;
        }
        System.out.print("Enter New Food Name: ");
        String name = readFoodName();

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
        int id = readFoodID();

        if (foodService.deleteFood(id)) {
            System.out.println("\nFood deleted successfully!");
        } else {
            System.out.println("\nFood not found!");
        }
    }


    // Reads a valid food name (letters and spaces only).
    private String readFoodName() {
        while (true) {
            String name = input.nextLine().trim();

            if (name.isEmpty()) {
                System.out.println("\nFood name cannot be empty!");
            } else if (!name.matches("[a-zA-Z ]+")) {
                System.out.println("\nInvalid food name! Letters only are allowed.");
            } else {
                return name;
            }

            System.out.print("\nEnter Food Name again : ");
        }
    }


    // Reads a valid positive Food ID.
    private int readFoodID() {
        while (true) {
            try {
                int id = Integer.parseInt(input.nextLine().trim());

                if (id <= 0) {
                    System.out.println("\nInvalid Food ID! Enter a number greater than 0.");
                    System.out.print("\nEnter ID again : ");
                    continue;
                }

                return id;

            } catch (NumberFormatException e) {
                System.out.println("\nInvalid Food ID! Numbers only are allowed.");
                System.out.print("\nEnter ID again : ");
            }
        }
    }


    // Reads a decimal number for the food price.
    private double readDouble() {
        while (true) {
            try {
                return Double.parseDouble(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("\nInvalid price. Enter a number: ");
            }
        }
    }
}


