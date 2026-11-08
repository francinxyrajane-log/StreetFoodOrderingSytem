package StreetFoodOrdering.src.data;

import StreetFoodOrdering.src.model.FoodItem;
//import StreetFoodOrdering.src.business.FoodService;
import java.util.List;

public interface FoodRepositorySystem {
     
    //add food item
    void addFood(FoodItem food);
    
    //get all food items
    List<FoodItem> getAllFoods();

    //find a food item using its ID
    FoodItem findFoodByID(int foodID);

    //update an existing food item
    boolean updateFood(FoodItem food);

    //delete a food item using its id
    boolean deleteFood(int foodID);

    //get the total number of food items
    int getFoodCount();
    
}
