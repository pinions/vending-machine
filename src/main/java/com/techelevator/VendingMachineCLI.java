package com.techelevator;

import java.text.NumberFormat;
import java.util.List;
import java.util.Scanner;

/*
 * This class is provided to you as a *suggested* class to start
 * your project. Feel free to refactor this code as you see fit.
 */
public class VendingMachineCLI {
	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE };

	private static final String FEED_MONEY = "Feed Money";
	private static final String SELECT_PRODUCT = "Select Product";
	private static final String FINISH_TRANSACTION = "Finish Transaction";

	private static final Scanner scanner = new Scanner(System.in);

	private ProductDisplay productDisplay = new ProductDisplay();
	private InventoryManager inventoryManager = new InventoryManager();
	private PurchaseDisplay purchaseDisplay = new PurchaseDisplay();
	private BalanceTracker balanceTracker = new BalanceTracker();
	private August august = new August();

	private final NumberFormat numberFormat = NumberFormat.getCurrencyInstance();

	private List<Inventory> inventoryList = inventoryManager.getInventoryList();


	public static void main(String[] args) {
		VendingMachineCLI cli = new VendingMachineCLI();
		cli.run();
	}

	public void run() {
		mainMenu();
		purchaseMenu();
		productDisplay.productDisplay();
	}

	public void mainMenu() {
		while (true) {
			System.out.println();
			System.out.println("1) " + MAIN_MENU_OPTION_DISPLAY_ITEMS);
			System.out.println("2) " + MAIN_MENU_OPTION_PURCHASE);
			System.out.println("3) " + MAIN_MENU_EXIT);

			System.out.println();
			System.out.println("Please input a value 1 to 3.");
			String userInput = scanner.nextLine();

			switch (userInput) {
				case "1": // display items
					System.out.println();
					System.out.println("Displaying items.");
					inventoryManager.addToArray();
					inventoryManager.printEachItem();
					break;
				case "2": // purchase
					System.out.println();
					System.out.println("Displaying Purchase Menu.");
					purchaseMenu();
					break;
				case "3": // exit
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

	public void purchaseMenu() {
		boolean stayOnPurchaseMenu = true;
		while (stayOnPurchaseMenu) {
			System.out.println();
			System.out.println("Current Money Provided: " + balanceTracker.getCurrentBalance());
			System.out.println();

			System.out.println("1) " + FEED_MONEY);
			System.out.println("2) " + SELECT_PRODUCT);
			System.out.println("3) " + FINISH_TRANSACTION);

			System.out.println();
			System.out.println("Please input a value 1 to 3.");
			String userInput = scanner.nextLine();

			switch (userInput) {
				case "1": // feed money into machine in int
					System.out.println();
					System.out.println("Please input a value in whole dollars.");
					userInput = scanner.nextLine();
					purchaseDisplay.addCurrentBalance(userInput);
					break;
				case "2": // purchase
					System.out.println();
					System.out.println("Select a product.");
					productDisplay.productDisplay();
					break;
				case "3": // return to main menu
					System.out.println();
					System.out.println("Thank you for your patronage. Dispensing "
							+ balanceTracker.getCurrentBalance() + " in change.");
					stayOnPurchaseMenu = false;
					// TODO how to return to main menu :|
					break;
				default: // catch incorrect input
					System.out.println();
					System.out.println("Invalid input.");
					break;
			}
			System.out.println();
			System.out.println("Press enter to return to the purchase menu.");
			scanner.nextLine();
		}

	}

}
