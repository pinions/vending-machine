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
	private List<Inventory> inventoryList = new ArrayList<>();
	private static final Scanner scanner = new Scanner(System.in);
	private static int defaultItemQuantity = 5;

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
					createInventory();
					break;
				case "2": // purchase
					System.out.println();
					System.out.println("Displaying Purchase Menu.");
					break;
				case "3": // exit
					System.out.println();
					System.out.println("Thank you for your patronage. Goodbye!");
					System.exit(1);
				default: // catch incorrect input
					System.out.println();
					System.out.println("Please input a value 1 to 3.");
					userInput = scanner.nextLine();
					break;
			}
			System.out.println();
			System.out.println("Press any key to return to the main menu.");
			userInput = scanner.nextLine();
		}
	}

	public void createInventory() {
		File inventoryInput = new File("main.csv");

		try (Scanner scanner = new Scanner(inventoryInput)) {
			// adding item to array
			while (scanner.hasNextLine()) {
				String item = scanner.nextLine();
				String[] itemArray = item.split(",");
				this.inventoryList.add(new Inventory(itemArray[0], itemArray[1], Double.parseDouble(itemArray[2]),
						itemArray[3], defaultItemQuantity));
			}
			// looping through items to print
			for (Inventory inventory : inventoryList) {
				System.out.println(inventory.getItemLocation() + "\t" + inventory.getItemName() + "\t"
						+ inventory.getItemPrice() + "\t" + inventory.getItemType() + "\t"
						+ inventory.getItemQuantity());
			}
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public void purchaseItem() {

	}
}
