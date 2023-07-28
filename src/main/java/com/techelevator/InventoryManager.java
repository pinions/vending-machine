package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

<<<<<<< HEAD
<<<<<<< HEAD
public class InventoryManager {
    private List<Inventory> inventoryList = new ArrayList<>();
    private static int itemQuantity = 5;

    public void createInventory() {
        File inventoryInput = new File("main.csv");

        try (Scanner scanner = new Scanner(inventoryInput)) {
            // adding item to array
            while (scanner.hasNextLine()) {
=======
public class InventoryManager
{
=======
public class InventoryManager {
>>>>>>> 558f6fb0d7a16e80cc7f8816c818b8de527f731f
    private List<Inventory> inventoryList = new ArrayList<>();
    private static int itemQuantity = 5;

    public void createInventory() {
        File inventoryInput = new File("main.csv");

        try (Scanner scanner = new Scanner(inventoryInput)) {
            // adding item to array
<<<<<<< HEAD
            while (scanner.hasNextLine())
            {
>>>>>>> cfdf6d48c8633a6c89bae45f93821278c32c2c4a
=======
            while (scanner.hasNextLine()) {
>>>>>>> 558f6fb0d7a16e80cc7f8816c818b8de527f731f
                String item = scanner.nextLine();
                String[] itemArray = item.split(",");
                this.inventoryList.add(new Inventory(itemArray[0], itemArray[1], Double.parseDouble(itemArray[2]),
                        itemArray[3], itemQuantity));
<<<<<<< HEAD
=======
            }
            // looping through items to print
            for (Inventory inventory : inventoryList) {
                System.out.println(inventory.getItemLocation() + "\t" + inventory.getItemName() + "\t"
                        + inventory.getItemPrice() + "\t" + inventory.getItemType() + "\t"
                        + inventory.getItemQuantity());
>>>>>>> cfdf6d48c8633a6c89bae45f93821278c32c2c4a
            }
<<<<<<< HEAD
            // looping through items to print
            for (Inventory inventory : inventoryList) {
                System.out.println(inventory.getItemLocation() + "\t" + inventory.getItemName() + "\t"
                        + inventory.getItemPrice() + "\t" + inventory.getItemType() + "\t"
                        + inventory.getItemQuantity());
            }
=======
>>>>>>> 558f6fb0d7a16e80cc7f8816c818b8de527f731f
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
