package StreetFoodOrdering.src.presentation;

import java.util.Scanner;

public class ConsoleHelper {

    // Clears the console screen.
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // Pauses the program until Enter is pressed.
    public static void pause(Scanner input) {
        System.out.print("\nPress Enter to continue...");
        input.nextLine();
    }
}
