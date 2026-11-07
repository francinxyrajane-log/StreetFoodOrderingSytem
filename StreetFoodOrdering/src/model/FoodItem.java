package StreetFoodOrdering.src.model;

public class FoodItem {
    private int foodID;
    private String foodName;
    private double price;

    public FoodItem(int FoodId, String foodName, double price){
        this.foodID = foodID;
        this.foodName = foodName;
        this.price = price;
    }

    //getters
    public int getFoodID() {
        return foodID;
    }
     public String getFoodName() {
        return foodName;
    }
     public double getPrice() {
        return price;
    }

    //setters
    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}
