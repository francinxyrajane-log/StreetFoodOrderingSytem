import java.util.Scanner;

public class StreetFoodSystem {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Variables
        int choice, quantity;
        double price = 0, total;
        String foodName = "";

        System.out.println("================================");
        System.out.println("     STREET FOOD ORDERING");
        System.out.println("================================");

        // Display Menu
        System.out.println("1. Fish Ball   - P10");
        System.out.println("2. Kikiam      - P15");
        System.out.println("3. Squid Ball  - P20");
        System.out.println("4. Tempura     - P25");
        System.out.println("5. Hotdog      - P20");

        System.out.println("--------------------------------");
        System.out.print("Choose your food (1-5): ");
        choice = input.nextInt();

        // Select Food
        if (choice == 1) {
            foodName = "Fish Ball";
            price = 10;
        }
        else if (choice == 2) {
            foodName = "Kikiam";
            price = 15;
        }
        else if (choice == 3) {
            foodName = "Squid Ball";
            price = 20;
        }
        else if (choice == 4) {
            foodName = "Tempura";
            price = 25;
        }
        else if (choice == 5) {
            foodName = "Hotdog";
            price = 20;
        }
        else {
            System.out.println("Invalid choice!");
            input.close();
            return;
        }

        // Enter Quantity
        System.out.print("Enter quantity: ");
        quantity = input.nextInt();

        // Calculate Total
        total = price * quantity;

        // Display Receipt
        System.out.println("\n================================");
        System.out.println("          ORDER RECEIPT");
        System.out.println("================================");
        System.out.println("Food: " + foodName);
        System.out.println("Price: P" + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("--------------------------------");
        System.out.println("Total Amount: P" + total);
        System.out.println("================================");
        System.out.println("Thank you for ordering!");

        input.close();
    }
}
