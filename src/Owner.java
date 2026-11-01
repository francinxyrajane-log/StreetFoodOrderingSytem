package src;
import java.util.Scanner;

public class Owner{
    private Scanner input;
    private FoodMenu menu;

    public Owner(Scanner input, FoodMenu menu){
        this.input = input;
        this.menu = menu; 
    }

    //Add
    private void addFood(){
        System.out.println("Enter food name: ");
        String name = input.nextLine();
        System.out.println("Enter food price: ");
        double price = input.nextDouble();
        input.nextLine();

        if(price > 0 && !name.trim().isEmpty()){
            menu.addFood(name,price);
        }else{
             System.out.println("Invalid name or price!");
        }
    }

    //Update
    private void updateFood() {
        menu.viewFood();

        System.out.print("Enter food number to update: ");
        int number = input.nextInt();
        input.nextLine();

        Food food = menu.getFood(number);

        if (food != null) {
            System.out.print("Enter new food name: ");
            String newName = input.nextLine();

            System.out.print("Enter new price: ");
            double newPrice = input.nextDouble();
            input.nextLine();

            if (newPrice > 0 && !newName.trim().isEmpty()) {
                menu.updateFood(number, newName, newPrice);
            } else {
                System.out.println("Invalid name or price.");
            }
        } else {
            System.out.println("Invalid food number.");
        }
    }

    //Delete
    private void deleteFood() {
        menu.viewFood();

        System.out.print("Enter food number to delete: ");
        int number = input.nextInt();
        input.nextLine();

        menu.deleteFood(number);
    }

    public void ownerMenu(){
        int choice;

        do{
            System.out.println(" =============== OWNER MENU ===============");
            System.out.println("1. Add Food ");
            System.out.println("2. View Food ");
            System.out.println("3. Update Food ");
            System.out.println("4. Delete Food ");
            System.out.println("5. Back to Main Menu ");
            System.out.print("Enter Choice: ");

            choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {
                addFood();
            }else if (choice == 2) {
                menu.viewFood();
            }else if (choice == 3) {
                updateFood();
            }else if (choice == 4) {
                deleteFood();
            }else if (choice == 5) {
                System.out.println("Returning to main menu.");
            }else {
                System.out.println("Invalid choice!");
                input.close();
                return;
            }
        }while(choice !=5);
    }
}