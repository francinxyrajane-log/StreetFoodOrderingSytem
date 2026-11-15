package StreetFoodOrdering.src.presentation;

import StreetFoodOrdering.src.business.FoodService;
import StreetFoodOrdering.src.model.FoodItem;

public class ViewFoodMenu {

    private FoodService foodService;

    public ViewFoodMenu(FoodService foodService) {
        this.foodService = foodService;
    }

    // Displays all available street food.
    public void displayFoodMenu() {

        ConsoleHelper.clearScreen();

        System.out.println("\n==================== AVAILABLE FOOD MENU ====================");

        if (foodService.getAllFoods().isEmpty()) {
            System.out.println("\nNo food items available.");
            System.out.println("=============================================================");
            return;
        }

        System.out.printf("%-8s %-30s %15s%n",
                "ID", "FOOD NAME", "PRICE");

        System.out.println("-------------------------------------------------------------");

        for (FoodItem food : foodService.getAllFoods()) {

            String name = food.getFoodName();

            // Shortens long food names.
            if (name.length() > 30) {
                name = name.substring(0, 27) + "...";
            }

            System.out.printf("%-8d %-30s PHP %10.2f%n",
                    food.getFoodID(),
                    name,
                    food.getPrice());
        }
 
        System.out.println("=============================================================");
    }
}

