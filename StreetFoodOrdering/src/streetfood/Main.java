

package StreetFoodOrdering.src.streetfood;

import java.util.Scanner;

// Data
import StreetFoodOrdering.src.data.FoodRepositorySystem;
import StreetFoodOrdering.src.data.InMemoryFoodRepository;
import StreetFoodOrdering.src.data.OrderRepository;
import StreetFoodOrdering.src.data.InMemoryOrderRepository;

// Business
import StreetFoodOrdering.src.business.FoodService;
import StreetFoodOrdering.src.business.OrderService;

// Presentation
import StreetFoodOrdering.src.presentation.FoodMenu;
import StreetFoodOrdering.src.presentation.ViewFoodMenu;
import StreetFoodOrdering.src.presentation.OrderMenu;
import StreetFoodOrdering.src.presentation.MainMenu;
import StreetFoodOrdering.src.presentation.OrderHistory;

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

        // Main menu
        MainMenu mainMenu = new MainMenu(input, foodMenu, viewFoodMenu, orderMenu, orderHistory);

        mainMenu.displayMenu();

        input.close();
    }
}
