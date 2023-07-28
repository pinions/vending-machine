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
        System.out.println("Please input a value 1 to 3.");
        String userInput = scanner.nextLine();

        boolean incorrectInput = true;

        while (incorrectInput)
        {
            switch (userInput)
            {
                case "1":
                    // display items method
                    System.out.println("Displaying items.");
                    incorrectInput = false;
                    break;
                case "2":
                    // purchase method
                    System.out.println("Purchase Menu selected.");
                    incorrectInput = false;
                    break;
                case "3":
                    // exit
                    System.out.println("Thank you for your service, goodbye!");
                    System.exit(1);
                default:
                    System.out.println();
                    System.out.println("Please input a value 1 to 3.");
                    userInput = scanner.nextLine();
                    break;
            }
        }
        System.out.println();
        System.out.println("Thank you for your purchase.");
    }

}
