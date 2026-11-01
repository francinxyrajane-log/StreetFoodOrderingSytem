package src.presentation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        FoodMenu menu = new FoodMenu();

        Owner owner = new Owner(input, menu);
        Customer customer = new Customer(input, menu);

        int choice;

        do {
            System.out.println("\n================================");
            System.out.println("   STREET FOOD ORDERING SYSTEM");
            System.out.println("================================");
            System.out.println("1. Owner");
            System.out.println("2. Customer");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {
                owner.ownerMenu();
            } else if (choice == 2) {
                customer.customerMenu();
            } else if (choice == 3) {
                System.out.println("Thank you for ordering!");
            } else {
                System.out.println("Invalid choice.");
            }

        } while (choice != 3);

        input.close();
    }
}


