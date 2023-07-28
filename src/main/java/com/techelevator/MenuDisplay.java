package com.techelevator;

import java.util.Scanner;

public class MenuDisplay {

    private static final String DISPLAY_ITEMS = "Display Vending Machine Items";
    private static final String PURCHASE = "Purchase";
    private static final String EXIT = "Exit";
    private static final Scanner scanner = new Scanner(System.in);

    public void mainMenu()
    {
        System.out.println("1) " + DISPLAY_ITEMS);
        System.out.println("2) " + PURCHASE);
        System.out.println("3) " + EXIT);

        System.out.println();
        System.out.println("Please input a number to select desired location: ");
        String userInput = scanner.nextLine();

        boolean incorrectInput = true;
        PurchaseMenuDisplay display = new PurchaseMenuDisplay();

        while (incorrectInput)
        {
            switch (userInput)
            {
                case "1":   // Display Vending Machine Items
                    System.out.println("Displaying items.");
                    System.out.println();

                    // ROUTE TO DISPLAY ITEMS HERE


                    incorrectInput = false;
                    break;

                case "2":   // Purchase
                    System.out.println("Purchase Menu selected.");
                    System.out.println();

                    // ROUTE TO PURCHASE MENU HERE
                    display.purchaseMenu();

                    incorrectInput = false;
                    break;

                case "3":   // exit -> ends program
                    System.out.println("Thank you for your service, goodbye!");
                    System.exit(1);

                default: // loop back through if bad input
                    System.out.println();
                    System.out.println("Please input a number to select desired location: ");
                    userInput = scanner.nextLine();
                    break;
            }
        }
        System.out.println();
        System.out.println("Thank you for your purchase.");
    }

}
