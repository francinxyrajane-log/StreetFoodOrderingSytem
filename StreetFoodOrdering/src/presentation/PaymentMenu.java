
package StreetFoodOrdering.src.presentation;

import java.util.Scanner;
import StreetFoodOrdering.src.business.OrderService;
import StreetFoodOrdering.src.business.PaymentService;
import StreetFoodOrdering.src.model.Order;
import StreetFoodOrdering.src.model.Payment;

public class PaymentMenu {

    private Scanner input;
    private OrderService orderService;
    private PaymentService paymentService;

    // Constructor
    public PaymentMenu(Scanner input, OrderService orderService,
                       PaymentService paymentService) {
        this.input = input;
        this.orderService = orderService;
        this.paymentService = paymentService;
    }

    // Displays the payment menu.
    public void displayPaymentMenu() {
        int choice;

        do {
            ConsoleHelper.clearScreen();

            System.out.println("\n===================================");
            System.out.println("          PAYMENT MENU");
            System.out.println("===================================");
            System.out.println("1. Pay Order");
            System.out.println("2. View Payments");
            System.out.println("3. Back");
            System.out.println("===================================");
            System.out.print("Enter your choice: ");

            choice = readInt();

            switch (choice) {
                case 1:
                    payOrder();
                    break;
                case 2:
                    viewPayments();
                    break;
                case 3:
                    System.out.println("\nReturning to Main Menu...");
                    break;
                default:
                    System.out.println("\nInvalid choice!");
            }

            if (choice != 3) {
                ConsoleHelper.pause(input);
            }

        } while (choice != 3);
    }

    // Processes an order payment.
    private void payOrder() {
        System.out.println("\n--- PAY ORDER ---");

        if (orderService.getAllOrders().isEmpty()) {
            System.out.println("No orders available.");
            return;
        }

        System.out.print("Enter Order ID: ");
        int orderID = readInt();

        Order order = orderService.findOrderByID(orderID);

        if (order == null) {
            System.out.println("\nOrder not found!");
            return;
        }

        if (paymentService.findPaymentByOrderID(orderID) != null) {
            System.out.println("\nThis order has already been paid!");
            return;
        }

        double total = order.getTotalAmount();

        System.out.printf("\nTotal Amount: ₱%.2f%n", total);

        System.out.println("\nSelect Payment Method:");
        System.out.println("1. Cash");
        System.out.println("2. GCash");
        System.out.print("Enter choice: ");

        int methodChoice = readInt();

        String paymentMethod;
        double amountPaid;

        if (methodChoice == 1) {
            paymentMethod = "Cash";

            do {
                System.out.print("Enter Amount Paid: ₱");
                amountPaid = readDouble();

                if (amountPaid < total) {
                    System.out.println("Insufficient payment! Please try again.");
                }

            } while (amountPaid < total);

        } else if (methodChoice == 2) {
            paymentMethod = "GCash";

            // Simulated GCash payment.
            amountPaid = total;

            System.out.println("\nGCash payment simulated successfully!");

        } else {
            System.out.println("\nInvalid payment method!");
            return;
        }

        int paymentID = generatePaymentID();

        Payment payment = new Payment(
                paymentID,
                orderID,
                paymentMethod,
                amountPaid,
                total
        );

        if (paymentService.processPayment(payment)) {
            System.out.println("\n===================================");
            System.out.println("       PAYMENT SUCCESSFUL!");
            System.out.println("===================================");
            System.out.println("Payment ID: " + paymentID);
            System.out.println("Order ID: " + orderID);
            System.out.println("Payment Method: " + paymentMethod);
            System.out.printf("Total Amount: ₱%.2f%n", total);
            System.out.printf("Amount Paid: ₱%.2f%n", amountPaid);
            System.out.printf("Change: ₱%.2f%n", payment.getChange());
            System.out.println("===================================");
        } else {
            System.out.println("\nPayment failed!");
        }
    }

    // Displays all recorded payments.
    private void viewPayments() {
        System.out.println("\n--- PAYMENT HISTORY ---");

        if (paymentService.getAllPayments().isEmpty()) {
            System.out.println("No payment records available.");
            return;
        }

        for (Payment payment : paymentService.getAllPayments()) {
            System.out.println("-----------------------------------");
            System.out.println("Payment ID: " + payment.getPaymentID());
            System.out.println("Order ID: " + payment.getOrderID());
            System.out.println("Method: " + payment.getPaymentMethod());
            System.out.printf("Total: ₱%.2f%n", payment.getTotalAmount());
            System.out.printf("Paid: ₱%.2f%n", payment.getAmountPaid());
            System.out.printf("Change: ₱%.2f%n", payment.getChange());
        }

        System.out.println("-----------------------------------");
        System.out.println("Total Payments: " + paymentService.getPaymentCount());
    }

    // Generates the next Payment ID.
    private int generatePaymentID() {
        int paymentID = 1;

        for (Payment payment : paymentService.getAllPayments()) {
            if (payment.getPaymentID() >= paymentID) {
                paymentID = payment.getPaymentID() + 1;
            }
        }

        return paymentID;
    }

    // Reads integer input.
    private int readInt() {
        while (true) {
            try {
                return Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Enter a number: ");
            }
        }
    }

    // Reads decimal input.
    private double readDouble() {
        while (true) {
            try {
                return Double.parseDouble(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid amount. Enter a number: ₱");
            }
        }
    }
}

