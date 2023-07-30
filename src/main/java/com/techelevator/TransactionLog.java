package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TransactionLog {
    public BalanceTracker balanceTracker = new BalanceTracker();

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
    // TODO not sure what input to put in lol
    public void printToFile(File transactionLog, String transaction, BigDecimal userInput) {
        NumberFormat numFormat = NumberFormat.getCurrencyInstance();

        try (PrintWriter writer = new PrintWriter(transactionLog)) {
            writer.println(DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a").format(LocalDateTime.now())
                    + " " + transaction + ": " + numFormat.format(userInput) + " "
                    + numFormat.format(balanceTracker.getCurrentBalance()));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
