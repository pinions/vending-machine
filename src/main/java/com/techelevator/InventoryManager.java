package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InventoryManager {
    private List<Inventory> inventoryList = new ArrayList<>();
    private static int itemQuantity = 5;
    private File inventoryInput = new File("main.csv");

    public void addToArray()
    {
        try (Scanner scanner = new Scanner(inventoryInput))
        {
            // adding item to array
            while (scanner.hasNextLine())
            {
                String item = scanner.nextLine();
                String[] itemArray = item.split(",");
                this.inventoryList.add(new Inventory(itemArray[0], itemArray[1], new BigDecimal(itemArray[2]),
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
        for (Inventory inventory : inventoryList)
        {
            System.out.println(inventory.getItemLocation() + "\t" + inventory.getItemName() + "\t"
                    + inventory.getItemPrice() + "\t" + inventory.getItemType() + "\t"
                    + inventory.getItemQuantity());
        }
    }

    public List<Inventory> getInventoryList() {
        return inventoryList;
    }
}