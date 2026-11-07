package StreetFoodOrdering.src.business;

import StreetFoodOrdering.src.presentation.FoodMenu;
import StreetFoodOrdering.src.model.FoodItem;
import StreetFoodOrdering.src.data.FoodRepositorySystem;

public class FoodService {
   
    //repository used to access food records
    private FoodRepositorySystem foodRepositorySystem;

    //constructor recieves the FoodRepositorySystem object
    public FoodService(FoodRepositorySystem foodRepositorySystem){
        this.foodRepositorySystem = foodRepositorySystem;
    }

    // add anew food item
    public void addFood(FoodItem food){

            //check if food name is empty
        if(food.getFoodName() == null || food.getFoodName().trim().isEmpty()){
            System.out.print("Food name connot be empty! ");
            return;
        }
            //check if the price is valid
        if(food.getPrice() <= 0){
        System.out.println("Price must be greater than zero!");
        return;
        }
             //save the food item
        System.out.println("Food added successfully!");
    }

    /*  
    public void displayAllFood(){
        //get all food items from the repository
        for (FoodItem food : foodRepository.GetAllFoods()){
            System.out.println("Food ID : " + food.getFoodID());
            System.out.println("Food Name : " + food.getFoodName());
            System.out.println("Price : "+ food.getPrice());
            System.out.println();
        }
    }

    //search for a food item using its id
    public FoodItem findBodyId(int foodID){
        for(foodItem food : food)
    }
        */
}
