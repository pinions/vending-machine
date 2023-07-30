package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TransactionLog {
    private Inventory inventory = new Inventory();
    private InventoryManager inventoryManager = new InventoryManager();

    // TODO do they want this to be a new file every time?
    public void createFile() {
        File transactionLog = new File("transaction-log.txt");
        try {
            transactionLog.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println();
        System.out.println("File located at " + transactionLog.getName());

    }

    // TODO not sure how to get the amount deposited, spent, or given as change
    // TODO new balance seems easier but who knows
    public void printToFile(File transactionLog, String userInput) {
        NumberFormat numFormat = NumberFormat.getCurrencyInstance();

        try (PrintWriter writer = new PrintWriter(transactionLog)) {
            writer.println(DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a").format(LocalDateTime.now())
                    + " FEED MONEY: " + numFormat.format(userInput) + " "
                    + numFormat.format(inventory.getItemPrice()));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
