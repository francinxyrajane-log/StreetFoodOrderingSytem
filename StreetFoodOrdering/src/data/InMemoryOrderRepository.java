package StreetFoodOrdering.src.data;

import java.util.ArrayList;
import java.util.List;
import StreetFoodOrdering.src.model.Order;

public class InMemoryOrderRepository {

    //stores all customer orders
    private List<Order> orderList = new Arraylist<>();

    //adds a new order
    @Override 
    public void addOrder(Order order){
        orderList.add(order);
    }

    //returns all saved orders
    @Override 
    public List<Order> getAllOrders(){
        return new ArrayList<>(orderList);
    }

    //finds an order using its ID
    @Override 
    public Order findOrderByID(int orderID){
        for(Order order : orderList){
            if(order.getOrderID() == orderID){
                return order;
            }
        }
        return null;
    }

    //return the total number of orders
    @Override 
    public int getOrderCount(){
        return orderList.size();
    }
}
