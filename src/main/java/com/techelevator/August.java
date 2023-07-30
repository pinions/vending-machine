package com.techelevator;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

public class August extends ProductDisplay {
    private Inventory inventory = new Inventory();
    private int itemQuantity = inventory.getItemQuantity();
    private InventoryManager inventoryManager = new InventoryManager();
    private List<Inventory> inventoryList = inventoryManager.getInventoryList();

    public boolean isAugust() {
        return Calendar.getInstance().get(Calendar.MONTH) == Calendar.AUGUST;
    }

    @Override
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
                System.out.println(inventoryItem.getItemName() + " cost " + inventoryItem.getItemPrice()
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
