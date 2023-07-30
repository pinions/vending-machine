package com.techelevator;

import java.util.Scanner;

/*
 * This class is provided to you as a *suggested* class to start
 * your project. Feel free to refactor this code as you see fit.
 */
public class VendingMachineCLI {
	private Scanner scanner = new Scanner(System.in);
	//	private MenuDisplay menuDisplay = new MenuDisplay();
//	private PurchaseMenuDisplay purchaseDisplay = new PurchaseMenuDisplay();
	private InventoryManager inventoryManager = new InventoryManager();

	public static void main(String[] args) {
		VendingMachineCLI cli = new VendingMachineCLI();
		cli.run();
	}

	public void run() {
//		menuDisplay.mainMenu();
//		purchaseDisplay.purchaseMenu();
		while (true) {
			printMainMenu();
			printMenuPrompt();
			String userInput = scanner.nextLine();
			getMainMenu(userInput);
			printReturnMenuPrompt();
		}

		boolean stayOnPurchaseMenu = true;
		while (stayOnPurchaseMenu) {

		}
	}

	public void printMainMenu() {
		System.out.println();
		System.out.println("1) Display Vending Machine Items");
		System.out.println("2) Purchase");
		System.out.println("3) Exit");
	}

	public void printMenuPrompt() {
		System.out.println();
		System.out.println("Please input a value 1 to 3.");
	}

	public void printReturnMenuPrompt() {
		System.out.println();
		System.out.println("Press enter to return to the main menu.");
		scanner.nextLine();
	}

	public void getMainMenu(String userInput) {
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
				getPurchaseMenu();
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
	}

	public void printPurchaseMenu() {
		System.out.println();
		System.out.println("Current Money Provided: " + currentBalance);
		System.out.println();

		System.out.println("1) Feed Money");
		System.out.println("2) Select Product");
		System.out.println("3) Finish Transaction");
	}

	public void getPurchaseMenu(String userInput) {
		switch (userInput) {
			case "1": // feed money into machine in int
				System.out.println();
				System.out.println("Please input a value in whole dollars.");
				userInput = scanner.nextLine();
				feedMoney(userInput);
				break;
			case "2": // purchase
				System.out.println();
				System.out.println("Select a product.");
				productDisplay.productDisplay();
				break;
			case "3": // return to main menu
				System.out.println();
				System.out.println("Thank you for your patronage.");
				stayOnPurchaseMenu = false;
				break;
			default: // catch incorrect input
				System.out.println();
				System.out.println("Invalid input.");
				break;
		}
	}
}
