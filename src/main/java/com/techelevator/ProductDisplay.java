package com.techelevator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ProductDisplay {
    private static final Scanner scanner = new Scanner(System.in);

    private Inventory inventory = new Inventory();
    private int itemQuantity = inventory.getItemQuantity();
    private InventoryManager inventoryManager = new InventoryManager();
    private List<Inventory> inventoryList = inventoryManager.getInventoryList();
    private BalanceTracker balanceTracker = new BalanceTracker();
    private BigDecimal currentBalance = balanceTracker.getCurrentBalance();

    public void productDisplay() {
        inventoryManager.addToArray();
        inventoryManager.printEachItem();

        System.out.println();
        System.out.println("Please input the location of your purchase.");
        String userInput = scanner.nextLine();
        purchaseProduct(userInput);
    }

    public void purchaseProduct(String userInput) {
        for (Inventory inventoryItem : inventoryList) {
            if (userInput.equals(inventoryItem.getItemLocation())
                    && inventoryItem.getItemQuantity() > 0
                    && currentBalance.compareTo(inventoryItem.getItemPrice()) >= 0) {
                itemQuantity--;
                System.out.println("Thank you for your purchase! Please enjoy your "
                        + inventoryItem.getItemName());
                messageToDisplay(inventoryItem);
            } else if (userInput.equals(inventoryItem.getItemLocation())
                    && inventoryItem.getItemQuantity() == 0) {
                System.out.println("Sorry! " + inventoryItem.getItemName()
                        + " is currently sold out.");
            }
            System.out.println(inventoryItem.getItemLocation() + " " + inventoryItem.getItemQuantity() + " " + currentBalance + " " + inventoryItem.getItemPrice());
            System.out.println("Invalid input.");
        }
    }

    public void messageToDisplay(Inventory inventoryItem) {
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
