
package StreetFoodOrdering.src.streetfood;

import java.util.Scanner;

import StreetFoodOrdering.src.data.FoodRepositorySystem;
import StreetFoodOrdering.src.data.InMemoryFoodRepository;
import StreetFoodOrdering.src.business.FoodService;
import StreetFoodOrdering.src.presentation.FoodMenu;
import StreetFoodOrdering.src.presentation.MainMenu;

public class Main {

    public static void main(String[] args) {

        // Creates one Scanner for user input.
        Scanner input = new Scanner(System.in);

        // Creates the food repository for storing food records.
        FoodRepositorySystem foodRepository = new InMemoryFoodRepository();

        // Connects the repository to the business logic.
        FoodService foodService = new FoodService(foodRepository);

        // Creates the food management menu.
        FoodMenu foodMenu = new FoodMenu(input, foodService);

        // Creates the main menu.
        MainMenu mainMenu = new MainMenu(input, foodMenu);

        // Starts the application.
        mainMenu.displayMenu();

        input.close();
    }
}
