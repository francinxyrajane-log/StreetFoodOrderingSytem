package StreetFoodOrdering.src.data;

import java.util.ArrayList;
import java.util.List;
import StreetFoodOrdering.src.model.Order;

public class InMemoryOrderRepository {


    // Stores all customer orders.
    private List<Order> orderList = new ArrayList<>();

    // Adds a new order.
    @Override
    public void addOrder(Order order) {
        orderList.add(order);
    }

    // Returns all saved orders.
    @Override
    public List<Order> getAllOrders() {
        return new ArrayList<>(orderList);
    }

    // Finds an order using its ID.
    @Override
    public Order findOrderByID(int orderID) {
        for (Order order : orderList) {
            if (order.getOrderID() == orderID) {
                return order;
            }
        }
        return null;
    }

    // Deletes an order using its ID.
    @Override
    public boolean deleteOrder(int orderID) {
        Order order = findOrderByID(orderID);

        if (order != null) {
            orderList.remove(order);
            return true;
        }
        return false;
    }

    // Returns the total number of orders.
    @Override
    public int getOrderCount() {
        return orderList.size();
    }

}

