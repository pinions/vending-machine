package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
	private static final Scanner scanner = new Scanner(System.in);

	private InventoryManager inventoryManager = new InventoryManager();
	private PurchaseMenuDisplay purchaseMenu = new PurchaseMenuDisplay();
	private BalanceTracker balanceTracker = new BalanceTracker();

	private int currentMoney = 0;

//	private static int currentMoney = 0;

	public static void main(String[] args) {
		VendingMachineCLI cli = new VendingMachineCLI();
		cli.run();
	}

	public void run() {
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
					inventoryManager.createInventory();
					break;
				case "2": // purchase
					System.out.println();
					System.out.println("Displaying Purchase Menu.");
					purchaseMenu.purchaseMenu();
					break;
				case "3": // exit
					System.out.println();
					System.out.println("Thank you for your patronage. Goodbye!");
					System.exit(1);
					break;
				default: // catch incorrect input
					System.out.println();
					System.out.println("Please input a value 1 to 3.");
					scanner.nextLine();
					break;
			}
			System.out.println();
			System.out.println("Press any key to return to the main menu.");
			scanner.nextLine();
		}
	}

		public void purchaseMenu() {
		while (true) {
			System.out.println();
			System.out.println("Current Money Provided: " + currentMoney);
			System.out.println();

			System.out.println("1) Feed Money");
			System.out.println("2) Select Product");
			System.out.println("3) Finish Transaction");

			System.out.println();
			System.out.println("Please input a value 1 to 3.");
			String userInput = scanner.nextLine();

			switch (userInput) {
				case "1": // feed money into machine in int
					System.out.println();
					System.out.println("Please input a value in whole dollars.");
					feedMoney();
					break;
				case "2": // purchase
					System.out.println();
					System.out.println("Select a product.");
					// method here
					break;
				case "3": // exit
					System.out.println();
					System.out.println("Thank you for your patronage. Goodbye!");
					System.exit(1);
					break;
				default: // catch incorrect input
					System.out.println();
					System.out.println("Please input a value 1 to 3.");
					userInput = scanner.nextLine();
					break;
			}
			System.out.println();
			System.out.println("Press any key to return to the purchase menu.");
			userInput = scanner.nextLine();
		}
	}

	public void feedMoney() {
		String userInput = scanner.nextLine();

		if (scanner.hasNextInt()) {
			int inputMoney = Integer.parseInt(scanner.nextLine());
			currentMoney += inputMoney;
			userInput = scanner.nextLine();

			System.out.println("Current Money Provided: " + currentMoney);
		} else {
			System.out.println();
			System.out.println("Please input a value in whole dollars.");
		}
	}

}
