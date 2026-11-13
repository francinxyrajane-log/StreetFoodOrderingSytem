
package StreetFoodOrdering.src.presentation;

import StreetFoodOrdering.src.business.FoodService;
import StreetFoodOrdering.src.model.FoodItem;

public class ViewFoodMenu {

    private FoodService foodService;

    // Receives FoodService from Main.
    public ViewFoodMenu(FoodService foodService) {
        this.foodService = foodService;
    }

    // Displays all available street food.
    public void displayFoodMenu() {

        System.out.println("\n===================================");
        System.out.println("       AVAILABLE FOOD MENU");
        System.out.println("===================================");

        if (foodService.getAllFoods().isEmpty()) {
            System.out.println("No Food Items Available.");
            return;
        }

        // Displays the table headings.
        System.out.printf("%-10s %-20s %-10s%n",
                "Food ID", "Food Name", "Price");

        System.out.println("-------------------------------------");

        // Displays each food item.
        for (FoodItem food : foodService.getAllFoods()) {
            System.out.printf("%-10d %-20s ₱%.2f%n",
                    food.getFoodID(),
                    food.getFoodName(),
                    food.getPrice());
        }

        System.out.println("===================================");
    }
}

