package com.techelevator;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class ProductDisplay extends BalanceTracker {
    private Inventory inventory = new Inventory();
    private int itemQuantity = inventory.getItemQuantity();
    private InventoryManager inventoryManager = new InventoryManager();
    private List<Inventory> inventoryList = inventoryManager.getInventoryList();
    private static final Scanner scanner = new Scanner(System.in);

    public void productDisplay() {
        inventoryManager.addToArray();
        inventoryManager.printEachItem();

        System.out.println();
        System.out.println("Please input the location of your purchase.");

        String userInput = scanner.nextLine();
        purchaseProduct(userInput);
    }

    // TODO check for value in array and catch invalid input without printing for whole list
    // TODO figure out how to update price across classes bc getCurrentBalance() isn't doing it rn
    // TODO likewise quantity values aren't updating and it isn't tracking the number of purchases
    // TODO honestly this is way too complicated and needs to be broken up but idk how
    public void purchaseProduct(String userInput) {
        int augustCounter = 0;

        for (Inventory inventoryItem : inventoryList) {
            if (userInput.equals(inventoryItem.getItemLocation())
                    && inventoryItem.getItemQuantity() > 0) {
                itemQuantity--;
                augustCounter++;
                System.out.println("Thank you for your purchase! Please enjoy your "
                        + inventoryItem.getItemName() + ".");
                messageToDisplay(inventoryItem);
                System.out.println();
                System.out.println(inventoryItem.getItemName() + " cost " + getDollarOff(augustCounter, inventoryItem)
                        + ". You now have " + subtractCurrentBalance(getDollarOff(augustCounter, inventoryItem)) + ".");
                break;
            } else if (userInput.equals(inventoryItem.getItemLocation())
                    && inventoryItem.getItemQuantity() == 0) {
                System.out.println("Sorry! " + inventoryItem.getItemName()
                        + " is currently sold out.");
                break;
            }
//            remove this once done
//            System.out.println(inventoryItem.getItemLocation() + " " + inventoryItem.getItemQuantity()
//                    + " " + getCurrentBalance() + " " + inventoryItem.getItemPrice());
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

    public BigDecimal getDollarOff(int augustCounter, Inventory inventoryItem) {
        BigDecimal inventoryPrice = inventoryItem.getItemPrice();
        if (augustCounter % 2 == 0) {
            inventoryPrice = inventoryItem.getItemPrice().subtract(BigDecimal.valueOf(1));
        } else {
            return inventoryPrice;
        }
        return inventoryPrice;
    }

}
