package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InventoryManager {
    private List<Inventory> inventoryList = new ArrayList<>();
    private final Scanner userInput = new Scanner(System.in);
//    Inventory inventory = new Inventory();

    public static void main(String[] args) {
        InventoryManager inventoryManager = new InventoryManager();
        inventoryManager.run();
    }

    public void run() {
        File inventoryInput = new File("main.csv");

        try (Scanner userInput = new Scanner(inventoryInput)) {
            while (userInput.hasNextLine()) {
                String line = userInput.nextLine();
                line.split(",");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        addInventory();
        for (Inventory inventoryItem : inventoryList) {
            System.out.println(inventoryItem.getItemLocation() + "\t" + inventoryItem.getItemName() + "\t"
                    + inventoryItem.getItemPriceAsCurrency() + "\t" + inventoryItem.getItemType() + "\t"
                    + inventoryItem.getItemQuantity());
        }
    }

    private void addInventory() { // edit this to pull from main.csv
        this.inventoryList.add(new Inventory("A1", "U-Chews",
                BigDecimal.valueOf(1.65), "Gum", 5));
        this.inventoryList.add(new Inventory("A2", "Ginger Ayle",
                BigDecimal.valueOf(1.85), "Drink", 5));
        this.inventoryList.add(new Inventory("A3", "Snykkers",
                BigDecimal.valueOf(4.25), "Candy", 5));
    }

}
