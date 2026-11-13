package StreetFoodOrdering.src.presentation;

import java.util.Scanner;

import StreetFoodOrdering.src.business.FoodService;
import StreetFoodOrdering.src.model.FoodItem;

public class FoodMenu {
    private Scanner input;
    private FoodService foodService;

    //costructor: recieves scanner and foodservice
    public FoodMenu(Scanner input, FoodService foodService){
        this.input = input;
        this.foodService = foodService;
    }

    //display the food management menu
    public void displayMenu(){
      int choice;

     do{
            System.out.print("\n===================================\n");
            System.out.println(" FOOD MANAGEMENT ");
            System.out.println("1. Add Food");
            System.out.println("2. View Food ");
            System.out.println("3. Update Food ");
            System.out.println("4. Delete Food ");
            System.out.println("5. Back to Main Menu ");
            System.out.println("==================================");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine();

            switch(choice){
                case 1:
                      addFood();
                      break;
                case 2:
                       viewFood();
                      break;
                case 3:
                      updateFood();
                      break;
                case 4:
                    deleteFoood();
                      break;
                case 5:
                     countFood();
                      break;
                default:      
                    System.out.print("\n\nInvalid choice! Please try again.");
                      break;                  
            }
        }while(choice != 5);
}

