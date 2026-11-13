package StreetFoodOrdering.src.business;

import java.util.List;
import StreetFoodOrdering.src.data.OrderRepository;
import StreetFoodOrdering.src.model.Order;
import StreetFoodOrdering.src.model.OrderItem;

public class OrderService {

    private OrderRepositorySystem orderRepository;

    public OrderService(OrderRepositorySystem orderRepository) {
        this.orderRepository = orderRepository;
    }

    // Creates a new order.
    public boolean createOrder(Order order) {
        if (!isValidOrder(order)) {
            return false;
        }

        if (orderRepository.findOrderByID(order.getOrderID()) != null) {
            return false;
        }

        orderRepository.addOrder(order);
        return true;
    }

    // Returns all orders.
    public List<Order> getAllOrders() {
        return orderRepository.getAllOrders();
    }

    // Finds an order using its ID.
    public Order findOrderByID(int orderID) {
        return orderRepository.findOrderByID(orderID);
    }

    // Deletes an order.
    public boolean deleteOrder(int orderID) {
        return orderRepository.deleteOrder(orderID);
    }

    // Returns the total number of orders.
    public int getOrderCount() {
        return orderRepository.getOrderCount();
    }

    // Checks if the order contains valid details.
    private boolean isValidOrder(Order order) {
        if (order == null || order.getOrderID() <= 0
                || order.getOrderItems() == null
                || order.getOrderItems().isEmpty()) {
            return false;
        }

        for (OrderItem item : order.getOrderItems()) {
            if (item == null || item.getFoodItem() == null
                    || item.getQuantity() <= 0) {
                return false;
            }
        }

        return true;
    }
}


