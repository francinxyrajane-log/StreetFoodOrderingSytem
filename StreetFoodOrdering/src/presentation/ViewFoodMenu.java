package StreetFoodOrdering.src.presentation;
import StreetFoodOrdering.src.business.FoodService;

public class ViewFoodMenu {
    private FoodService foodService;

    //Constructor
    public ViewFoodMenu(FoodService foodService){
        this.foodService = foodService;
    }

    //method displaying alla avialable street food
    public void displayFoodMenu(){
        System.out.println("\n===================================");
        System.out.println("  AVAILABLE FOOD MENU  ");
        System.out.println("===================================");

        
        System.out.print("===================================");
    }
}
