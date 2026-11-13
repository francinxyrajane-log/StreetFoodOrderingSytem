package StreetFoodOrdering.src.data;

import java.util.List;
import StreetFoodOrdering.src.model.Order;

public class OrderRepository {

    // Adds a new order.
    void addOrder(Order order);

    // Returns all orders.
    List<Order> getAllOrders();

    // Finds an order using its ID.
    Order findOrderByID(int orderID);

    // Deletes an order using its ID.
    boolean deleteOrder(int orderID);

    // Returns the total number of orders.
    int getOrderCount();
}

