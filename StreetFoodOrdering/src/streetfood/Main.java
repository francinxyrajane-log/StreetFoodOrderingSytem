

package StreetFoodOrdering.src.streetfood;

import java.util.Scanner;

// Data
import StreetFoodOrdering.src.data.FoodRepositorySystem;
import StreetFoodOrdering.src.data.InMemoryFoodRepository;
import StreetFoodOrdering.src.data.OrderRepository;
import StreetFoodOrdering.src.data.InMemoryOrderRepository;
import StreetFoodOrdering.src.data.PaymentRepository;
import StreetFoodOrdering.src.data.InMemoryPaymentRepository;

// Business
import StreetFoodOrdering.src.business.FoodService;
import StreetFoodOrdering.src.business.OrderService;
import StreetFoodOrdering.src.business.PaymentService;

// Presentation
import StreetFoodOrdering.src.presentation.FoodMenu;
import StreetFoodOrdering.src.presentation.ViewFoodMenu;
import StreetFoodOrdering.src.presentation.OrderMenu;
import StreetFoodOrdering.src.presentation.MainMenu;
import StreetFoodOrdering.src.presentation.OrderHistory;
import StreetFoodOrdering.src.presentation.PaymentMenu;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Food setup
        FoodRepositorySystem foodRepository = new InMemoryFoodRepository();
        FoodService foodService = new FoodService(foodRepository);

        // Order setup
        OrderRepository orderRepository = new InMemoryOrderRepository();
        OrderService orderService = new OrderService(orderRepository);

        // Menu setup
        FoodMenu foodMenu = new FoodMenu(input, foodService);
        ViewFoodMenu viewFoodMenu = new ViewFoodMenu(foodService);
        OrderMenu orderMenu = new OrderMenu(input, foodService, orderService);
        OrderHistory orderHistory = new OrderHistory(orderService);

        //Payment stup
        PaymentRepository paymentRepository = new InMemoryPaymentRepository();
        PaymentService paymentService = new PaymentService(paymentRepository);
        PaymentMenu paymentMenu = new PaymentMenu(input, orderService, paymentService);

        // Main menu
        MainMenu mainMenu = new MainMenu(input, foodMenu, viewFoodMenu, orderMenu, orderHistory, paymentMenu);

        mainMenu.displayMenu();

        input.close();
    }
}
