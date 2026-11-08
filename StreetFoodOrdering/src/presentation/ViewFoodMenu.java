package StreetFoodOrdering.src.presentation;

import StreetFoodOrdering.src.business.FoodService;
import StreetFoodOrdering.src.model.FoodItem;

public class ViewFoodMenu {

    private FoodService foodService;

    // Constructor
    public ViewFoodMenu(FoodService foodService) {
        this.foodService = foodService;
    }

    // Display all available street food
    public void displayFoodMenu() {

        System.out.println("\n===================================");
        System.out.println("       AVAILABLE FOOD MENU");
        System.out.println("===================================");

        for (FoodItem food : foodService.getAllFoods()) {

            System.out.println("Food ID: " + food.getFoodID());
            System.out.println("Food Name: " + food.getFoodName());
            System.out.println("Price: " + food.getPrice());

            System.out.println("-----------------------------------");
        }
    }
}
