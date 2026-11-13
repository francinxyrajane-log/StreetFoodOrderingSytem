package StreetFoodOrdering.src.business;

import java.util.List;
import StreetFoodOrdering.src.data.OrderRepository;
import StreetFoodOrdering.src.model.Order;
import StreetFoodOrdering.src.model.OrderItem;

public class OrderService {

    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

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

    public List<Order> getAllOrders() {
        return orderRepository.getAllOrders();
    }

    public Order findOrderByID(int orderID) {
        return orderRepository.findOrderByID(orderID);
    }

    public boolean deleteOrder(int orderID) {
        return orderRepository.deleteOrder(orderID);
    }

    public int getOrderCount() {
        return orderRepository.getOrderCount();
    }

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
