package StreetFoodOrdering.src.data;

import java.util.List;
import StreetFoodOrdering.src.model.Order;

public interface OrderRepository {

    void addOrder(Order order);

    List<Order> getAllOrders();

    Order findOrderByID(int orderID);

    boolean deleteOrder(int orderID);

    int getOrderCount();
}