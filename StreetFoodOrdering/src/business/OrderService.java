package StreetFoodOrdering.src.business;

import java.util.List;
import StreetFoodOrdering.src.data.OrderRepository;
import StreetFoodOrdering.src.model.Order;
import StreetFoodOrdering.src.model.OrderItem;

public class OrderService {

    //attributes
    private int orderID;
    private List<OrderItem> orderItems;

    //constructor
    public Order(int orderID){
        this.orderID = orderID;
        this.orderItems = new ArrayList<>();

    }

    //getters
    public int getOrderID(){
        return orderID;
    }

    public List<OrderItem> getOrderItems(){
        return orderItems;
    }

    //adds an item to the order
    public void addOrderItem(OrderItem item){
        orderItems.add(item);
    }

    //calculatesnthe total amount
    public double getTotalAmount(){
       double total = 0;

       for(OrderItem item : orderItems){
        total += item.getSubtotal();
       }
       return total;
    }

}
