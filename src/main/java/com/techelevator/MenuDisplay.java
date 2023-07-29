package com.techelevator;

import java.util.Scanner;

public class MenuDisplay {

    private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
    private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
    private static final String MAIN_MENU_EXIT = "Exit";
    private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE };

    private static final Scanner scanner = new Scanner(System.in);

    private InventoryManager inventoryManager = new InventoryManager();
    private PurchaseMenuDisplay purchaseMenu = new PurchaseMenuDisplay();

    public void mainMenu() {
        while (true) {
            System.out.println();
            System.out.println("1) " + MAIN_MENU_OPTION_DISPLAY_ITEMS);
            System.out.println("2) " + MAIN_MENU_OPTION_PURCHASE);
            System.out.println("3) " + MAIN_MENU_EXIT);

            System.out.println();
            System.out.println("Please input a value 1 to 3.");
            int userInput = scanner.nextInt();

            switch (userInput) {
                case 1: // display items
                    System.out.println();
                    System.out.println("Displaying items.");
                    inventoryManager.createInventory();
                    break;
                case 2: // purchase
                    System.out.println();
                    System.out.println("Displaying Purchase Menu.");
                    purchaseMenu.purchaseMenu();
                    break;
                case 3: // exit
                    System.out.println();
                    System.out.println("Thank you for your patronage. Goodbye!");
                    System.exit(0);
                    break;
                default: // catch incorrect input
                    System.out.println();
                    System.out.println("Invalid input.");
                    break;
            }
            System.out.println();
            System.out.println("Press enter to return to the main menu.");
            scanner.nextLine();
        }
    }
}