package StreetFoodOrdering.src.data;

import java.util.List;
import StreetFoodOrdering.src.model.Order;

public class OrderRepository {

    //adds a new order
    void addOrder(Order order);

    //returns all orders
    List<Order> getAllOrders();

    //finds an order using its ID
    Order findOrderByID(int orderID);

    //deletes an order using its id
    boolean deleteOrder(int orderID);

    //Returns the total number of orders
    int getOrderCount();
}
