package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InventoryManager {
    private List<InventoryManager> inventoryList = new ArrayList<>();
    private File inventoryInput = new File("main.csv");
    private final NumberFormat num = NumberFormat.getCurrencyInstance();

    private String itemLocation;
    private String itemName;
    private BigDecimal itemPrice;
    private String itemType;
    private int itemQuantity;

    public InventoryManager() {}
    public InventoryManager(String itemLocation, String itemName, BigDecimal itemPrice, String itemType, int itemQuantity) {
        this.itemLocation = itemLocation;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemType = itemType;
        this.itemQuantity = 5;
    }

    public String getItemLocation() {
        return itemLocation;
    }

    public void setItemLocation(String itemLocation) {
        this.itemLocation = itemLocation;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public void addToArray()
    {
        try (Scanner scanner = new Scanner(inventoryInput))
        {
            // adding item to array
            while (scanner.hasNextLine())
            {
                String item = scanner.nextLine();
                String[] itemArray = item.split(",");
                this.inventoryList.add(new InventoryManager(itemArray[0], itemArray[1], new BigDecimal(itemArray[2]),
                        itemArray[3], itemQuantity));
            }
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void printEachItem()
    {
        // looping through items to print
        for (InventoryManager inventoryItem : inventoryList) {
            if (inventoryItem.getItemQuantity() == 0) {
                System.out.println(inventoryItem.getItemLocation() + "\t" + inventoryItem.getItemName() + "\t"
                        + num.format(inventoryItem.getItemPrice()) + "\t" + inventoryItem.getItemType() + "\t"
                        + " SOLD OUT");
            } else {
                System.out.println(inventoryItem.getItemLocation() + "\t" + inventoryItem.getItemName() + "\t"
                        + num.format(inventoryItem.getItemPrice()) + "\t" + inventoryItem.getItemType() + "\t"
                        + inventoryItem.getItemQuantity());
            }
        }
    }

    public List<InventoryManager> getInventoryList() {
        return inventoryList;
    }

    public int subtractItemQuantity() {
        itemQuantity -= 1;
        return getItemQuantity();
    }

}