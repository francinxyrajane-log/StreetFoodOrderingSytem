package StreetFoodOrdering.src.business;
import java.util.List;
import StreetFoodOrdering.src.model.FoodItem;
import StreetFoodOrdering.src.data.FoodRepositorySystem;

public class FoodService {

    //repository used to access food records
    private FoodRepositorySystem foodRepositorySystem;

    //constructor recieves the FoodRepositorySystem object
    public FoodService(FoodRepositorySystem foodRepositorySystem){
        this.foodRepositorySystem = foodRepositorySystem;
    }

    //adds a food item after checking
    public boolean addFood(FoodItem food){
        if(food == null){
            return false;
        }
        if (food.getFoodName() == null || food.getFoodName().trim().isEmpty()){
            return false;
        }
        if(food.getPrice() <= 0){
            return false;
        }

        //prevent duplicate foodId's
        if(foodRepositorySystem.findFoodByID(food.getFoodID())!= null){
            return false;
        }
            
            foodRepositorySystem.addFood(food);
            return true;
    }

    //gets all availeble food records
    public List<FoodItem> getAllFoods(){
        return foodRepositorySystem.getAllFoods();
    }

    //finds a food item by its ID
    public FoodItem findFoodByID(int foodID){
        return foodRepositorySystem.findFoodByID(foodID);
    }

    //validates and update a food item
    public boolean updateFood(FoodItem food){

        if(food == null){
            return false;
        }
        if(food.getFoodName() == null || food.getFoodName().trim().isEmpty()){
           return false;
        }
        if(food.getPrice() <= 0){
            return false;
        }
            return foodRepositorySystem.updateFood(food);
    }

    //delete food item
    public boolean deleteFood(int foodID){
        return foodRepositorySystem.deleteFood(foodID);
    }

    //gets the total number of food items
    public int getFoodCount(){
        return foodRepositorySystem.getFoodCount();
    }

    // Checks whether the food details are valid.
    private boolean isValidFood(FoodItem food) {
        return food != null
                && food.getFoodID() > 0
                && food.getFoodName() != null
                && !food.getFoodName().trim().isEmpty()
                && food.getPrice() > 0;
    }
    
}