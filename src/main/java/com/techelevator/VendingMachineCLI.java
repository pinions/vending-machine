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

	private static final String FEED_MONEY = "Feed Money";
	private static final String SELECT_PRODUCT = "Select Product";
	private static final String FINISH_TRANSACTION = "Finish Transaction";

	private static final Scanner scanner = new Scanner(System.in);

	private InventoryManager inventoryManager = new InventoryManager();
	private List<InventoryManager> inventoryList = inventoryManager.getInventoryList();
	private BalanceTracker balanceTracker = new BalanceTracker();
	private August august = new August();

	private final NumberFormat numberFormat = NumberFormat.getCurrencyInstance();

	public static void main(String[] args) {
		VendingMachineCLI cli = new VendingMachineCLI();
		cli.run();
	}

	public void run() {
		mainMenu();
		purchaseMenu();
		productDisplay();
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
			System.out.println("Current Money Provided: " + numberFormat.format(balanceTracker.getCurrentBalance()));
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
					balanceTracker.feedMoney(userInput);
					break;
				case "2": // purchase
					System.out.println();
					System.out.println("Select a product.");
					productDisplay();
					break;
				case "3": // return to main menu
					System.out.println();
					System.out.println("Thank you for your patronage. Dispensing "
							+ balanceTracker.getCurrentBalance() + " in change.");
					balanceTracker.subtractCurrentBalance(balanceTracker.getCurrentBalance());
					stayOnPurchaseMenu = false;
					// TODO how to return to main menu without extra step :|
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

	public void productDisplay() {
		inventoryManager.addToArray();
		inventoryManager.printEachItem();

		System.out.println();
		System.out.println("Please input the location of your purchase.");

		String userInput = scanner.nextLine();
		purchaseProduct(userInput);
	}

	// TODO check for value in array and catch invalid input without printing for whole list
	// TODO honestly this is way too complicated and needs to be broken up but idk how
	// TODO BOGODO is in another class but there has to be a cleaner way to implement it?
	public void purchaseProduct(String userInput) {
		for (InventoryManager inventoryItem : inventoryList) {
			if (userInput.equals(inventoryItem.getItemLocation())
					&& inventoryItem.getItemQuantity() > 0
					&& balanceTracker.getCurrentBalance().compareTo(inventoryItem.getItemPrice()) >= 0) {
				inventoryItem.subtractItemQuantity();
				System.out.println();
				System.out.println("Thank you for your purchase! Please enjoy your "
						+ inventoryItem.getItemName() + ".");
				balanceTracker.subtractItemPriceFromBalance(august.isAugust(),
						august.getAugustCounter(), inventoryItem);
				messageToDisplay(inventoryItem);
				break;
			} else if (userInput.equals(inventoryItem.getItemLocation())
					&& inventoryItem.getItemQuantity() == 0) {
				System.out.println("Sorry! " + inventoryItem.getItemName()
						+ " is currently sold out.");
				break;
			} else if (balanceTracker.getCurrentBalance().compareTo(inventoryItem.getItemPrice()) < 0) {
				System.out.println("Sorry! You don't have enough money.");
				break;
			}
		}
	}

	public void messageToDisplay(InventoryManager inventoryItem) {
		if (inventoryItem.getItemType().equalsIgnoreCase("gum")) {
			String gumMessage = "Chew Chew, Yum!";
			System.out.println(gumMessage);
		} else if (inventoryItem.getItemType().equalsIgnoreCase("drink")) {
			String drinkMessage = "Glug Glug, Yum!";
			System.out.println(drinkMessage);
		} else if (inventoryItem.getItemType().equalsIgnoreCase("candy")) {
			String candyMessage = "Yummy Yummy, So Sweet!";
			System.out.println(candyMessage);
		} else {
			String munchyMessage = "Crunch Crunch, Yum!";
			System.out.println(munchyMessage);
		}
	}

}
