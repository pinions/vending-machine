package com.techelevator;

import java.util.Scanner;

public class MenuDisplay {

    private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
    private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
    private static final String MAIN_MENU_EXIT = "Exit";
    private static final Scanner scanner = new Scanner(System.in);

    private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
    private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
    private static final String PURCHASE_MENU_FINISH_TRANSACTION = "Finish Transaction";

    public static void menu() {
        System.out.println("1) " + MAIN_MENU_OPTION_DISPLAY_ITEMS);
        System.out.println("2) " + MAIN_MENU_OPTION_PURCHASE);
        System.out.println("3) " + MAIN_MENU_EXIT);

        System.out.println();
        System.out.println("Please input a value 1 to 3.");
        String userInput = scanner.nextLine();

        boolean incorrectInput = true;

        while (incorrectInput) {
            switch (userInput) {
                case "1":
                    // display items method
                    incorrectInput = false;
                    break;
                case "2":
                    // purchase method
                    incorrectInput = false;
                    break;
                case "3":
                    // exit
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

    public static void purchaseMenu() {
        System.out.println("1) " + PURCHASE_MENU_OPTION_FEED_MONEY);
        System.out.println("2) " + PURCHASE_MENU_OPTION_SELECT_PRODUCT);
        System.out.println("3) " + PURCHASE_MENU_FINISH_TRANSACTION);

        System.out.println();
        System.out.println("Please input a value 1 to 3.");
        String userInput = scanner.nextLine();

        boolean incorrectInput = true;

        while (incorrectInput) {
            switch (userInput) {
                case "1":
                    // feed money method
                    incorrectInput = false;
                    break;
                case "2":
                    // select product method
                    incorrectInput = false;
                    break;
                case "3":
                    // finish transaction method
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
