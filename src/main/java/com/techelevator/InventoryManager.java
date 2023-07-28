package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InventoryManager {
    private List<Inventory> inventoryList = new ArrayList<>();
    private static int itemQuantity = 5;

    public void createInventory() {
        File inventoryInput = new File("main.csv");

        try (Scanner scanner = new Scanner(inventoryInput)) {
            // adding item to array
            while (scanner.hasNextLine()) {
                String item = scanner.nextLine();
                String[] itemArray = item.split(",");
                this.inventoryList.add(new Inventory(itemArray[0], itemArray[1], Double.parseDouble(itemArray[2]),
                        itemArray[3], itemQuantity));
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

}
