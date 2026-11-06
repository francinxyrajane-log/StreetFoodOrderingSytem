package StreetFoodOrdering.src.presentation;
import java.util.Scanner;

public class MainMenu {
   private Scanner input;
   
   public MainMenu(Scanner input){
    this.input = input;
   }

      public void displayMenu(){
      int choice;

     do{
            System.out.print("\n===================================\n");
            System.out.println("  STREET FOOD MANAGEMENT SYSTEM  ");
            System.out.println("1. Food Management ");
            System.out.println("2. View Food Menu ");
            System.out.println("3. Place Order ");
            System.out.println("4. View Orders ");
            System.out.println("5. Exit ");
            System.out.println("==================================");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine();

            switch(choice){
                case 1:
                      System.out.print("\nOpening Food Management ");
                      break;
                case 2:
                    System.out.print("\nOpening View Food Menu ");
                      break;
                case 3:
                    System.out.print("\nOpening Place Order ");
                      break;
                case 4:
                    System.out.print("\nOpening View Orders ");
                      break;
                case 5:
                    System.out.print("\nThankyou for using the system! ");
                      break;
                default:      
                    System.out.print("\n\nInvalid choice! Please try again.");
                      break;                  
            }
        }while(choice != 5);
    }
}
