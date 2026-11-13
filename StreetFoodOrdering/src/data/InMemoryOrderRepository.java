package StreetFoodOrdering.src.data;

import java.util.ArrayList;
import java.util.List;
import StreetFoodOrdering.src.model.Order;

public class InMemoryOrderRepository implements OrderRepository {

    private List<Order> orderList = new ArrayList<>();

    @Override
    public void addOrder(Order order) {
        orderList.add(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return new ArrayList<>(orderList);
    }

    @Override
    public Order findOrderByID(int orderID) {
        for (Order order : orderList) {
            if (order.getOrderID() == orderID) {
                return order;
            }
        }
        return null;
    }

    @Override
    public boolean deleteOrder(int orderID) {
        Order order = findOrderByID(orderID);

        if (order != null) {
            orderList.remove(order);
            return true;
        }

        return false;
    }

    @Override
    public int getOrderCount() {
        return orderList.size();
    }
}

