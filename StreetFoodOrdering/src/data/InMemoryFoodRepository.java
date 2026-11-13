package StreetFoodOrdering.src.data;

import java.util.ArrayList;
import java.util.List;

import StreetFoodOrdering.src.model.FoodItem;

public class InMemoryFoodRepository implements FoodRepositorySystem {

   
    // Stores all food records
    private List<FoodItem> foodList = new ArrayList<>();

    // Adds a food item
    @Override
    public void addFood(FoodItem food) {
        foodList.add(food);
    }

    // Gets all food items
    @Override
    public List<FoodItem> getAllFoods() {
        return new ArrayList<>(foodList);
    }

    // Finds a food item using its ID
    @Override
    public FoodItem findFoodByID(int foodID) {

        for (FoodItem food : foodList) {
            if (food.getFoodID() == foodID) {
                return food;
            }
        }

        return null;
    }

    // Updates an existing food item
    @Override
    public boolean updateFood(FoodItem food) {

        for (int i = 0; i < foodList.size(); i++) {

            if (foodList.get(i).getFoodID() == food.getFoodID()) {
                foodList.set(i, food);
                return true;
            }
        }

        return false;
    }

    // Deletes a food item
    @Override
    public boolean deleteFood(int foodID) {

        FoodItem food = findFoodByID(foodID);

        if (food != null) {
            foodList.remove(food);
            return true;
        }

        return false;
    }

    // Gets the total number of food items
    @Override
    public int getFoodCount() {
        return foodList.size();
    }
        
}

