package StreetFoodOrdering.src.model;

public class OrderItem {
    // Attributes
    private FoodItem foodItem;
    private int quantity;

        // Constructor
    public OrderItem(FoodItem foodItem, int quantity) {
        this.foodItem = foodItem;
        this.quantity = quantity;
    }

    //getters
    public FoodItem getFoodItem() {
        return foodItem;
    }
    public int getQuantity() {
        return quantity;
    }
    //setters
    public void setFoodItem(FoodItem foodItem) {
        this.foodItem = foodItem;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Calculates the subtotal
    public double getSubtotal() {
        return foodItem.getPrice() * quantity;
    }
}
